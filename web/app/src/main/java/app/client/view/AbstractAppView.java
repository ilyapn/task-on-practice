package app.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import app.client.activity.AbstractAppActivity;


/**
 * Created by ilyaP on 21.02.2018.
 */
public interface AbstractAppView extends IsWidget {

    HasClickHandlers getMakeButton();

    HasWidgets getMainPanel();

    void setAppActivity(AbstractAppActivity appActivity);
}
