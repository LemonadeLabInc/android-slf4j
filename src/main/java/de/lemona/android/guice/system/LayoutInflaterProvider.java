package de.lemona.android.guice.system;

import android.content.Context;
import android.view.LayoutInflater;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class LayoutInflaterProvider extends AbstractServiceProvider<LayoutInflater> {

    @Inject
    public LayoutInflaterProvider(Context context) {
        super(Context.LAYOUT_INFLATER_SERVICE, LayoutInflater.class, context);
    }

}
