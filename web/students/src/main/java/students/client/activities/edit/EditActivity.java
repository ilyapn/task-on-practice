package students.client.activities.edit;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import students.client.Student;
import students.client.events.EditorShowEvent;
import students.client.events.RefreshViewEvent;
import students.client.views.edit.AbstractEditView;

import javax.inject.Inject;

/**
 * Created by ilyaP on 21.02.2018.
 */
public class EditActivity implements AbstractEditActivity {
    private final EventBus eventBus;
    private final AbstractEditView editView;
    private Student student;

    @Inject
    public EditActivity(EventBus eventBus, AbstractEditView editView) {
        this.eventBus = eventBus;
        this.editView = editView;
        editView.setEditActivity(this);



        EditorShowEvent.register(eventBus, new EditorShowEvent.Handler() {
            @Override
            public void onEditor(EditorShowEvent event) {
                if (editView.getPopupPanel() instanceof PopupPanel) {
                    ((PopupPanel) editView.getPopupPanel()).center();
                    ((PopupPanel) editView.getPopupPanel()).show();
                    setStudent(event.getStudent());
                }
            }
        });
    }

    public void setStudent(Student student) {
        this.student = student;
        if (editView.getIdLabel() instanceof Label &&
                editView.getDateMakeLabel() instanceof Label &&
                editView.getDateChangeLabel() instanceof Label
                ) {
            ((Label) editView.getIdLabel()).setText(student.getIdOfUniversity() + "");
            ((Label) editView.getDateMakeLabel()).setText(student.getDateCreate() + "");
            ((Label) editView.getDateChangeLabel()).setText(student.getDateChange() + "");
        }
    }

    @Override
    public void onHandleSave() {
        if (editView.getPopupPanel() instanceof PopupPanel &&
                editView.getNameTextBox() instanceof TextBox) {
            if (((TextBox) editView.getNameTextBox()).getText().equals(""))
                return;
            student.setName(((TextBox) editView.getNameTextBox()).getText());
            ((PopupPanel) editView.getPopupPanel()).hide();
            ((TextBox) editView.getNameTextBox()).setValue("");
            eventBus.fireEvent(new RefreshViewEvent());
        }
    }

    @Override
    public void onHandleClose() {
        if (editView.getPopupPanel() instanceof PopupPanel)
            ((PopupPanel) editView.getPopupPanel()).hide();
    }
}
