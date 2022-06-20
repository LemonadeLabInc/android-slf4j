package de.lemona.android.slf4j;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class AndroidLoggerFactory implements ILoggerFactory {

    private final ConcurrentHashMap<String, AndroidLogger> loggers = new ConcurrentHashMap<>();

    @Override
    public Logger getLogger(String name) {
        final AndroidLogger existing = loggers.get(name);
        if (existing != null) return existing;
        final AndroidLogger created = new CrashlyticsLogger(name);
        final AndroidLogger previous = loggers.putIfAbsent(name, created);
        if (previous != null) return previous;
        return created;
    }

}
