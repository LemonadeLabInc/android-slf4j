package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import de.lemona.android.crashlytics.CrashlyticsLoggerFactory;

public class StaticLoggerBinder implements LoggerFactoryBinder {

    //public static final String REQUESTED_API_VERSION = "1.6.99"; // !final

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
