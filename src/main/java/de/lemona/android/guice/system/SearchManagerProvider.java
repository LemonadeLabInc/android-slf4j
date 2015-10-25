package de.lemona.android.guice.system;

import android.app.SearchManager;
import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SearchManagerProvider extends AbstractServiceProvider<SearchManager> {

    @Inject
    public SearchManagerProvider(Context context) {
        super(Context.SEARCH_SERVICE, SearchManager.class, context);
    }

}
