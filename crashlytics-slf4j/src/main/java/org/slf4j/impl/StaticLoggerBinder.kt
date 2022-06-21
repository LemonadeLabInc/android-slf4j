package org.slf4j.impl

import org.slf4j.spi.LoggerFactoryBinder
import org.slf4j.ILoggerFactory
import de.lemona.android.crashlytics.CrashlyticsLoggerFactory

@Suppress("unused") // SLF4J API uses this class
class StaticLoggerBinder private constructor() : LoggerFactoryBinder {
    /* ====================================================================== */
    override fun getLoggerFactory(): ILoggerFactory {
        return factory
    }

    override fun getLoggerFactoryClassStr(): String {
        return factory.javaClass.name
    }

    companion object {
        private val factory = CrashlyticsLoggerFactory()

        @Suppress("unused") // SLF4J API uses this getter
        @get:JvmStatic
        val singleton = StaticLoggerBinder()
    }
}