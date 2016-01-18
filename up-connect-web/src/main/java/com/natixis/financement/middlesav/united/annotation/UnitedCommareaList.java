package com.natixis.financement.middlesav.united.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation repr�sentant un objet � parcourir dans une description de
 * commarea. Pour le moment, est seulement utilis�e dans les CommareaDescriptionResponse. 
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnitedCommareaList {

	int position();
	int nombre();
	int longueur();
}
