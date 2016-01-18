package com.natixis.cco.upconnect.rest.services.contrat;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.UPConnector;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelnfi.assurance.AssuranceV1;
import com.natixis.cco.upconnect.rest.tech.objets.ErreurReponse;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;



@Path("/assurances")
@Api(value="/assurances", description="Services Contrat bloc Assurance UP")
public class ServiceAssurance {
	
	private static final Logger LOG = LoggerFactory.getLogger("FILE");
	
	@Inject
	UPConnector upconnect;

	public ServiceAssurance() {}
	
	@GET
	@Path("/version1/{dossier}/{dateparam}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="AssuranceV1", notes="Restitution des données du bloc Assurance du contrat en Version 1")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Succès"),
		@ApiResponse(code=400, message="Données en entrée incorrectes"),
		@ApiResponse(code=404, message="Contrat non trouvé. Correspond aux codes DASU13,DASU15,DASU17,DASU19,DASU52,DASU54,DASU58,DASU60"),
		@ApiResponse(code=500, message="Erreur technique")
	}
	)
	public Response getAssuranceV1(
			@ApiParam(value="Le numéro du dossier", required=true) @PathParam("dossier") String dossier, 
			@ApiParam(value="La date ...", required=true) @PathParam("dateparam") String dateParam){
		AssuranceV1 assurance = null;
		try {
			assurance = upconnect.getAssuranceV1(dossier, dateParam);
		} 
		catch(InputValuesException ive){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour("-");
			erreurReponse.setMessage(ive.getMessage());
			erreurReponse.setVersionUPConnectService("AssuranceV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.BAD_REQUEST).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		catch (ConverterException e) {
			LOG.error("Erreur de conversion AssuranceV1 sur le champ "+e.getField());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		catch(ContratNonTrouveBusinessException cnte){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour(cnte.getCodeUP());
			erreurReponse.setMessage("Contrat non trouvé");
			erreurReponse.setVersionUPConnectService("AssuranceV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.NOT_FOUND).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(200).entity(assurance).build();
	}
	
}
