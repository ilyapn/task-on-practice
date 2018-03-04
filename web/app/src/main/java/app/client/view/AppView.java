package app.client.view;


import app.client.activity.AbstractAppActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;


/**
 * Created by ilyaP on 21.02.2018.
 */
public class AppView extends Composite implements AbstractAppView {
    @UiField
    Button makeButton;
    @UiField
    VerticalPanel mainPanel;
    private AbstractAppActivity appActivity;

    private static AppViewUiBinder ourUiBinder = GWT.create(AppViewUiBinder.class);

    interface AppViewUiBinder extends UiBinder<HTMLPanel, AppView> {}

    public AppView() {
        initWidget(ourUiBinder.createAndBindUi(this));
        RootPanel.get().add(this);
    }

    @Override
    public void setAppActivity(AbstractAppActivity appActivity) {
        this.appActivity = appActivity;
    }

    @UiHandler("makeButton")
    public void closeButtonClick(ClickEvent event) {
        if (appActivity != null)
            appActivity.onMakeShow();
    }

    @Override
    public Button getMakeButton() {
        return makeButton;
    }

    @Override
    public VerticalPanel getMainPanel() {
        return mainPanel;
    }
}