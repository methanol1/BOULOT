package com.natixis.cco.upconnect.manager.contrat;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.cco.upconnect.converter.InputConverter;
import com.natixis.cco.upconnect.converter.OutputConverter;
import com.natixis.cco.upconnect.manager.IVersionManager;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;



/**
 * 
 * @author steph
 *
 * @param <T> Cet objet est l'ensemble des données nécessaires à la construction
 * 				de l'objet contenant les données du service UP
 * @param <V> Cet objet est la représentation de l'input du service UP (commarea entrée)
 * @param <U> Cet objet est la représentation de l'output du service UP (commarea sortie)
 * @param <S> Cet objet est la conversion de la sortie UP en un objet ContratV...
 */
public abstract class AbstractContratManager<T,V,U,S> implements IVersionManager {
	
	protected InputConverter<T,V> inputConverter;
	protected OutputConverter<U,S> outputConverter;
	
	/**
	 * Cette méthode est responsable de l'enchaînement des traitements.
	 * Elle retourne un contrat dans une certaine version.
	 */
	public final S getContrat(T input) throws ConverterException, ContratNonTrouveBusinessException {
		
		V inputUP = inputConverter.extractInput(input);
		
		U outputUP = doGetContrat(inputUP);
		
		return outputConverter.extract(outputUP);
	}
	
	public abstract U doGetContrat(V inputUP) throws ConverterException, ContratNonTrouveBusinessException;
	
}
