package com.natixis.financement.middlesav.business.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Ce logger de niveau <code>WARNING</code> rassemble les logs sur les
 * difficultés rencontrées lors d'appels aux services UP et les temps de
 * réponse.
 */
@Qualifier
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UPLogger {

}
