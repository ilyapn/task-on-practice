package students.client.activities.students;

import students.client.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilyaP on 21.02.2018.
 */
public interface AbstractStudentsActivity {
    List<Student> students = new ArrayList<Student>();

    void onRefresh();
}
