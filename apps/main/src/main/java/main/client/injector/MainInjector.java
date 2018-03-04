package main.client.injector;

import app.client.injector.AppInjector;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;

@GinModules(MainClientModule.class)
public interface MainInjector extends AppInjector {
    EventBus getBus();
}
