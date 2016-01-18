package com.natixis.financement.middlesav.commun.exceptions;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;


@SuppressWarnings("serial")
public class SavTechnicalException extends RuntimeException {

    private final ResourceBundle exceptionBundle = ResourceBundle.getBundle("i18n.exceptions");

    private String code;

    private String savMessage;

    public SavTechnicalException(final String message) {
        super(message);
    }

    public SavTechnicalException(final SavError savError, final String... parameters) {
        initCodeEtMessage(savError, parameters);
    }

    public SavTechnicalException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SavTechnicalException(final SavError savError, final Exception e, final String... parameters) {
        super(e);
        initCodeEtMessage(savError, parameters);
    }

    private void initCodeEtMessage(final SavError savError, final String... parameters) {
        code = savError.getCode();
        if (parameters == null) {
            savMessage = exceptionBundle.getString(savError.getMessageKey());
        } else {
            final String pattern = exceptionBundle.getString(savError.getMessageKey());
            savMessage = MessageFormat.format(pattern, (Object[]) parameters);
        }
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return StringUtils.isNotBlank(savMessage) ? savMessage : super.getMessage();
    }
}
