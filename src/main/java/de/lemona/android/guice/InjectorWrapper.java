package de.lemona.android.guice;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;

public class InjectorWrapper implements Injector {

    private final com.google.inject.Injector injector;

    public InjectorWrapper(com.google.inject.Injector injector) {
        this.injector = injector;
    }

    @Override
    public com.google.inject.Injector getInjector() {
        return injector;
    }

    @Override
    public <T> T getInstance(Key<T> key) {
        return this.injector.getInstance(key);
    }

    @Override
    public <T> T getInstance(TypeLiteral<T> type) {
        return this.injector.getInstance(Key.get(type));
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        return this.injector.getInstance(type);
    }

    @Override
    public <T> T injectMembers(T object) {
        this.injector.injectMembers(object);
        return object;
    }
}
