package main.client.injector;

import app.client.injector.AppInjector;
import app.client.injector.AppClientModule;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

import javax.inject.Singleton;

public class MainClientModule extends AppClientModule {
    @Override
    protected void configure() {
        super.configure();
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
        bind(AppInjector.class).to(MainInjector.class).in(Singleton.class);

    }
}
