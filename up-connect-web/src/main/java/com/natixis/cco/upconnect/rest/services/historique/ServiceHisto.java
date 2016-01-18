package com.natixis.cco.upconnect.rest.services.historique;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.UPConnector;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelnfi.historique.HistoV1;
import com.natixis.cco.upconnect.modelnfi.historique.InputHistoV1;
import com.natixis.cco.upconnect.rest.tech.objets.ErreurReponse;
import com.natixis.financement.middlesav.commun.exceptions.HistoriqueNonTrouveException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/historique")
@Api(value = "/historique", description = "Service Historique des opérations financières")
public class ServiceHisto {

	private static final Logger LOG = LoggerFactory.getLogger("FILE");

	@Inject
	UPConnector upconnect;

	public ServiceHisto() {
	}

	@GET
	@Path("/version1/{numeroContrat}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@ApiOperation(value = "HistoV1", notes = "Historique des opérations comptables ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Succès"),
			@ApiResponse(code = 400, message = "Données en entrée incorrectes"),
			@ApiResponse(code = 404, message = "Historiques non trouvés"),
			@ApiResponse(code = 500, message = "Erreur technique") })
	public Response historiques(
			@ApiParam(value = "Le numéro du dossier", required = true) @PathParam("numeroContrat") String numeroContrat,
			@ApiParam(value = "Timestamp de l’opération comptable", required = true) @QueryParam("idOperation") String idOperation,
			@ApiParam(value = "Nombre d’opérations à restituer", required = true) @QueryParam("nombreOperationMaxARestituer") int nombreOperationMaxARestituer,
			@ApiParam(value = "Sens de la restitution", required = true) @QueryParam("sensRestitution") String sensRestitution) {
		HistoV1 response = new HistoV1();

		try {
			InputHistoV1 request = new InputHistoV1(numeroContrat, idOperation,
					nombreOperationMaxARestituer, sensRestitution);
			response = upconnect.historiques(request);
			return Response.status(200).entity(response).build();
		} catch (InputValuesException ive) {
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour("-");
			erreurReponse.setMessage(ive.getMessage());
			erreurReponse.setVersionUPConnectService("HistoV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(erreurReponse).type(MediaType.APPLICATION_JSON)
					.build();
		} catch (ConverterException e) {
			LOG.error("Erreur de conversion HistoV1 sur le champ "
					+ e.getField());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		} catch (HistoriqueNonTrouveException e) {
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour(e.getCodeUP());
			erreurReponse.setMessage("Historiques non trouvés");
			erreurReponse.setVersionUPConnectService("HistoV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(erreurReponse).type(MediaType.APPLICATION_JSON)
					.build();
		}
	}
}
