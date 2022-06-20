package de.lemona.android.slf4j;

import androidx.annotation.NonNull;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class CrashlyticsLogger extends AndroidLogger {
    public CrashlyticsLogger(String name) {
        super(name);
    }

    @Override
    public void warn(String msg) {
        super.warn(msg);
        logMessage(msg);
    }

    @Override
    public void warn(String format, Object arg) {
        super.warn(format, arg);
        logMessage(format(format, arg));
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        super.warn(format, arg1, arg2);
        logMessage(format(format, arg1, arg2));
    }

    @Override
    public void warn(String format, Object... args) {
        super.warn(format, args);
        logMessage(format(format, args));
    }

    @Override
    public void warn(String msg, Throwable t) {
        super.warn(msg, t);
        logMessage(msg);
        logException(t);
    }

    @Override
    public void error(String msg) {
        super.error(msg);
        logMessage(msg);
    }

    @Override
    public void error(String format, Object arg) {
        super.error(format, arg);
        logMessage(format(format, arg));
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        super.error(format, arg1, arg2);
        logMessage(format(format, arg1, arg2));
    }

    @Override
    public void error(String format, Object... args) {
        super.error(format, args);
        logMessage(format(format, args));
    }

    @Override
    public void error(String msg, Throwable t) {
        super.error(msg, t);
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
