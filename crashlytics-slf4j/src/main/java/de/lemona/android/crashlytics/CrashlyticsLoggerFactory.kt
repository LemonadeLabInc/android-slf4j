package de.lemona.android.crashlytics

import org.slf4j.ILoggerFactory
import de.lemona.android.crashlytics.CrashlyticsLogger
import org.slf4j.Logger
import java.util.concurrent.ConcurrentHashMap

class CrashlyticsLoggerFactory : ILoggerFactory {
    private val loggers = ConcurrentHashMap<String, CrashlyticsLogger>()
    override fun getLogger(name: String): Logger {
        val existing = loggers[name]
        if (existing != null) return existing
        val created = CrashlyticsLogger(name)
        val previous = loggers.putIfAbsent(name, created)
        return previous ?: created
    }
}