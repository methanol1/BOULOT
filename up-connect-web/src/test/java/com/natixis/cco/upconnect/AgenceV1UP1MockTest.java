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
import com.natixis.cco.upconnect.modelnfi.agence.AgenceV1;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.natixis.financement.middlesav.united.UnitedCommareaHandler;

/**
 * Unit test for simple App.
 */

@RunWith(Arquillian.class)
public class AgenceV1UP1MockTest {
	@Inject
	UPConnector upConnector;

	public AgenceV1UP1MockTest() {
	}

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive jar = ShrinkWrap
				.create(WebArchive.class, "upconnect.war")
				.addPackages(true, UPConnector.class.getPackage(),//Pour les classes sous com.natixis.cco.upconnect
						UnitedCommareaHandler.class.getPackage(),//Pour les classes sous com.natixis.financement.middlesav.united
						Constantes.class.getPackage())//Pour les classes sous com.natixis.financement.middlesav.commun
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
	 * Ce test vérifie l'erreur Probleme de calculIRA
	 * 
	 */
	@Test
	public void testAgenceNonTrouvee()throws ConverterException {

		try{
			upConnector.getAgenceV1("012");
			Assert.fail();
		}catch(AgenceNonTrouveBusinessException e){
			return;
		}
		catch(ConverterException ce){
			Assert.fail();
		} catch (InputValuesException e) {
			Assert.fail();
		}
	}
	

	/**
     * Ce test vérifie que l'objet Rachat récupéré correspond exactement
     * à ce que nous avons défini dans le mock UnitedDaoMock pour le SERVICE AGENCE version UP UP1.
	 * @throws InputValuesException 
     */
	@Test
	public void testRespectMappingV1()
			throws ConverterException, AgenceNonTrouveBusinessException, InputValuesException {

		AgenceV1 agence = upConnector.getAgenceV1("123");
		Assert.assertEquals("Le nom de l'agence incorrect", "La super agence",agence.getNomAgence());
	}

	
}
