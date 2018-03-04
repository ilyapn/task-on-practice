package students.client.events;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import students.client.Student;

/**
 * Created by ilyaP on 19.02.2018.
 */
public class CreateStudentEvent extends Event<CreateStudentEvent.Handler> {

    public static Event.Type<CreateStudentEvent.Handler> TYPE = new Event.Type<CreateStudentEvent.Handler>();
    private Student student;

    public CreateStudentEvent(Student student) {
        this.student = student;
    }

    @Override
    public Event.Type<CreateStudentEvent.Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CreateStudentEvent.Handler handler) {
        handler.onCreate(this);
    }

    public Student getStudent() {
        return student;
    }


    public interface Handler {
        void onCreate(CreateStudentEvent event);
    }

    public static HandlerRegistration register(EventBus eventBus, CreateStudentEvent.Handler handler){
        return eventBus.addHandler(TYPE,handler);
    }
}
