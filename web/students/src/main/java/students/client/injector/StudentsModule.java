package students.client.injector;


import com.google.gwt.inject.client.AbstractGinModule;
import students.client.activities.edit.EditActivity;
import students.client.activities.make.MakeActivity;
import students.client.activities.students.StudentsActivity;
import students.client.views.edit.AbstractEditView;
import students.client.views.edit.EditView;
import students.client.views.make.AbstractMakeView;
import students.client.views.make.MakeView;
import students.client.views.students.AbstractStudentsView;
import students.client.views.students.StudentsView;

import javax.inject.Singleton;

public class StudentsModule extends AbstractGinModule {
    @Override
    protected void configure() {
        bind(AbstractMakeView.class).to(MakeView.class).asEagerSingleton();
        bind(MakeActivity.class).asEagerSingleton();

        bind(AbstractStudentsView.class).to(StudentsView.class).in(Singleton.class);
        bind(StudentsActivity.class).asEagerSingleton();

        bind(AbstractEditView.class).to(EditView.class).in(Singleton.class);
        bind(EditActivity.class).asEagerSingleton();

    }
}
