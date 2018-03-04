package students.client.events;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import students.client.Student;

/**
 * Created by ilyaP on 14.02.2018.
 */
public class EditorShowEvent extends Event<EditorShowEvent.Handler> {
    private Student student;

    public EditorShowEvent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
    public interface Handler {
        void onEditor(EditorShowEvent event);
    }

    public static Type<EditorShowEvent.Handler> TYPE = new Type<EditorShowEvent.Handler>();

    public Type<EditorShowEvent.Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onEditor(this);
    }

    public static HandlerRegistration register(EventBus eventBus, EditorShowEvent.Handler handler){
        return eventBus.addHandler(TYPE,handler);
    }

}
