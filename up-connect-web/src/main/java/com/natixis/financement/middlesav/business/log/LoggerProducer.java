package com.natixis.financement.middlesav.business.log;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.interceptors.LogCommarea;
import com.natixis.cco.upconnect.interceptors.contrat.AgenceStatLogger;
import com.natixis.cco.upconnect.interceptors.contrat.AssuranceStatLogger;
import com.natixis.cco.upconnect.interceptors.contrat.ContratStatLogger;
import com.natixis.cco.upconnect.interceptors.contrat.DomBanStatLogger;
import com.natixis.cco.upconnect.interceptors.contrat.RachatStatLogger;
import com.natixis.cco.upconnect.interceptors.m2cr.DMenStatLogger;
import com.natixis.financement.middlesav.business.log.annotation.RequetesLogger;
import com.natixis.financement.middlesav.business.log.annotation.StatistiquesLogger;
import com.natixis.financement.middlesav.business.log.annotation.UPLogger;
import com.natixis.financement.middlesav.commun.Constantes;


@ApplicationScoped
public class LoggerProducer {

    @Produces @LogCommarea
    public Logger initCommareaLogger(){
        return LoggerFactory.getLogger(Constantes.COMMAREAS);
    }
    
    @Produces @ContratStatLogger
    public Logger initStatistiquesLogger(){
        return LoggerFactory.getLogger(Constantes.STATISTIQUES);
    }
}
