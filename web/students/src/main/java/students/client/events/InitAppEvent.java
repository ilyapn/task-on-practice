package students.client.events;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * Created by ilyaP on 19.02.2018.
 */
public class InitAppEvent extends Event<InitAppEvent.Handler> {
    public static Type<InitAppEvent.Handler> TYPE = new Type<InitAppEvent.Handler>();
    private HasWidgets widget;

    public InitAppEvent(HasWidgets widget) {
        this.widget = widget;
    }

    public HasWidgets getWidget() {
        return widget;
    }

    public static interface Handler{
        public void onInitApp(InitAppEvent event);
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onInitApp(this);
    }

    public static HandlerRegistration register(EventBus eventBus, InitAppEvent.Handler handler){
        return eventBus.addHandler(TYPE,handler);
    }
}
