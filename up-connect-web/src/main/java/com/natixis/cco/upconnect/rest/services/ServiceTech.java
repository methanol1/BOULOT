package com.natixis.cco.upconnect.rest.services;

import java.lang.reflect.Field;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bnpp.pf.lib.ctgrelay.client.protocol.ConnectionFactory;
import com.natixis.cco.upconnect.UPConnector;
import com.natixis.cco.upconnect.controller.InfosServices;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.manager.VersionService;
import com.natixis.cco.upconnect.rest.tech.objets.DetailConnexionBouchon;
import com.natixis.cco.upconnect.rest.tech.objets.DetailConnexionUP;
import com.natixis.cco.upconnect.rest.tech.objets.DetailInfos;
import com.natixis.cco.upconnect.rest.tech.objets.DetailService;
import com.natixis.cco.upconnect.rest.tech.objets.EtatUPConnect;
import com.natixis.financement.middlesav.commun.config.annotations.UnitedConnectionFactory;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/tech")
@Api(value = "/tech", description = "Informations techniques sur les services UP-CONNECT")
public class ServiceTech {

	private static DetailInfos details;

	private static final ResourceBundle bundle = ResourceBundle
			.getBundle("upconnect");

	static {
		details = new DetailInfos();
		details.setNumeroBaseline(bundle.getString("baseline.version"));
	}

	@Inject
	@UnitedConnectionFactory
	private ConnectionFactory factory;

	@Inject
	UPConnector upconnect;
	
	private final Logger sondeLogger = LoggerFactory.getLogger("sonde");

	public ServiceTech() {
	}

	@GET
	@Path("/infos")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Infos", notes = "Informations techniques sur la brique UP-CONNECT et vérification qu'UP répond bien.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Succès"),
			@ApiResponse(code = 500, message = "Erreur technique") })
	public Response getInfos() {

		EtatUPConnect etat = new EtatUPConnect();
		etat.setBaseline(details.getNumeroBaseline());

		// Si l'application est déployée en mode connecté
		if ("UP".equals(bundle.getString("backend.mode"))) {
			DetailConnexionUP detailConnexion = new DetailConnexionUP();
			detailConnexion.setCics(factory.getCics());
			detailConnexion.setUrl(factory.getUrl());
			detailConnexion.setUser(factory.getUserName());
			detailConnexion.setUpDispo(false);
			
			//On vérifie ici qu'UP répond bien:
			try{
				upconnect.getContratV2("11111111111111");
			}
			catch(ContratNonTrouveBusinessException cntbe){
				detailConnexion.setUpDispo(true);
			} catch (ConverterException e) {
				detailConnexion.setUpDispo(true);
				sondeLogger.warn("la sonde Contrat V2 ne devrait pas lever de ConverterException.");
			} catch(SavTechnicalException ste){
				detailConnexion.setUpDispo(true);
				sondeLogger.warn("la sonde Contrat V2 ne devrait pas lever de SavTechnicalException.");
			} catch(Exception e){
				sondeLogger.error("la sonde Contrat V2 ne devrait pas lever de "+e.getCause());
			}
			etat.setConnexion(detailConnexion);
		}
		else if ("UPMOCK".equals(bundle.getString("backend.mode"))) {
			etat.setConnexion(new DetailConnexionBouchon());
		}

		return Response.status(200).entity(etat).build();
	}

	@GET
	@Path("/services")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Service", notes = "Informations de contenu et de version sur les services UP-CONNECT")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Succès"),
			@ApiResponse(code = 500, message = "Erreur technique") })
	public Response getServices() {
		Map<String, InfosServices> map = upconnect.getVersions();
		Map<String, Map<String, DetailService>> res = new Hashtable<String, Map<String, DetailService>>();

		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			InfosServices is = map.get(type);
			Map<String, DetailService> objets = new Hashtable<String, DetailService>();
			for (Iterator<VersionService> iterator2 = is.getServices()
					.iterator(); iterator2.hasNext();) {
				DetailService detail = new DetailService();
				VersionService version = (VersionService) iterator2.next();
				detail.setVersionUP(version.getVersionUP());
				List<Field> fields = Arrays.asList(version.getContent()
						.getDeclaredFields());
				List<String> fieldsnames = new ArrayList<String>();
				for (int i = 0; i < fields.size(); i++) {
					if (!fields.get(i).getName().equals("header")) {
						fieldsnames.add(fields.get(i).getName());
					}
				}
				Collections.sort(fieldsnames);
				detail.setChamps(fieldsnames);

				objets.put(version.getVersionMiddleConnect(), detail);
			}

			res.put(type, objets);
		}

		Map<String, Map<String, Map<String, DetailService>>> etatServices = new Hashtable<String, Map<String, Map<String, DetailService>>>();
		etatServices.put("Ensemble des services", res);

		return Response.status(200).entity(etatServices).build();
	}

}
