package de.lemona.android.slf4j.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.lemona.android.slf4j.AndroidLogger;

public class LoggingTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test(priority=1)
    public void testInstance() {
        Assert.assertNotNull(logger, "Logger is null");
        logger.info("The logger class is {}", logger.getClass());
        Assert.assertTrue(logger instanceof AndroidLogger, "Wrong logger class: " + logger.getClass());
    }

    @Test(priority=2)
    public void testSimpleLogging() {
        logger.trace("This is a 'TRACE' message");
        logger.debug("This is a 'DEBUG' message");
        logger.info("This is an 'INFO' message");
        logger.warn("This is a 'WARN' message");
        logger.error("This is an 'ERROR' message");
    }

    @Test(priority=3)
    public void testExceptionLogging() {
        logger.info("Now log a wonderful exception", new Exception("Hello, world!"));
    }

    @Test(priority=4)
    public void testParametersLogging() {
        logger.info("I have {} apples and {} bananas", 2, "three");
    }
}
