package de.lemona.android.slf4j.test;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.lemona.android.slf4j.AndroidLogger;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class LoggingTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testInstance() {
        Assert.assertNotNull("Logger is null", logger);
        logger.info("The logger class is {}", logger.getClass());
        Assert.assertTrue("Wrong logger class: " + logger.getClass(), logger instanceof AndroidLogger);
    }

    @Test
    public void testEnableForTrace() {
        Logger spyLogger = spy(logger);
        when(spyLogger.isTraceEnabled()).thenReturn(true);
        spyLogger.trace("This is a 'TRACE' message");
        spyLogger.trace("message {}", "arg1");
        spyLogger.trace("message {} {}", "arg1", "arg2");
        spyLogger.trace("message {} {} {}", "arg1", "arg2", "arg3");
        spyLogger.trace("message", new Throwable());

        when(spyLogger.isTraceEnabled()).thenReturn(false);
        spyLogger.trace("This is a 'TRACE' message");
        spyLogger.trace("message {}", "arg1");
        spyLogger.trace("message {} {}", "arg1", "arg2");
        spyLogger.trace("message {} {}", "arg1", "arg2", "arg3");
        spyLogger.trace("message",  new Exception("Hello, world!"));
    }

    @Test
    public void testEnableForDebug() {
        Logger spyLogger = spy(logger);
        when(spyLogger.isDebugEnabled()).thenReturn(true);
        spyLogger.debug("This is a 'DEBUG' message");
        spyLogger.debug("message {}", "arg1");
        spyLogger.debug("message {} {}", "arg1", "arg2");
        spyLogger.debug("message {} {} {}", "arg1", "arg2", "arg3");
        spyLogger.debug("message", new Throwable());

        when(spyLogger.isDebugEnabled()).thenReturn(false);
        spyLogger.debug("This is a 'DEBUG' message");
        spyLogger.debug("message {}", "arg1");
        spyLogger.debug("message {} {}", "arg1", "arg2");
        spyLogger.debug("message {} {}", "arg1", "arg2", "arg3");
        spyLogger.debug("message",  new Exception("Hello, world!"));
    }

    @Test
    public void testEnableForInfo() {
        Logger spyLogger = spy(logger);
        when(spyLogger.isInfoEnabled()).thenReturn(true);
        spyLogger.info("This is an 'INFO' message");
        spyLogger.info("message {}", "arg1");
        spyLogger.info("message {} {}", "arg1", "arg2");
        spyLogger.info("message {} {} {}", "arg1", "arg2", "arg3");
        spyLogger.info("message", new Throwable());

        when(spyLogger.isInfoEnabled()).thenReturn(false);
        spyLogger.info("This is an 'INFO' message");
        spyLogger.info("message {}", "arg1");
        spyLogger.info("message {} {}", "arg1", "arg2");
        spyLogger.info("message {} {}", "arg1", "arg2", "arg3");
        spyLogger.info("message",  new Exception("Hello, world!"));
    }

    @Test
    public void testEnableForWarn() {
        Logger spyLogger = spy(logger);
        when(spyLogger.isWarnEnabled()).thenReturn(true);
        spyLogger.warn("This is a 'WARN' message");
        spyLogger.warn("message {}", "arg1");
        spyLogger.warn("message {} {}", "arg1", "arg2");
        spyLogger.warn("message {} {} {}", "arg1", "arg2", "arg3");
        spyLogger.warn("message", new Throwable());

        when(spyLogger.isWarnEnabled()).thenReturn(false);
        spyLogger.warn("This is a 'WARN' message");
        spyLogger.warn("message {}", "arg1");
        spyLogger.warn("message {} {}", "arg1", "arg2");
        spyLogger.warn("message {} {}", "arg1", "arg2", "arg3");
        spyLogger.warn("message",  new Exception("Hello, world!"));
    }

    @Test
    public void testEnableForError() {
        Logger spyLogger = spy(logger);
        when(spyLogger.isErrorEnabled()).thenReturn(true);
        spyLogger.error("This is an 'ERROR' message");
        spyLogger.error("message {}", "arg1");
        spyLogger.error("message {} {}", "arg1", "arg2");
        spyLogger.error("message {} {} {}", "arg1", "arg2", "arg3");
        spyLogger.error("message", new Throwable());

        when(spyLogger.isErrorEnabled()).thenReturn(false);
        spyLogger.error("This is an 'ERROR' message");
        spyLogger.error("message {}", "arg1");
        spyLogger.error("message {} {}", "arg1", "arg2");
        spyLogger.error("message {} {}", "arg1", "arg2", "arg3");
        spyLogger.error("message",  new Exception("Hello, world!"));
    }

    @Test
    public void testExceptionLogging() {
        logger.info("Now log a wonderful exception", new Exception("Hello, world!"));
    }

    @Test
    public void testParametersLogging() {
        logger.info("I have {} apples and {} bananas", 2, "three");
    }
}
