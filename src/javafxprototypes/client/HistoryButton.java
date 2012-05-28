package javafxprototypes.client;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class HistoryButton extends Button
{
    protected ObjectProperty<Transitions> transitions;

    public HistoryButton(Transitions transitions)
    {
        this.transitions = new SimpleObjectProperty<Transitions>();
        this.transitions.set(transitions);
        this.transitions.addListener(new ChangeListener<Transitions>()
        {
            public void changed(ObservableValue<? extends Transitions> source,
                                Transitions oldTransitions, Transitions newTransitions)
            {
                HistoryButton.this.changed(newTransitions);
            }
        });

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Transitions transitions = HistoryButton.this.transitions.get();
                if (transitions != null)
                    doAction();
                else
                    throw new IllegalStateException("A Transitions must be set before using this HistoyButton");
            }
        });
    }
    
    protected abstract void changed(Transitions newTransitions);
    protected abstract void doAction();
    protected abstract void setView();
}
