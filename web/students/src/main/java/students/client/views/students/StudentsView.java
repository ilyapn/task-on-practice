package students.client.views.students;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import students.client.activities.students.AbstractStudentsActivity;

/**
 * Created by ilyaP on 21.02.2018.
 */
public class StudentsView extends Composite implements AbstractStudentsView {
    @UiField
    VerticalPanel verticalPanel;
    private AbstractStudentsActivity studentsActivity;

    interface StudentsViewUiBinder extends UiBinder<HTMLPanel, StudentsView> {

    }

    @Override
    public VerticalPanel getVerticalPanel() {
        return verticalPanel;
    }

    @Override
    public void setStudentsActivity(AbstractStudentsActivity studentsActivity) {
        this.studentsActivity = studentsActivity;
    }

    private static StudentsViewUiBinder ourUiBinder = GWT.create(StudentsViewUiBinder.class);

    public StudentsView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}