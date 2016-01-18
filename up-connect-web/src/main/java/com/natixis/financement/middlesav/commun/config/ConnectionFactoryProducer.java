package com.natixis.financement.middlesav.commun.config;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;

import com.bnpp.pf.lib.ctgrelay.client.protocol.ConnectionFactory;
import com.natixis.financement.middlesav.commun.config.annotations.UnitedConnectionFactory;


public class ConnectionFactoryProducer {

    @Resource(name="eis/Ctg")
    private ConnectionFactory factory;

    @Produces
    @ApplicationScoped
    @UnitedConnectionFactory
    public ConnectionFactory getUnitedConnectionFactory(){
        return factory;
    }
}
