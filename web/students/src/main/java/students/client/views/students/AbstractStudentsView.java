package students.client.views.students;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import students.client.activities.students.AbstractStudentsActivity;

/**
 * Created by ilyaP on 21.02.2018.
 */
public interface AbstractStudentsView extends IsWidget {

    HasWidgets getVerticalPanel();

    void setStudentsActivity(AbstractStudentsActivity studentsActivity);
}
