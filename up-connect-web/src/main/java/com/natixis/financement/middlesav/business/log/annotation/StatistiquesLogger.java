package com.natixis.financement.middlesav.business.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Ce logger de niveau <code>INFO</code> rassemble les logs liées à chacune des
 * étapes d'un traitement ; il permet de reconstituer le "chemin" emprunté lors
 * d'un traitement au niveau du schéma de traitement des SFD.
 * <p>
 * Ce logger doit être appelé au niveau des ActionChain.
 */
@Qualifier
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface StatistiquesLogger {

}
