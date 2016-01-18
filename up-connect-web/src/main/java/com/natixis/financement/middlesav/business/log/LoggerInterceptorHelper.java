package com.natixis.financement.middlesav.business.log;

import javax.interceptor.InvocationContext;

/**
 * Classe helper formattant les informations du contexte d'invocation à des fins d'affichage dans les logs.
 */
public class LoggerInterceptorHelper {

    /**
     * Renvoie la classe et la méthode invoquées.
     * @param context - le contexte d'invocation
     * @return les noms du service et de la méthode invoqués.
     */
    public String formatMethod(final InvocationContext context) {
        return context.getMethod().getDeclaringClass().getSimpleName() + "." + context.getMethod().getName();
    }

    /**
     * Formate les paramètres d'appel de la méthode
     * @param context - le contexte d'invocation
     * @return les paramètres d'appel de la méthode
     */
    public String formatParameters(final InvocationContext context) {
        final Object[] parameters = context.getParameters();
        final StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            buffer.append("[").append(context.getMethod().getParameterTypes()[i].getSimpleName()).append("]").append(parameters[i]).append(" ");
        }
        return buffer.toString().trim();
    }
}
