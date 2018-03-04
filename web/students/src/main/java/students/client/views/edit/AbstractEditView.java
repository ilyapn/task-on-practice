package students.client.views.edit;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.IsWidget;
import students.client.activities.edit.AbstractEditActivity;

/**
 * Created by ilyaP on 21.02.2018.
 */
public interface AbstractEditView {
    void setEditActivity(AbstractEditActivity editActivity);

    HasClickHandlers getCloseButton();

    HasClickHandlers getSaveButton();

    IsWidget getPopupPanel();

    IsWidget getIdLabel();

    IsWidget getDateMakeLabel();

    IsWidget getDateChangeLabel();

    IsWidget getNameTextBox();
}
