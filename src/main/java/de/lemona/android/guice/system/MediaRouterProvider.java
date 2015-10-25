package de.lemona.android.guice.system;

import android.content.Context;
import android.media.MediaRouter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MediaRouterProvider extends AbstractServiceProvider<MediaRouter> {

    @Inject
    public MediaRouterProvider(Context context) {
        super(Context.MEDIA_ROUTER_SERVICE, MediaRouter.class, context);
    }

}
