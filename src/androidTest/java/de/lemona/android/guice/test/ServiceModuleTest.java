package de.lemona.android.guice.test;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.test.ServiceTestCase;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import junit.framework.Assert;

import de.lemona.android.guice.ServiceModule;

public class ServiceModuleTest extends ServiceTestCase<TestService> {

    public ServiceModuleTest() {
        super(TestService.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.bindService(new Intent(getSystemContext(), TestService.class));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testNotNullInjection() {
        final Service Service = getService();
        Assert.assertNotNull("Null Service in test", Service);

        final Injector injector = Guice.createInjector(new ServiceModule(Service));

        Assert.assertNotNull("Null Service instance",          injector.getInstance(Service.class));
        Assert.assertNotNull("Null Application instance",       injector.getInstance(Application.class));
    }

    public void testInjectionInstances() {
        final Service Service = getService();
        Assert.assertNotNull("Null Service in test", Service);

        final Injector injector = Guice.createInjector(new ServiceModule(Service));

        Assert.assertSame("Invalid Service instance",          Service,                               injector.getInstance(Service.class));
        Assert.assertSame("Invalid Application instance",       Service.getApplication(),              injector.getInstance(Application.class));
    }

    public void testInjectee() {
        final Service Service = getService();
        Assert.assertNotNull("Null Service in test", Service);

        final Injector injector = Guice.createInjector(new ServiceModule(Service));
        injector.getInstance(ServiceInjectee.class).validate(Service);
    }

    /* ========================================================================================== */

    public static class ServiceInjectee {

        @Inject Service     service;
        @Inject Application application;

        public void validate(Service service) {
            Assert.assertNotNull("Null Service instance", this.service);
            Assert.assertNotNull("Null Application instance", this.application);

            Assert.assertSame("Invalid Service instance",     service,                  this.service);
            Assert.assertSame("Invalid Application instance", service.getApplication(), this.application);
        }
    }
}
