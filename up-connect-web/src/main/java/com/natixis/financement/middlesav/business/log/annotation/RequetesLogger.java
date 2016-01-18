package com.natixis.financement.middlesav.business.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Ce logger de niveau <code>DEBUG</code> rassemble les logs des requêtes SOAP d'appel au module et des requêtes UP émises par le module.
 */
@Qualifier
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RequetesLogger {

}
