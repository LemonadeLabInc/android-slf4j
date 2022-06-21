package de.lemona.android.crashlytics

import android.util.Log
import org.slf4j.helpers.MarkerIgnoringBase
import de.lemona.android.crashlytics.CrashlyticsLogger
import com.google.firebase.crashlytics.FirebaseCrashlytics
import org.slf4j.helpers.MessageFormatter

class CrashlyticsLogger(name: String = "") : MarkerIgnoringBase() {

    /* ====================================================================== */
    private val prefix: String

    init {
        this.name = name
        this.prefix = if (this.name.isEmpty()) this.name else this.name + ": "
    }

    /* ====================================================================== */
    private fun format(format: String, arg1: Any): String {
        return prefix + MessageFormatter.format(format, arg1).message
    }

    private fun format(format: String, arg1: Any, arg2: Any): String {
        return prefix + MessageFormatter.format(format, arg1, arg2).message
    }

    private fun format(format: String, args: Array<Any>): String {
        return prefix + MessageFormatter.arrayFormat(format, args).message
    }

    /* ====================================================================== */
    override fun isTraceEnabled(): Boolean {
        return Log.isLoggable(tag, Log.VERBOSE)
    }

    override fun trace(msg: String) {
        if (!isTraceEnabled) return
        Log.v(tag, prefix + msg)
    }

    override fun trace(format: String, arg1: Any) {
        if (!isTraceEnabled) return
        Log.v(tag, format(format, arg1))
    }

    override fun trace(format: String, arg1: Any, arg2: Any) {
        if (!isTraceEnabled) return
        Log.v(tag, format(format, arg1, arg2))
    }

    override fun trace(format: String, vararg args: Any) {
        if (!isTraceEnabled) return
        Log.v(tag, format(format, arrayOf(*args)))
    }

    override fun trace(msg: String, t: Throwable) {
        if (!isTraceEnabled) return
        Log.v(tag, prefix + msg, t)
    }

    /* ====================================================================== */
    override fun isDebugEnabled(): Boolean {
        return Log.isLoggable(tag, Log.DEBUG)
    }

    override fun debug(msg: String) {
        if (!isDebugEnabled) return
        Log.d(tag, prefix + msg)
    }

    override fun debug(format: String, arg1: Any) {
        if (!isDebugEnabled) return
        Log.d(tag, format(format, arg1))
    }

    override fun debug(format: String, arg1: Any, arg2: Any) {
        if (!isDebugEnabled) return
        Log.d(tag, format(format, arg1, arg2))
    }

    override fun debug(format: String, vararg args: Any) {
        if (!isDebugEnabled) return
        Log.d(tag, format(format, arrayOf(*args)))
    }

    override fun debug(msg: String, t: Throwable) {
        if (!isDebugEnabled) return
        Log.d(tag, prefix + msg, t)
    }

    /* ====================================================================== */
    override fun isInfoEnabled(): Boolean {
        return Log.isLoggable(tag, Log.INFO)
    }

    override fun info(msg: String) {
        if (!isInfoEnabled) return
        Log.i(tag, prefix + msg)
    }

    override fun info(format: String, arg: Any) {
        if (!isInfoEnabled) return
        Log.i(tag, format(format, arg))
    }

    override fun info(format: String, arg1: Any, arg2: Any) {
        if (!isInfoEnabled) return
        Log.i(tag, format(format, arg1, arg2))
    }

    override fun info(format: String, vararg args: Any) {
        if (!isInfoEnabled) return
        Log.i(tag, format(format, arrayOf(*args)))
    }

    override fun info(msg: String, t: Throwable) {
        if (!isInfoEnabled) return
        Log.i(tag, prefix + msg, t)
    }

    /* ====================================================================== */
    override fun isWarnEnabled(): Boolean {
        return Log.isLoggable(tag, Log.WARN)
    }

    override fun warn(msg: String) {
        if (!isWarnEnabled) return

        val formatMsg = prefix + msg
        Log.w(tag, formatMsg)
        logMessage(formatMsg)
    }

    override fun warn(format: String, arg: Any) {
        if (!isWarnEnabled) return

        val formatMsg = format(format, arg)
        Log.w(tag, formatMsg)
        logMessage(formatMsg)
    }

    override fun warn(format: String, arg1: Any, arg2: Any) {
        if (!isWarnEnabled) return
        Log.w(tag, format(format, arg1, arg2))
    }

    override fun warn(format: String, vararg args: Any) {
        if (!isWarnEnabled) return

        val formatMsg = format(format, arrayOf(*args))
        Log.w(tag, formatMsg)
        logMessage(formatMsg)
    }

    override fun warn(msg: String, t: Throwable) {
        if (!isWarnEnabled) return

        val formatMsg = prefix + msg
        Log.w(tag, formatMsg, t)
        logMessage(formatMsg)
        logException(t)
    }

    /* ====================================================================== */
    override fun isErrorEnabled(): Boolean {
        return Log.isLoggable(tag, Log.ERROR)
    }

    override fun error(msg: String) {
        if (!isErrorEnabled) return

        val formatMsg = prefix + msg
        Log.e(tag, formatMsg)
        logMessage(formatMsg)
    }

    override fun error(format: String, arg: Any) {
        if (!isErrorEnabled) return

        val formatMsg = format(format, arg)
        Log.e(tag, formatMsg)
        logMessage(formatMsg)
    }

    override fun error(format: String, arg1: Any, arg2: Any) {
        if (!isErrorEnabled) return

        val formatMsg = format(format, arg1, arg2)
        Log.e(tag, formatMsg)
        logMessage(formatMsg)
    }

    override fun error(format: String, vararg args: Any) {
        if (!isErrorEnabled) return

        val formatMsg = format(format, arrayOf(*args))
        Log.e(tag, formatMsg)
        logMessage(formatMsg)
    }

    override fun error(msg: String, t: Throwable) {
        if (!isErrorEnabled) return

        val formatMsg = prefix + msg
        Log.e(tag, formatMsg, t)
        logMessage(formatMsg)
        logException(t)
    }

    private fun logMessage(message: String) {
        FirebaseCrashlytics.getInstance().log(message)
    }

    private fun logException(exception: Throwable) {
        FirebaseCrashlytics.getInstance().recordException(exception)
    }

    companion object {
        private var tag: String = "Slf4J"
        @JvmStatic
        fun initTag(tagName: String) {
            tag = tagName
        }
    }
}