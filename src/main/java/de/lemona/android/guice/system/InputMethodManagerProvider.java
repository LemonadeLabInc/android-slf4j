package de.lemona.android.guice.system;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class InputMethodManagerProvider extends AbstractServiceProvider<InputMethodManager> {

    @Inject
    public InputMethodManagerProvider(Context context) {
        super(Context.INPUT_METHOD_SERVICE, InputMethodManager.class, context);
    }

}
