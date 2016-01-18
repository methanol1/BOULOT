package com.natixis.cco.upconnect;

import java.io.File;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.natixis.financement.middlesav.commun.Constantes;
import com.natixis.financement.middlesav.united.UnitedCommareaHandler;

@RunWith(Arquillian.class)
public class DMenV1UPMockTest {
	
	@Inject
	UPConnector upConnector;


	public DMenV1UPMockTest() {
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
	public void todo(){
		//TODO
	}
}
