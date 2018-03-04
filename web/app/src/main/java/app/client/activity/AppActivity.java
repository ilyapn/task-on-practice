package app.client.activity;


import app.client.view.AbstractAppView;
import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import students.client.events.InitAppEvent;
import students.client.events.MakeShowEvent;


/**
 * Created by ilyaP on 21.02.2018.
 */
public class AppActivity implements AbstractAppActivity {

    private EventBus eventBus;

    @Inject
    public AppActivity(final EventBus eventBus, AbstractAppView appView) {
        this.eventBus = eventBus;
        appView.setAppActivity(AppActivity.this);
        eventBus.fireEvent(new InitAppEvent(appView.getMainPanel()));

    }

    @Override
    public void onMakeShow(){
        eventBus.fireEvent(new MakeShowEvent());
    }


}
