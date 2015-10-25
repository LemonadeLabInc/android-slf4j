package de.lemona.android.guice;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;

public class InjectorWrapper implements Injector {

    volatile com.google.inject.Injector injector = null;

    InjectorWrapper() {
        this.injector = null;
    }

    InjectorWrapper(com.google.inject.Injector injector) {
        this.injector = injector;
    }

    @Override
    public com.google.inject.Injector getInjector() {
        if (this.injector == null) throw new IllegalStateException("Injector unavailable");
        return injector;
    }

    @Override
    public <T> T getInstance(Key<T> key) {
        return this.getInjector().getInstance(key);
    }

    @Override
    public <T> T getInstance(TypeLiteral<T> type) {
        return this.getInjector().getInstance(Key.get(type));
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        return this.getInjector().getInstance(type);
    }

    @Override
    public <T> T injectMembers(T object) {
        this.getInjector().injectMembers(object);
        return object;
    }
}
