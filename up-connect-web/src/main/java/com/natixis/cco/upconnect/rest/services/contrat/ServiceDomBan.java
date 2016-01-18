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
import com.natixis.cco.upconnect.modelnfi.domban.DomBanV1;
import com.natixis.cco.upconnect.rest.tech.objets.ErreurReponse;
import com.natixis.financement.middlesav.commun.exceptions.DomBanBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/domiciliationsBancaires")
@Api(value="/domiciliationsBancaires", description="Services Contrat bloc Domiciliation Bancaire UP")
public class ServiceDomBan {
	private static final Logger LOG = LoggerFactory.getLogger("FILE");
	
	@Inject
	UPConnector upconnect;
	
	public ServiceDomBan(){}
	
	/**
	 * 
	 * @param dossier numéro de dossier sur 14
	 * @param date date d'utilisation
	 * @return
	 */
	@GET
	@Path("/version1/{dossier}/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value="DomBanV1", notes="Restitution des données du bloc domiciliation bancaire du contrat en Version 1")
	@ApiResponses(value={
		@ApiResponse(code=200, message="Succès"),
		@ApiResponse(code=400, message="Données en entrée incorrectes"),
		@ApiResponse(code=404, message="Numéro de contrat non trouvé. Correspond aux codes : DBQE03 et DBQE05"),
		@ApiResponse(code=500, message="Erreur technique")
	}
	)
	public Response getDomBanV1(
			@ApiParam(value="Le numéro du dossier", required=true) @PathParam("dossier") String dossier, 
			@ApiParam(value="La date d'utilisation", required=true) @PathParam("date") String date){
		DomBanV1 domban = null;
		try {
			domban = upconnect.getDomBanV1(dossier, date);
		}
		catch(InputValuesException ive){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour("-");
			erreurReponse.setMessage(ive.getMessage());
			erreurReponse.setVersionUPConnectService("DomBanV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.BAD_REQUEST).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		catch (ConverterException e) {
			LOG.error("Erreur de conversion DomBanV1 sur le champ "+e.getField());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		catch(DomBanBusinessException dbbe){
			ErreurReponse erreurReponse = new ErreurReponse();
			erreurReponse.setCodeRetour(dbbe.getCodeUP());
			erreurReponse.setMessage("Contrat non trouvé");
			erreurReponse.setVersionUPConnectService("DomBanV1");
			erreurReponse.setVersionUPService("UP V1");
			return Response.status(Response.Status.NOT_FOUND).entity(erreurReponse).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(200).entity(domban).build();
	}
	
}
