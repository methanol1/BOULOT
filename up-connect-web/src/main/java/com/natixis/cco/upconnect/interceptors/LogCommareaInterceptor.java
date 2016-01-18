package com.natixis.cco.upconnect.interceptors;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.financement.middlesav.commun.Constantes;

@LogCommarea
@Interceptor
public class LogCommareaInterceptor implements Serializable {

    private static final long serialVersionUID = -2104016941552558872L;

    private Logger logger = LoggerFactory.getLogger(Constantes.COMMAREAS);


    @AroundInvoke
    public Object logCommareas(final InvocationContext context) throws Exception {
        logger.debug(context.getParameters()[0].toString());
        final Object result = context.proceed();
        logger.debug(result.toString());
        return result;
    }
}
