package com.natixis.cco.upconnect.rest.services.dmen;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.UPConnector;
import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelnfi.dmen.DMenV1;
import com.natixis.cco.upconnect.modelnfi.dmen.InputDMenV1;
import com.natixis.cco.upconnect.rest.tech.objets.ErreurReponse;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.natixis.financement.middlesav.commun.exceptions.SocieteNonTrouveException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;



@Path("/dmen")
@Api(value="/dmen", description="Service d'appel au moteur de calcul UP")
public class ServiceDMen {
	
	private static final Logger LOG = LoggerFactory.getLogger("FILE");
	
	@Inject
	UPConnector upconnect;

	public ServiceDMen() {}
	
	@POST
	@Path("/version1")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="calculerDMen",notes="Appel au moteur de calcul DMEN")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Succès"),
			@ApiResponse(code=400, message="Données en entrée incorrectes"),
			@ApiResponse(code=404, message="Dossier ou société non trouvé. Correspond aux codes DMEN28, DMEN29, DMEN30, DMEN31, DMEN32"),
			@ApiResponse(code=500, message="Erreur technique")
		}
		)
	public Response calculerDMenV1(
			@ApiParam(value = "Données de calcul", required = true) InputDMenV1 request){
		LOG.debug(request.toString());
		
		try {
			DMenV1 response = upconnect.calculMens1(request);
			return Response.status(200).entity(response).build();
		} 
		catch(InputValuesException ive){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour("-");
			erreurReponse.setMessage(ive.getMessage());
			erreurReponse.setVersionUPConnectService("DMenV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.BAD_REQUEST).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		catch (ConverterException e) {
			LOG.error("Erreur de conversion DMenV1 sur le champ "+e.getField());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}catch (ContratNonTrouveBusinessException e) {
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour(e.getCodeUP());
			erreurReponse.setMessage("Contrat non trouvé");
			erreurReponse.setVersionUPConnectService("DMenV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.NOT_FOUND).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		} catch (SocieteNonTrouveException e) {
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour(e.getCodeUP());
			erreurReponse.setMessage("Société non trouvée");
			erreurReponse.setVersionUPConnectService("DMenV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.NOT_FOUND).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		
	}
}
