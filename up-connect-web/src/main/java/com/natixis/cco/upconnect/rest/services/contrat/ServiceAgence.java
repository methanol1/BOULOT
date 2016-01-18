package com.natixis.cco.upconnect.rest.services.contrat;

import javax.inject.Inject;
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
import com.natixis.cco.upconnect.modelnfi.agence.AgenceV1;
import com.natixis.cco.upconnect.rest.tech.objets.ErreurReponse;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;



@Path("/agences")
@Api(value="/agences", description="Services Contrat bloc Agence UP")
public class ServiceAgence {
	private static final Logger LOG = LoggerFactory.getLogger("FILE");
	
	@Inject
	UPConnector upconnect;

	public ServiceAgence() {}
	
	@GET
	@Path("/version1/{agence}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="AgenceV1", notes="Restitution des données du bloc Agence du contrat en Version 1")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Succès"),
		@ApiResponse(code=400, message="Données en entrée incorrectes"),
		@ApiResponse(code=404, message="Agence non trouvée. Correspond aux codes DAGE03,DAGE05"),
		@ApiResponse(code=500, message="Erreur technique")
	}
	)
	public Response getAgenceV1(
			@ApiParam(value="Le numéro de l'agence", required=true) @PathParam("agence") String codeAgence){
		AgenceV1 agence = null;
		try {
			agence = upconnect.getAgenceV1(codeAgence);
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
			LOG.error("Erreur de conversion AgenceV1 sur le champ "+e.getField());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		catch(AgenceNonTrouveBusinessException cnte){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour(cnte.getCodeUP());
			erreurReponse.setMessage("Agence non trouvée");
			erreurReponse.setVersionUPConnectService("AgenceV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.NOT_FOUND).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(200).entity(agence).build();
	}
	
	
}
