package students.client.activities.students;

import students.client.events.InitAppEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import students.client.Student;
import students.client.events.CreateStudentEvent;
import students.client.events.EditorShowEvent;
import students.client.events.RefreshViewEvent;
import students.client.views.students.AbstractStudentsView;

import javax.inject.Inject;

/**
 * Created by ilyaP on 21.02.2018.
 */
public class StudentsActivity implements AbstractStudentsActivity {
    private final EventBus eventBus;
    private final AbstractStudentsView studentsView;

    RefreshViewEvent.Handler handlerRefresh = new RefreshViewEvent.Handler() {
        @Override
        public void onRefreshView(RefreshViewEvent event) {
            onRefresh();
        }
    };

    InitAppEvent.Handler handlerInitAppEvent = new InitAppEvent.Handler() {
        @Override
        public void onInitApp(InitAppEvent event) {
            if (studentsView.getVerticalPanel() instanceof VerticalPanel)
                event.getWidget().add(((VerticalPanel) studentsView.getVerticalPanel()));
        }
    };

    @Inject
    public StudentsActivity(EventBus eventBus, AbstractStudentsView studentsView) {
        this.eventBus = eventBus;
        this.studentsView = studentsView;
        studentsView.setStudentsActivity(this);

        RefreshViewEvent.register(eventBus, handlerRefresh);
        InitAppEvent.register(eventBus, handlerInitAppEvent);

        CreateStudentEvent.register(eventBus, new CreateStudentEvent.Handler() {
            @Override
            public void onCreate(CreateStudentEvent event) {
                students.add(event.getStudent());
            }
        });
    }

    @Override
    public void onRefresh() {
        studentsView.getVerticalPanel().clear();

        for (Student student : students) {
            if (!student.isExist()) {
                students.remove(student);
                continue;
            }
            HorizontalPanel panel = new HorizontalPanel();
            Label nameLabel = new Label(student.getName());
            Button deleteButton = new Button("delete");
            Button editorButton = new Button("editor");

            panel.setSize("300px", "20px");
            nameLabel.setSize("200px", "100%");
            editorButton.setSize("50px", "100%");
            deleteButton.setSize("50px", "100%");
            panel.add(nameLabel);
            panel.add(deleteButton);
            panel.add(editorButton);
            studentsView.getVerticalPanel().add(panel);


            deleteButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    students.remove(student);
                    eventBus.fireEvent(new RefreshViewEvent());
                }
            });
            editorButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    eventBus.fireEvent(new EditorShowEvent(student));
                }
            });
        }
    }
}
