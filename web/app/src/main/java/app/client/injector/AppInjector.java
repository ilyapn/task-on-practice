package app.client.injector;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import students.client.injector.StudentsModule;

@GinModules(StudentsModule.class)
public interface AppInjector extends Ginjector {
}
