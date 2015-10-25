package de.lemona.android.guice.test;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.test.ServiceTestCase;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import junit.framework.Assert;

import de.lemona.android.guice.Injection;
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
        final Service service = getService();
        Assert.assertNotNull("Null service in test", service);

        final Injector injector = Guice.createInjector(new ServiceModule(service));

        Assert.assertNotNull("Null service instance",     injector.getInstance(Service.class));
        Assert.assertNotNull("Null Application instance", injector.getInstance(Application.class));
    }

    public void testInjectionInstances() {
        final Service service = getService();
        Assert.assertNotNull("Null Service in test", service);

        final Injector injector = Guice.createInjector(new ServiceModule(service));

        Assert.assertSame("Invalid Service instance", service, injector.getInstance(Service.class));
        Assert.assertSame("Invalid Application instance", service.getApplication(), injector.getInstance(Application.class));
    }

    public void testInjectee() {
        final Service service = getService();
        Assert.assertNotNull("Null Service in test", service);

        final Injector injector = Guice.createInjector(new ServiceModule(service));
        injector.getInstance(ServiceInjectee.class).validate(service);
    }

    public void testInjection() {
        final Service service = getService();
        Assert.assertNotNull("Null Service in test", service);

        Injection.createInjector(service).getInstance(ServiceInjectee.class).validate(service);
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
