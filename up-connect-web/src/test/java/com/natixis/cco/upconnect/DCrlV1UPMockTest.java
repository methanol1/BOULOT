package com.natixis.cco.upconnect;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.modelnfi.dcrl.BaremeV1;
import com.natixis.cco.upconnect.modelnfi.dcrl.DCrlV1;
import com.natixis.cco.upconnect.modelnfi.dcrl.InputDCrlDescriptionV1;
import com.natixis.cco.upconnect.modelnfi.dcrl.InputDCrlV1;
import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.commun.exceptions.InputValuesException;
import com.natixis.financement.middlesav.united.UnitedCommareaHandler;

@RunWith(Arquillian.class)
public class DCrlV1UPMockTest {
	
	@Inject
	UPConnector upConnector;


	public DCrlV1UPMockTest() {
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
	public void calculDCrl1() throws ConverterException, InputValuesException{
		
		InputDCrlV1 request = new InputDCrlV1();
		List<InputDCrlDescriptionV1> inDescriptionV1s = new ArrayList<InputDCrlDescriptionV1>();
		
		InputDCrlDescriptionV1 input = new InputDCrlDescriptionV1();
		
		input.setDate("20150701");
		input.setMontantCapitalDu(new BigDecimal("0"));
		input.setMontantFinan(new BigDecimal("0"));
		input.setMontantMens(new BigDecimal("26"));
		input.setNbEcheance(36);
		input.setNbJokers(0);
		input.setPasMens(new BigDecimal("100"));
		input.setTauxAssurance(new BigDecimal("0"));
		
		List<BaremeV1> baremes = new ArrayList<BaremeV1>();
		BaremeV1 bv1 = new BaremeV1();
		bv1.setDecouvertMax(new BigDecimal("1499.99"));
		bv1.setDecouvertMin(new BigDecimal("0"));
		bv1.setTncAnnuel(new BigDecimal("18.20"));
		
		baremes.add(bv1);
		input.setBaremes(baremes);
		
		inDescriptionV1s.add(input);
		
		request.setInDescriptionV1s(inDescriptionV1s );
		
		System.out.println("DCRLS ########################### \n\r "+upConnector.calculDCrlV1(request ));
	}
}
