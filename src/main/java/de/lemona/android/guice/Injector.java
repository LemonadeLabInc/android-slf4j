package de.lemona.android.guice;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;

public interface Injector {

    public com.google.inject.Injector getInjector();

    public <T> T getInstance(Key<T> key);

    public <T> T getInstance(TypeLiteral<T> type);

    public <T> T getInstance(Class<T> type);

    public <T> T injectMembers(T object);

}
