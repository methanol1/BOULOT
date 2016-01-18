package com.natixis.financement.middlesav.commun.config;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;

import com.bnpp.pf.lib.ctgrelay.client.protocol.ConnectionFactory;
import com.natixis.financement.middlesav.commun.config.annotations.UnitedConnectionFactory;
import com.natixis.financement.middlesav.mock.Mock;

@Mock
@Alternative
public class ConnectionFactoryProducerMock {

    @Resource(name="eis/Ctg")
    private ConnectionFactory factory;

    @Resource(name="ctg.mock.url")
    private String ctgMockUrl;

    @Produces
    @ApplicationScoped
    @UnitedConnectionFactory
    public ConnectionFactory getUnitedConnectionFactory() {
        // TODO: Propertiser les paramètres de connexion
    	factory = new ConnectionFactory();
    	
        if (ctgMockUrl!= null){
            factory.setUrl(ctgMockUrl); 
        }
        factory.setCics("CICSHNXF");
        factory.setUserName("Niobé");
        factory.setPassword("bidule");
        return factory;
    }
}
