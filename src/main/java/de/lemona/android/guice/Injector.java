package de.lemona.android.guice;

import com.google.inject.Key;
import com.google.inject.TypeLiteral;

public interface Injector {

    com.google.inject.Injector getInjector();

    <T> T getInstance(Key<T> key);

    <T> T getInstance(TypeLiteral<T> type);

    <T> T getInstance(Class<T> type);

    <T> T injectMembers(T object);

}
