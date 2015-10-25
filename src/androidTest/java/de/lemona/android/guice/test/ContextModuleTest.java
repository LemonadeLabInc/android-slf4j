package de.lemona.android.guice.test;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.test.AndroidTestCase;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;

import junit.framework.Assert;

import de.lemona.android.guice.AppContext;
import de.lemona.android.guice.ContextModule;
import de.lemona.android.guice.Injection;

public class ContextModuleTest extends AndroidTestCase {

    public void testNotNullInjection() {
        final Context context = getContext();
        final Context applicationContext = context.getApplicationContext();
        Assert.assertNotNull("Null context in test", context);
        Assert.assertNotNull("Null applicationContext in test", applicationContext);
        Assert.assertNotSame("Same context/applicationContext", context, applicationContext);

        final Injector injector = Guice.createInjector(new ContextModule(context));

        Assert.assertNotNull("Null Context instance", injector.getInstance(Context.class));
        Assert.assertNotNull("Null Context instance", injector.getInstance(Key.get(Context.class, AppContext.class)));

        Assert.assertNotNull("Null ApplicationInfo instance", injector.getInstance(ApplicationInfo.class));
        Assert.assertNotNull("Null AssetManager instance", injector.getInstance(AssetManager.class));
        Assert.assertNotNull("Null ContentResolver instance", injector.getInstance(ContentResolver.class));
        Assert.assertNotNull("Null PackageManager instance", injector.getInstance(PackageManager.class));
    }

    public void testInjectionInstances() {
        final Context context = getContext();
        final Context applicationContext = context.getApplicationContext();
        Assert.assertNotNull("Null context in test", context);
        Assert.assertNotNull("Null applicationContext in test", applicationContext);
        Assert.assertNotSame("Same context/applicationContext", context, applicationContext);

        final Injector injector = Guice.createInjector(new ContextModule(context));

        Assert.assertSame("Wrong Context instance", context, injector.getInstance(Context.class));
        Assert.assertSame("Wrong Application Context instance", context.getApplicationContext(), injector.getInstance(Key.get(Context.class, AppContext.class)));

        Assert.assertSame("Wrong ApplicationInfo instance", context.getApplicationInfo(), injector.getInstance(ApplicationInfo.class));
        Assert.assertSame("Wrong AssetManager instance", context.getAssets(), injector.getInstance(AssetManager.class));
        Assert.assertSame("Wrong ContentResolver instance", context.getContentResolver(), injector.getInstance(ContentResolver.class));
        Assert.assertSame("Wrong PackageManager instance", context.getPackageManager(), injector.getInstance(PackageManager.class));
    }

    public void testInjectee() {
        final Context context = getContext();
        Assert.assertNotNull("Null context in test", context);

        final Injector injector = Guice.createInjector(new ContextModule(context));
        injector.getInstance(ContextInjectee.class).validate(context);
    }

    public void testInjection() {
        final Context context = getContext();
        Assert.assertNotNull("Null context in test", context);

        Injection.createInjector(context).getInstance(ContextInjectee.class).validate(context);
    }

    /* ========================================================================================== */

    public static class ContextInjectee {

        @Inject @AppContext Context applicationContext;
        @Inject Context context;
        @Inject ApplicationInfo applicationInfo;
        @Inject AssetManager assetManager;
        @Inject ContentResolver contentResolver;
        @Inject PackageManager packageManager;

        public void validate(Context context) {

            Assert.assertNotNull("Null Context instance", this.applicationContext);
            Assert.assertNotNull("Null Context instance", this.context);

            Assert.assertNotNull("Null ApplicationInfo instance", this.applicationInfo);
            Assert.assertNotNull("Null AssetManager instance", this.assetManager);
            Assert.assertNotNull("Null ContentResolver instance", this.contentResolver);
            Assert.assertNotNull("Null PackageManager instance", this.packageManager);

            Assert.assertSame("Wrong Application Context instance", context.getApplicationContext(), this.applicationContext);
            Assert.assertSame("Wrong Context instance", context, this.context);

            Assert.assertSame("Wrong ApplicationInfo instance", context.getApplicationInfo(), this.applicationInfo);
            Assert.assertSame("Wrong AssetManager instance", context.getAssets(), this.assetManager);
            Assert.assertSame("Wrong ContentResolver instance", context.getContentResolver(), this.contentResolver);
            Assert.assertSame("Wrong PackageManager instance", context.getPackageManager(), this.packageManager);
        }
    }
}
