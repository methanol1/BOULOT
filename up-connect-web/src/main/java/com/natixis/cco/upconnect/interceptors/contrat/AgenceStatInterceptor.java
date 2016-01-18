/*
 * Cr��/modifi� le %PRT% par %PO%
 * Sp�cification Dimensions : %PID%
 * Statut Dimensions : %PS%
 *
 */
package com.natixis.cco.upconnect.interceptors.contrat;

import java.util.Locale;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.converter.ConverterException;
import com.natixis.financement.middlesav.commun.exceptions.AgenceNonTrouveBusinessException;
import com.natixis.financement.middlesav.commun.exceptions.ContratNonTrouveBusinessException;

@AgenceStatLogger
@Interceptor
public class AgenceStatInterceptor {
	
	private static final Logger statistiques = LoggerFactory
			.getLogger("statistiques");
	
	private static final String STAT_OK = "service=%s agence=%s duration=%d ms";
	private static final String STAT_KO = "service=%s agence=%s duration=%d ms erreur=[%s]";
	

	@AroundInvoke
	public Object callServiceRest(InvocationContext ctx) throws Exception {
		long startTime = System.currentTimeMillis();
		try{
			Object res = ctx.proceed();
			if (statistiques.isInfoEnabled()) {
	            long executionTime = System.currentTimeMillis() - startTime;
	            statistiques.info(String.format(
						Locale.US, STAT_OK,ctx.getMethod().getName(), ctx.getParameters()[0],executionTime));
	        }
			return res;
		}
		catch(AgenceNonTrouveBusinessException antbe){
			long executionTime = System.currentTimeMillis() - startTime;
			statistiques.info(String.format(
					Locale.US, STAT_KO,ctx.getMethod().getName(),ctx.getParameters()[0],executionTime, antbe.getMessage()));
			throw antbe;
		}
		catch(ConverterException ce){
			long executionTime = System.currentTimeMillis() - startTime;
			statistiques.error(String.format(
					Locale.US, STAT_KO,ctx.getMethod().getName(),ctx.getParameters()[0],executionTime, ce.getMessage()));
			throw ce;
		}
		catch(Exception e){
			long executionTime = System.currentTimeMillis() - startTime;
			statistiques.error(String.format(
					Locale.US, STAT_KO,ctx.getMethod().getName(),ctx.getParameters()[0],executionTime, e.getMessage()));
			throw e;
		}
	}
}
