package students.client.activities.make;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.PopupPanel;
import students.client.Student;
import students.client.events.CreateStudentEvent;
import students.client.events.MakeShowEvent;
import students.client.events.RefreshViewEvent;
import students.client.views.make.AbstractMakeView;

import javax.inject.Inject;

/**
 * Created by ilyaP on 20.02.2018.
 */
public class MakeActivity implements AbstractMakeActivity {
    private final EventBus eventBus;
    private final AbstractMakeView makeView;


    @Inject
    public MakeActivity(EventBus eventBus, AbstractMakeView makeView) {
        this.eventBus = eventBus;
        this.makeView = makeView;
        makeView.setMakeActivity(this);
        showInit(eventBus, makeView);
    }

    private void showInit(EventBus eventBus, AbstractMakeView makeView) {
        MakeShowEvent.register(eventBus, new MakeShowEvent.Handler() {
            @Override
            public void onShow(MakeShowEvent event) {
                if (makeView.getPopupPanel() instanceof PopupPanel) {
                    ((PopupPanel) makeView.getPopupPanel()).center();
                    ((PopupPanel) makeView.getPopupPanel()).show();
                }
            }
        });
    }

    @Override
    public void onHandleClose() {
        if (makeView.getPopupPanel() instanceof PopupPanel) {
            ((PopupPanel) makeView.getPopupPanel()).hide();
            makeView.getName().setValue("");
        }
    }

    @Override
    public void onHandleMake() {
        if (makeView.getPopupPanel() instanceof PopupPanel) {
            if (makeView.getName().getValue().isEmpty())
                return;
            ((PopupPanel) makeView.getPopupPanel()).hide();
            eventBus.fireEvent(new CreateStudentEvent(new Student(makeView.getName().getValue())));
            eventBus.fireEvent(new RefreshViewEvent());
            makeView.getName().setValue("");
        }
    }

}
