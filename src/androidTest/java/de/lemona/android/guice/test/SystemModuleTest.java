package de.lemona.android.guice.test;

import android.app.ActivityManager;
import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.lemona.android.guice.SystemModule;

public class SystemModuleTest extends AndroidTestCase {

    public void testSimple() {
        final Injector injector = Guice.createInjector(new SystemModule());

        injector.getInstance(ActivityManager.class);
    }

}