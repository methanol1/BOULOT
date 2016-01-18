package com.natixis.cco.upconnect;

import java.io.File;
import java.math.BigDecimal;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelnfi.rachat.RachatV1;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.natixis.financement.middlesav.commun.exceptions.RachatBusinessException;
import com.natixis.financement.middlesav.united.UnitedCommareaHandler;

/**
 * Unit test for simple App.
 */

@RunWith(Arquillian.class)
public class RachatV1UP1MockTest {
	@Inject
	UPConnector upConnector;

	public RachatV1UP1MockTest() {
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
	 * Ce test vérifie l'erreur Probleme de calculIRA
	 * @throws InputValuesException 
	 * 
	 */
	@Test
	public void testErreurCalculIRA()throws ConverterException, RachatBusinessException, InputValuesException {

		try{
			upConnector.getRachatV1("05966969696969","10.02.2014");
			Assert.fail();
		}catch(RachatBusinessException e){
			return;
		}
		catch(ConverterException ce){
			Assert.fail();
		}
	}
	

	/**
     * Ce test vérifie que l'objet Rachat récupéré correspond exactement
     * à ce que nous avons défini dans le mock UnitedDaoMock pour le SERVICE RACHAT version UP UP1.
	 * @throws InputValuesException 
     */
	@Test
	public void testRespectMappingV1()
			throws ConverterException, RachatBusinessException, InputValuesException {

		RachatV1 rachat = upConnector.getRachatV1("15966969696969","10.02.2014");
		Assert.assertEquals("Montant solde anti non respecté : ", new BigDecimal("-647.79"),
				rachat.getMontantSoldeAnti());
		Assert.assertEquals("Montant Theorique des IRAs non respecté : ", new BigDecimal("3.34"),
				rachat.getMontantTheoIra());
		Assert.assertEquals("Taux IRA non respecté : ", new BigDecimal("12345.67"),
				rachat.getTauxIra());
		Assert.assertEquals("idErreurMainframe", "CODE ERREUR MAINFRAME",
				rachat.getHeader().getIdErreurMainframe());
		Assert.assertEquals("Code pays ISO", "FRA",
				rachat.getHeader().getCodePaysISO());
		Assert.assertEquals("Code retour précis", "ALPHAA",
				rachat.getHeader().getCodeRetourPrecis());
		Assert.assertEquals("Code retour Simple", "0",
				rachat.getHeader().getCodeRetourSimple());
		Assert.assertEquals("id Canal", "P",
				rachat.getHeader().getIdCanal());
		Assert.assertEquals("id Fonction appelée", "Service Rachat",
				rachat.getHeader().getIdFctAppelee());
		Assert.assertEquals("Id partenaire", "NF",
				rachat.getHeader().getIdPartenaire());
		Assert.assertEquals("id requete", "nx-?-1423475908972",
				rachat.getHeader().getIdRequete());
		Assert.assertEquals("Version entete", "01",
				rachat.getHeader().getNumVersionEntete());
		Assert.assertEquals("Programme Java appelant", "UP-CONNECT",
				rachat.getHeader().getProgrammeJavaAppelant());
		Assert.assertEquals("Programme mainframe appelé", "IMDRCH0",
				rachat.getHeader().getProgrammeMainframeAppele());
		Assert.assertEquals("Type message", "R",
				rachat.getHeader().getTypeMessage());
		Assert.assertEquals("Type passerelle", "C",
				rachat.getHeader().getTypePasserelle());
		
		System.out.println(rachat);
	}

	/**
	 * Ce test vérifie que l'on a bien une ConverterException sur un montant solde anti incorrect
	 * Cf UnitedDaoMock pour un dossier commencant par 2.
	 * @throws InputValuesException 
	 */
	@Test
	public void shouldThrowConverterExceptionOnSoldeAnti() throws InputValuesException {
		try{
			upConnector.getRachatV1("25966969696969","10.02.2014");
			Assert.fail("Une converterException aurait dû être levée...");
		}catch(ConverterException ce){
			//OK
			return;
		}catch(RachatBusinessException e){
			Assert.fail("Une converterException aurait dû être levée...");
		}
	}
	

}
