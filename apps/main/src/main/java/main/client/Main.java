package main.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import main.client.injector.MainInjector;

public class Main implements EntryPoint {


    public void onModuleLoad() {
        MainInjector injector = GWT.create(MainInjector.class);
    }
}
