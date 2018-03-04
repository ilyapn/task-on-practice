package students.client.events;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;


/**
 * Created by ilyaP on 15.02.2018.
 */
public class MakeShowEvent extends Event<MakeShowEvent.Handler> {


    public static Type<MakeShowEvent.Handler> TYPE = new Type<MakeShowEvent.Handler>();

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onShow(this);
    }


    public interface Handler {
        void onShow(MakeShowEvent event);
    }

    public static HandlerRegistration register(EventBus eventBus, Handler handler){
        return eventBus.addHandler(TYPE,handler);
    }
}
