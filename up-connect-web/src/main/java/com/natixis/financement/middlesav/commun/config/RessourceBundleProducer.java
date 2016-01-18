package com.natixis.financement.middlesav.commun.config;

import java.util.ResourceBundle;

import javax.enterprise.inject.Produces;

import com.natixis.financement.middlesav.commun.config.annotations.ExceptionBundle;
import com.natixis.financement.middlesav.commun.config.annotations.JournalBundle;
import com.natixis.financement.middlesav.commun.config.annotations.MessageBundle;
import com.natixis.financement.middlesav.commun.config.annotations.OperationBundle;
import com.natixis.financement.middlesav.commun.config.annotations.UnitedBundle;

public class RessourceBundleProducer {

    private final String MESSAGE_BUNDLE_PATH = "i18n.messages";

    private final String EXCEPTION_BUNDLE_PATH = "i18n.exceptions";

    private final String UNITED_BUNDLE_PATH = "business.united-infos";

    private final String OPERATION_BUNDLE_PATH = "business.operation";

    private final String JOURNAL_BUNDLE_PATH = "i18n.journal-props-labels";

    private ResourceBundle messageBundle;

    private ResourceBundle exceptionBundle;

    private ResourceBundle unitedBundle;

    private ResourceBundle operationBundle;

    private ResourceBundle journalBundle;

    @Produces
    @MessageBundle
    public ResourceBundle getMessageBundle() {
        if (messageBundle == null) {
            messageBundle = ResourceBundle.getBundle(MESSAGE_BUNDLE_PATH);
        }
        return messageBundle;
    }

    @Produces
    @ExceptionBundle
    public ResourceBundle getExceptionBundle() {
        if (exceptionBundle == null) {
            exceptionBundle = ResourceBundle.getBundle(EXCEPTION_BUNDLE_PATH);
        }
        return exceptionBundle;
    }

    @Produces
    @UnitedBundle
    public ResourceBundle getUnitedBundle() {
        if (unitedBundle == null) {
            unitedBundle = ResourceBundle.getBundle(UNITED_BUNDLE_PATH);
        }
        return unitedBundle;
    }

    @Produces
    @OperationBundle
    public ResourceBundle getOperationBundle() {
        if (operationBundle == null) {
            operationBundle = ResourceBundle.getBundle(OPERATION_BUNDLE_PATH);
        }
        return operationBundle;
    }

    @Produces
    @JournalBundle
    public ResourceBundle getJournalBundle() {
        if (journalBundle == null) {
            journalBundle = ResourceBundle.getBundle(JOURNAL_BUNDLE_PATH);
        }
        return journalBundle;
    }
}
