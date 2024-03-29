package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import io.leomo.android.slf4j.crashlytics.CrashlyticsLoggerFactory;

public class StaticLoggerBinder implements LoggerFactoryBinder {

    private static final CrashlyticsLoggerFactory factory = new CrashlyticsLoggerFactory();
    private static final StaticLoggerBinder binder = new StaticLoggerBinder();

    private StaticLoggerBinder() {
        // Nothing to do...
    }

    /* ====================================================================== */

    @Override
    public ILoggerFactory getLoggerFactory() {
        return factory;
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return factory.getClass().getName();
    }

    /* ====================================================================== */

    public static StaticLoggerBinder getSingleton() {
        return binder;
    }
}
