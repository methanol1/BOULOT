package com.natixis.cco.upconnect.rest.services.contrat;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.UPConnector;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelnfi.rachat.RachatV1;
import com.natixis.cco.upconnect.rest.codes.UPConnectResponse;
import com.natixis.cco.upconnect.rest.tech.objets.ErreurReponse;
import com.natixis.cco.upconnect.service.rachat.up1.RachatUP1Service;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.natixis.financement.middlesav.commun.exceptions.RachatBusinessException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/rachats")
@Api(value = "/rachats", description = "Services Contrat bloc Rachat UP")
public class ServiceRachat {
	private static final Logger LOG = LoggerFactory.getLogger("FILE");
	@Inject
	UPConnector upconnect;

	public ServiceRachat() {
	}

	/**
	 * 
	 * @param dossier
	 *            numéro de dossier sur 14
	 * @param date
	 *            date
	 * @return
	 */
	@GET
	@Path("/version1/{dossier}/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "RachatV1", notes = "Restitution des données du bloc rachat du contrat en Version 1")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Succès"),
			@ApiResponse(code = 400, message = "Données en entrée incorrectes"),
			@ApiResponse(code = 420, message = "Problème de calcul IRA."),
			@ApiResponse(code = 421, message = "Date rachat invalide."),
			@ApiResponse(code = 500, message = "Erreur technique") })
	public Response getRachatV1(
			@ApiParam(value = "Le numéro du dossier", required = true) @PathParam("dossier") String dossier,
			@ApiParam(value = "La date de rachat", required = false, defaultValue = "01.01.0001") @PathParam("date") @DefaultValue("01.01.0001") String date) {

		RachatV1 rachat = null;
		try {
			rachat = upconnect.getRachatV1(dossier, date);
		}
		catch(InputValuesException ive){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour("-");
			erreurReponse.setMessage(ive.getMessage());
			erreurReponse.setVersionUPConnectService("AgenceV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.BAD_REQUEST).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		catch (ConverterException e) {
			LOG.error("Erreur de conversion RachatV1 sur le champ "
					+ e.getField());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		} catch (RachatBusinessException rbe) {
			if (rbe.getCodeUP().equals(RachatUP1Service.codesRachatPbCalcul)) {
				ErreurReponse erreurReponse = new ErreurReponse();
				erreurReponse.setCodeRetour(rbe.getCodeUP());
				erreurReponse.setMessage("Problème de calcul IRA");
				erreurReponse.setVersionUPConnectService("RachatV1");
				erreurReponse.setVersionUPService("UP V1");
				return Response
						.status(UPConnectResponse.UPConnectStatus.RACHAT_CALCUL_ERROR
								.getStatusCode()).entity(erreurReponse)
						.type(MediaType.APPLICATION_JSON).build();
			} else if (rbe.getCodeUP().equals(RachatUP1Service.dateInvalide)) {
				ErreurReponse erreurReponse = new ErreurReponse();
				erreurReponse.setCodeRetour(rbe.getCodeUP());
				erreurReponse.setMessage("Date rachat invalide");
				erreurReponse.setVersionUPConnectService("RachatV1");
				erreurReponse.setVersionUPService("UP V1");
				return Response
						.status(UPConnectResponse.UPConnectStatus.DATE_INVALIDE
								.getStatusCode()).entity(erreurReponse)
						.type(MediaType.APPLICATION_JSON).build();
			}
			LOG.error("RachatBusinessException de code UP non connu : "
					+ rbe.getMessage());
			throw new WebApplicationException(
					Response.Status.INTERNAL_SERVER_ERROR);
		}
		return Response.status(200).entity(rachat).build();
	}

}
