package com.natixis.cco.upconnect.rest.services.dcrl;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.UPConnector;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelnfi.dcrl.DCrlV1;
import com.natixis.cco.upconnect.modelnfi.dcrl.InputDCrlV1;
import com.natixis.cco.upconnect.rest.tech.objets.ErreurReponse;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/dcrl")
@Api(value="/dcrl", description="Service de simulation du moteur de calcul UP")
public class ServiceDCrl {
	
	private static final Logger LOG = LoggerFactory.getLogger("FILE");
	
	@Inject
	UPConnector upconnect;

	public ServiceDCrl() {}
	
	@POST
	@Path("/version1")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="calculerDCrl",notes="Appel au moteur de calcul DCRL")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Succès"),
			@ApiResponse(code=400, message="Données en entrée incorrectes"),
			@ApiResponse(code=500, message="Erreur technique")
		}
		)
	public Response calculerDCrlV1(
			@ApiParam(value = "Données de calcul", required = true) InputDCrlV1 request){
		DCrlV1 response = new DCrlV1();

		try {
			response = upconnect.calculDCrlV1(request);
			return Response.status(200).entity(response).build();
		} catch (ConverterException e) {
			LOG.error("Erreur de conversion DCrlV1 sur le champ "+e.getField());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}catch(InputValuesException ive){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour("-");
			erreurReponse.setMessage(ive.getMessage());
			erreurReponse.setVersionUPConnectService("DCrlV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.BAD_REQUEST).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		
	
	}
}
