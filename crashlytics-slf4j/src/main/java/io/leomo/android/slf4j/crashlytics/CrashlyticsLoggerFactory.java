package io.leomo.android.slf4j.crashlytics;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.ConcurrentHashMap;

public class CrashlyticsLoggerFactory implements ILoggerFactory {

    private final ConcurrentHashMap<String, CrashlyticsLogger> loggers = new ConcurrentHashMap<>();

    @Override
    public Logger getLogger(String name) {
        final CrashlyticsLogger existing = loggers.get(name);
        if (existing != null) return existing;
        final CrashlyticsLogger created = new CrashlyticsLogger(name);
        final CrashlyticsLogger previous = loggers.putIfAbsent(name, created);
        if (previous != null) return previous;
        return created;
    }
}
