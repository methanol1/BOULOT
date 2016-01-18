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
import com.natixis.cco.upconnect.modelnfi.assurance.AssuranceV1;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.natixis.financement.middlesav.united.UnitedCommareaHandler;

/**
 * Unit test for simple App.
 */

@RunWith(Arquillian.class)
public class AssuranceV1UP1MockTest {
	@Inject
	UPConnector upConnector;

	public AssuranceV1UP1MockTest() {
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
		 System.out.println(jar.toString(true));
		return jar;
	}

	/**
     * Ce test vérifie que l'objet Assurance récupéré correspond exactement
     * à ce que nous avons défini dans le mock UnitedDaoMock pour le SERVICE ASSURANCE version UP UP1.
	 * @throws InputValuesException 
     */
	@Test
	public void testRespectMappingV1()
			throws ConverterException, ContratNonTrouveBusinessException, InputValuesException {

		AssuranceV1 assurance = upConnector.getAssuranceV1("15966969696969","10.02.2014");
		Assert.assertEquals("Option assurance souscripteur non respectée : ", "ABCDE",
				assurance.getOptionSous());
		Assert.assertEquals("idErreurMainframe", "CODE ERREUR MAINFRAME",
				assurance.getHeader().getIdErreurMainframe());
		Assert.assertEquals("Code pays ISO", "FRA",
				assurance.getHeader().getCodePaysISO());
		Assert.assertEquals("Code retour précis", "ALPHAA",
				assurance.getHeader().getCodeRetourPrecis());
		Assert.assertEquals("Code retour Simple", "0",
				assurance.getHeader().getCodeRetourSimple());
		Assert.assertEquals("id Canal", "P",
				assurance.getHeader().getIdCanal());
		Assert.assertEquals("id Fonction appelée", "Service Assurance",
				assurance.getHeader().getIdFctAppelee());
		Assert.assertEquals("Id partenaire", "NF",
				assurance.getHeader().getIdPartenaire());
		Assert.assertEquals("id requete", "nx-?-1423475908972",
				assurance.getHeader().getIdRequete());
		Assert.assertEquals("Version entete", "01",
				assurance.getHeader().getNumVersionEntete());
		Assert.assertEquals("Programme Java appelant", "UP-CONNECT",
				assurance.getHeader().getProgrammeJavaAppelant());
		Assert.assertEquals("Programme mainframe appelé", "IMDASU0",
				assurance.getHeader().getProgrammeMainframeAppele());
		Assert.assertEquals("Type message", "R",
				assurance.getHeader().getTypeMessage());
		Assert.assertEquals("Type passerelle", "C",
				assurance.getHeader().getTypePasserelle());
		
		System.out.println(assurance);
	}

}
