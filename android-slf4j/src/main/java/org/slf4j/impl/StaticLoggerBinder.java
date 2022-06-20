package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import de.lemona.android.slf4j.AndroidLoggerFactory;

public class StaticLoggerBinder implements LoggerFactoryBinder {
    private static final AndroidLoggerFactory factory = new AndroidLoggerFactory();
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
