package com.natixis.cco.upconnect;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelnfi.historique.InputHistoV1;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.HistoriqueNonTrouveException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.natixis.financement.middlesav.united.UnitedCommareaHandler;

@RunWith(Arquillian.class)
public class HistoV1UPMockTest {
	
	@Inject
	UPConnector upConnector;


	public HistoV1UPMockTest() {
		// TODO Auto-generated constructor stub
	}

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive jar = ShrinkWrap
				.create(WebArchive.class, "upconnect.war")
				.addPackages(true, UPConnector.class.getPackage(),
						UnitedCommareaHandler.class.getPackage(),
						Constantes.class.getPackage())
				.addAsWebInfResource(
						new File(
								"src/main/webapp/WEB-INF/mocks/beans-UPmock.xml"),
						"beans.xml")
				.addAsWebInfResource(
						new File("src/main/webapp/WEB-INF/web.xml"))
				.addAsResource("business/united-infos.properties")
				.addAsResource("logback.xml");
		return jar;
	}
	
	@Test
	public void getHistoriques() throws ContratNonTrouveBusinessException, ConverterException, InputValuesException,HistoriqueNonTrouveException{
		
		InputHistoV1 request = new InputHistoV1();	
		request.setIdOperation("2015-07-07-07.19.58.741788");
		request.setNombreOperationMaxARestituer(40);
		request.setNumeroContrat("41223205319001");
		request.setSensRestitution("PREC");
		System.out.println("HISTORIQUES DES OPRERATIONS ################################## \n\r"+upConnector.historiques(request) );
	}
}
