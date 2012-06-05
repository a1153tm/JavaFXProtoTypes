package jp.ac.aiit.apbl6.javafxprototypes.browser;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.StackPane;

public class Body extends StackPane
{
    public Body(Transitions transitions)
    {
        transitions.currentViewProperty().addListener(new ChangeListener<View>()
        {
            @Override
            public void changed(ObservableValue<? extends View> source,
                                View oldView, View newView)
            {
                setView(newView);
            }
        });
    };
    
    public final void setView(View view)
    {
        getChildren().clear();
        getChildren().add(view.toNode());
    }
}
