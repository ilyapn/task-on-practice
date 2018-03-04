package students.client.events;


import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * Created by ilyaP on 14.02.2018.
 */
public class RefreshViewEvent extends Event<RefreshViewEvent.Handler> {
    public static GwtEvent.Type<RefreshViewEvent.Handler> TYPE = new GwtEvent.Type<RefreshViewEvent.Handler>();

    public RefreshViewEvent() {
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onRefreshView(this);
    }

    public interface Handler {
        void onRefreshView(RefreshViewEvent event);
    }

    public static HandlerRegistration register(EventBus eventBus, RefreshViewEvent.Handler handler) {
        return eventBus.addHandler(TYPE, handler);
    }
}
