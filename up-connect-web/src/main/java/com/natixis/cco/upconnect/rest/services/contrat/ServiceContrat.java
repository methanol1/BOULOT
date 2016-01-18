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
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV1;
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV2;
import com.natixis.cco.upconnect.rest.tech.objets.ErreurReponse;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;



@Path("/contrats")
@Api(value="/contrats", description="Services Contrat bloc Dossier UP")
public class ServiceContrat {
	
	private static final Logger LOG = LoggerFactory.getLogger("FILE");
	
	@Inject
	UPConnector upconnect;

	public ServiceContrat() {}
	
	@GET
	@Path("/version1/{dossier}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="ContratV1", notes="Restitution des données d'un contrat en Version 1")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Succès"),
		@ApiResponse(code=400, message="Données en entrée incorrectes"),
		@ApiResponse(code=404, message="Contrat non trouvé. Correspond aux codes DCTR04,DCTR08,DCTR10,DCTR12,DCTR14,DCTR16,DCTR18,DCTR22,DCTR36"),
		@ApiResponse(code=500, message="Erreur technique")
	}
	)
	public Response getContratV1(
			@ApiParam(value = "Numéro de dossier", required = true) @PathParam("dossier") String dossier){
		ContratV1 contrat = null;
		try {
			contrat = upconnect.getContratV1(dossier);
		} 
		catch(InputValuesException ive){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour("-");
			erreurReponse.setMessage(ive.getMessage());
			erreurReponse.setVersionUPConnectService("ContratV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.BAD_REQUEST).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		catch (ConverterException e) {
			LOG.error("Erreur de conversion ContratV1 sur le champ "+e.getField());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		catch(ContratNonTrouveBusinessException cnte){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour(cnte.getCodeUP());
			erreurReponse.setMessage("Contrat non trouvé");
			erreurReponse.setVersionUPConnectService("ContratV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.NOT_FOUND).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(200).entity(contrat).build();
	}

	@GET
	@Path("/version2/{dossier}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="ContratV2", notes="Restitution des données d'un contrat en Version 2")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Succès"),
		@ApiResponse(code=400, message="Données en entrée incorrectes"),
		@ApiResponse(code=404, message="Contrat non trouvé. Correspond aux codes DCTR04,DCTR08,DCTR10,DCTR12,DCTR14,DCTR16,DCTR18,DCTR22,DCTR36"),
		@ApiResponse(code=500, message="Erreur technique")
	}
	)
	public Response getContratV2(
			@ApiParam(value = "Numéro de dossier", required = true) @PathParam("dossier") String dossier){
		ContratV2 contrat = null;
		try {
			contrat = upconnect.getContratV2(dossier);
			
		}
		catch(InputValuesException ive){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour("-");
			erreurReponse.setMessage(ive.getMessage());
			erreurReponse.setVersionUPConnectService("ContratV2");
			erreurReponse.setVersionUPService("UP V2");
			return Response.status(Response.Status.BAD_REQUEST).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		catch (ConverterException e) {
			LOG.error("Erreur de conversion ContratV2 sur le champ "+e.getField());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (ContratNonTrouveBusinessException e) {
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour(e.getCodeUP());
			erreurReponse.setMessage("Contrat non trouvé");
			erreurReponse.setVersionUPConnectService("ContratV2");
			erreurReponse.setVersionUPService("UP V2");
			return Response.status(Response.Status.NOT_FOUND).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(200).entity(contrat).build();
	}
}
