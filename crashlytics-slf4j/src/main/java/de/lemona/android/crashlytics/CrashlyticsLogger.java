package de.lemona.android.crashlytics;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;

public class CrashlyticsLogger extends MarkerIgnoringBase {
    private static String tag = "Slf4J";

    public static void initTag(String tagName) {
        if (tagName != null) tag = tagName;
    }

    /* ====================================================================== */

    private final String name;
    private final String prefix;

    public CrashlyticsLogger(String name) {
        this.name = name == null ? "" : name;
        this.prefix = this.name.length() == 0 ? this.name : this.name + ": ";
    }

    @Override
    public String getName() {
        return name;
    }

    /* ====================================================================== */

    private String format(final String format, final Object arg1) {
        return this.prefix + MessageFormatter.format(format, arg1).getMessage();
    }

    private String format(final String format, final Object arg1, final Object arg2) {
        return this.prefix + MessageFormatter.format(format, arg1, arg2).getMessage();
    }

    private String format(final String format, final Object[] args) {
        return this.prefix + MessageFormatter.arrayFormat(format, args).getMessage();
    }

    /* ====================================================================== */

    @Override
    public boolean isTraceEnabled() {
        return Log.isLoggable(tag, Log.VERBOSE);
    }

    @Override
    public void trace(final String msg) {
        if (!isTraceEnabled()) return;
        Log.v(tag, prefix + msg);
    }

    @Override
    public void trace(final String format, final Object arg1) {
        if (!isTraceEnabled()) return;
        Log.v(tag, format(format, arg1));
    }

    @Override
    public void trace(final String format, final Object arg1, final Object arg2) {
        if (!isTraceEnabled()) return;
        Log.v(tag, format(format, arg1, arg2));
    }

    @Override
    public void trace(final String format, final Object... args) {
        if (!isTraceEnabled()) return;
        Log.v(tag, format(format, args));
    }

    @Override
    public void trace(final String msg, final Throwable t) {
        if (!isTraceEnabled()) return;
        Log.v(tag, prefix + msg, t);
    }

    /* ====================================================================== */

    @Override
    public boolean isDebugEnabled() {
        return Log.isLoggable(tag, Log.DEBUG);
    }

    @Override
    public void debug(final String msg) {
        if (!isDebugEnabled()) return;
        Log.d(tag, prefix + msg);
    }

    @Override
    public void debug(final String format, final Object arg1) {
        if (!isDebugEnabled()) return;
        Log.d(tag, format(format, arg1));
    }

    @Override
    public void debug(final String format, final Object arg1, final Object arg2) {
        if (!isDebugEnabled()) return;
        Log.d(tag, format(format, arg1, arg2));
    }

    @Override
    public void debug(final String format, final Object... args) {
        if (!isDebugEnabled()) return;
        Log.d(tag, format(format, args));
    }

    @Override
    public void debug(final String msg, final Throwable t) {
        if (!isDebugEnabled()) return;
        Log.d(tag, prefix + msg, t);
    }

    /* ====================================================================== */

    @Override
    public boolean isInfoEnabled() {
        return Log.isLoggable(tag, Log.INFO);
    }

    @Override
    public void info(final String msg) {
        if (!isInfoEnabled()) return;
        Log.i(tag, prefix + msg);
    }

    @Override
    public void info(final String format, final Object arg) {
        if (!isInfoEnabled()) return;
        Log.i(tag, format(format, arg));
    }

    @Override
    public void info(final String format, final Object arg1, final Object arg2) {
        if (!isInfoEnabled()) return;
        Log.i(tag, format(format, arg1, arg2));
    }

    @Override
    public void info(final String format, final Object... args) {
        if (!isInfoEnabled()) return;
        Log.i(tag, format(format, args));
    }

    @Override
    public void info(final String msg, final Throwable t) {
        if (!isInfoEnabled()) return;
        Log.i(tag, prefix + msg, t);
    }

    /* ====================================================================== */

    @Override
    public boolean isWarnEnabled() {
        return Log.isLoggable(tag, Log.WARN);
    }

    @Override
    public void warn(final String msg) {
        if (!isWarnEnabled()) return;
        Log.w(tag, prefix + msg);
        logMessage(msg);
    }

    @Override
    public void warn(final String format, final Object arg) {
        if (!isWarnEnabled()) return;
        Log.w(tag, format(format, arg));
        logMessage(format(format, arg));
    }

    @Override
    public void warn(final String format, final Object arg1, final Object arg2) {
        if (!isWarnEnabled()) return;
        Log.w(tag, format(format, arg1, arg2));
    }

    @Override
    public void warn(final String format, final Object... args) {
        if (!isWarnEnabled()) return;
        Log.w(tag, format(format, args));
        logMessage(format(format, args));
    }

    @Override
    public void warn(final String msg, final Throwable t) {
        if (!isWarnEnabled()) return;
        Log.w(tag, prefix + msg, t);
        logMessage(msg);
        logException(t);
    }

    /* ====================================================================== */

    @Override
    public boolean isErrorEnabled() {
        return Log.isLoggable(tag, Log.ERROR);
    }

    @Override
    public void error(final String msg) {
        if (!isErrorEnabled()) return;
        Log.e(tag, prefix + msg);
        logMessage(msg);
    }

    @Override
    public void error(final String format, final Object arg) {
        if (!isErrorEnabled()) return;
        Log.e(tag, format(format, arg));
        logMessage(format(format, arg));
    }

    @Override
    public void error(final String format, final Object arg1, final Object arg2) {
        if (!isErrorEnabled()) return;
        Log.e(tag, format(format, arg1, arg2));
        logMessage(format(format, arg1, arg2));
    }

    @Override
    public void error(final String format, final Object... args) {
        if (!isErrorEnabled()) return;
        Log.e(tag, format(format, args));
        logMessage(format(format, args));
    }

    @Override
    public void error(final String msg, final Throwable t) {
        if (!isErrorEnabled()) return;
        Log.e(tag, prefix + msg, t);
        logMessage(msg);
        logException(t);
    }

    public void logMessage(@NonNull String message) {
        FirebaseCrashlytics.getInstance().log(message);
    }

    private void logException(@NonNull Throwable exception) {
        FirebaseCrashlytics.getInstance().recordException(exception);
    }
}
