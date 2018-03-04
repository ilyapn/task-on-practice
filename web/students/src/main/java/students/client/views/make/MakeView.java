package students.client.views.make;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import students.client.activities.make.AbstractMakeActivity;

/**
 * Created by ilyaP on 20.02.2018.
 */
public class MakeView extends Composite implements AbstractMakeView {
    private static MakeViewUiBinder ourUiBinder = GWT.create(MakeViewUiBinder.class);
    @UiField
    PopupPanel popupPanel;
    @UiField
    TextBox nameTextBox;
    @UiField
    Button makeButton;
    @UiField
    Button closeButton;
    private AbstractMakeActivity makeActivity;

    interface MakeViewUiBinder extends UiBinder<HTMLPanel, MakeView> {
    }

    public MakeView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public HasValue<String> getName() {
        return nameTextBox;
    }

    @Override
    public Button getMakeButton() {
        return makeButton;
    }

    @Override
    public Button getCloseButton() {
        return closeButton;
    }

    @Override
    public PopupPanel getPopupPanel() {
        return popupPanel;
    }


    @UiHandler("closeButton")
    public void closeButtonClick(ClickEvent event) {
        if (makeActivity != null)
            makeActivity.onHandleClose();
    }

    @UiHandler("makeButton")
    public void makeButtonClick(ClickEvent event) {
        if (makeActivity != null)
            makeActivity.onHandleMake();
    }

    public void setMakeActivity(AbstractMakeActivity makeActivity) {
        this.makeActivity = makeActivity;
    }


}