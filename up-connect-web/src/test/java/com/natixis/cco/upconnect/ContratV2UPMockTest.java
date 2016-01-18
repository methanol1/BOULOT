package com.natixis.cco.upconnect;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelnfi.contrat.ContratV2;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.natixis.financement.middlesav.united.UnitedCommareaHandler;

/**
 * Unit test for simple App.
 */

@RunWith(Arquillian.class)
public class ContratV2UPMockTest {
	@Inject
	UPConnector upConnector;

	public ContratV2UPMockTest() {
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
		// System.out.println(jar.toString(true));
		return jar;
	}

	/**
	 * @throws InputValuesException 
     * 
     */
	@Test
	public void testRespectDuCodePositionActuelenV1()
			throws ConverterException, ContratNonTrouveBusinessException, InputValuesException {

		ContratV2 contrat = upConnector.getContratV2("45966969696969");
		System.out.println(contrat);
		Assert.assertEquals("Code position actuelle non respecté : ", "ENC",
				contrat.getPositionActuelle());
	}

	/**
	 * @throws InputValuesException 
     * 
     */
	@Test
	public void testRespectDuCodePositionActuelModeRetEnV1()
			throws ConverterException, ContratNonTrouveBusinessException, InputValuesException {

		ContratV2 contrat = upConnector.getContratV2("15966969696969");
		System.out.println(contrat);
		Assert.assertEquals("La position actuelle devrait être ENC.", "ENC",
				contrat.getPositionActuelle());
	}
	
	@Test
	public void devraitLeverUneContratNonTrouveException() throws Exception {
		try{
			upConnector.getContratV2("05966969696969");
			Assert.fail("L'exception ContratNonTrouveException aurait dû être levée.");
		}catch(ContratNonTrouveBusinessException cnbe){
			return;
		}catch(ConverterException ce){
			Assert.fail("L'exception ContratNonTrouveException aurait dû être levée.");
		}
		Assert.fail("L'exception ContratNonTrouveException aurait dû être levée.");
	}

}
