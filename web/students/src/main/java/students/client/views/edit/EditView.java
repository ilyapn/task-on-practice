package students.client.views.edit;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import students.client.activities.edit.AbstractEditActivity;

/**
 * Created by ilyaP on 21.02.2018.
 */
public class EditView extends Composite implements AbstractEditView {
    @UiField
    public Label idLabel;
    @UiField
    Label dateMakeLabel;
    @UiField
    Label dateChangeLabel;
    @UiField
    TextBox nameTextBox;
    @UiField
    Button saveButton;
    @UiField
    Button closeButton;
    @UiField
    VerticalPanel verticalPanel;
    @UiField
    public PopupPanel popupPanel;

    private AbstractEditActivity editActivity;


    public EditView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public void setEditActivity(AbstractEditActivity editActivity) {
        this.editActivity = editActivity;
    }



    @Override
    public Button getCloseButton() {
        return closeButton;
    }

    @Override
    public Button getSaveButton() {
        return saveButton;
    }

    @Override
    public PopupPanel getPopupPanel() {
        return popupPanel;
    }

    @Override
    public Label getIdLabel() {
        return idLabel;
    }

    @Override
    public Label getDateMakeLabel() {
        return dateMakeLabel;
    }

    @Override
    public Label getDateChangeLabel() {
        return dateChangeLabel;
    }

    @Override
    public TextBox getNameTextBox() {
        return nameTextBox;
    }

    @UiHandler("saveButton")
    public void saveButtonClick(ClickEvent event) {
        if (editActivity != null)
            editActivity.onHandleSave();
    }

    @UiHandler("closeButton")
    public void closeButtonClick(ClickEvent event) {
        if (editActivity != null)
            editActivity.onHandleClose();
    }

    interface editViewUiBinder extends UiBinder<HTMLPanel, EditView> {
    }

    private static editViewUiBinder ourUiBinder = GWT.create(editViewUiBinder.class);
}