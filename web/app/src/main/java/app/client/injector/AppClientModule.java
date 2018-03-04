package app.client.injector;


import app.client.activity.AppActivity;
import app.client.view.AbstractAppView;
import app.client.view.AppView;
import com.google.gwt.inject.client.AbstractGinModule;

import javax.inject.Singleton;

public class AppClientModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(AbstractAppView.class).to(AppView.class).in(Singleton.class);
        bind(AppActivity.class).asEagerSingleton();
    }
}
