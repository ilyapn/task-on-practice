package students.client.views.make;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import students.client.activities.make.AbstractMakeActivity;

/**
 * Created by ilyaP on 20.02.2018.
 */
public interface AbstractMakeView extends IsWidget {
    HasValue<String> getName();

    HasClickHandlers getMakeButton();

    HasClickHandlers getCloseButton();

    IsWidget getPopupPanel();

    void setMakeActivity(AbstractMakeActivity makeActivity);

}
