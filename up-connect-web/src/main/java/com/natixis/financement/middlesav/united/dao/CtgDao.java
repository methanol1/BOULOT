package com.natixis.financement.middlesav.united.dao;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescription;
import com.natixis.financement.middlesav.united.exception.UnitedAuthentificationException;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;

public interface CtgDao {

	/**
	 * Construit la commarea, l'envoie à UNITED, la récupére et la parse.
	 * 
	 * @param aIdAttComm id UNITED
	 * @param aMdpAttComm mdp UNITED
	 * @param aDescriptionRequest la description question
	 * @param aDescriptionResponseClass la classe de la description réponse
	 * @return
	 * @throws UnitedTechnicalException
	 * @throws UnitedAuthentificationException 
	 */
	UnitedCommareaDescription callUnited(UnitedCommareaDescription aDescriptionRequest,
			Class<? extends UnitedCommareaDescription> aDescriptionResponseClass) throws UnitedTechnicalException, UnitedAuthentificationException;
	
	public abstract void setTransactionName(final String transactionName);
	
	public abstract void setProgramName(final String programName);
}
