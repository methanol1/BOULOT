package com.natixis.cco.upconnect.rest.services;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.natixis.cco.upconnect.rest.services.contrat.ServiceAgence;
import com.natixis.cco.upconnect.rest.services.contrat.ServiceAssurance;
import com.natixis.cco.upconnect.rest.services.contrat.ServiceContrat;
import com.natixis.cco.upconnect.rest.services.contrat.ServiceDomBan;
import com.natixis.cco.upconnect.rest.services.contrat.ServiceRachat;
import com.natixis.cco.upconnect.rest.services.dcrl.ServiceDCrl;
import com.natixis.cco.upconnect.rest.services.dmen.ServiceDMen;
import com.natixis.cco.upconnect.rest.services.historique.ServiceHisto;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {

    // ======================================
    // =          Business methods          =
    // ======================================

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        
        classes.add(ApiDeclarationProvider.class);
    	classes.add(ResourceListingProvider.class);
    	classes.add(ApiListingResourceJSON.class);
    	
        classes.add(ServiceContrat.class);
        classes.add(ServiceRachat.class);
        classes.add(ServiceAssurance.class);
        classes.add(ServiceAgence.class);
        classes.add(ServiceTech.class);
        classes.add(ServiceDMen.class);
        classes.add(ServiceDomBan.class);
        classes.add(ServiceDCrl.class);
        classes.add(ServiceHisto.class);
        return classes;
    }
}