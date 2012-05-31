package javafxprototypes.client;

import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class HistoryButton extends Button
{
    protected Transitions transitions;
    protected ObservableList<View> history;

    protected HistoryButton(Transitions transitions)
    {
        this.transitions = transitions;
        this.history = getHistory();

        this.history.addListener(new ListChangeListener<View>()
        {
            @Override
            public void onChanged(Change<? extends View> c) {
                if (history.isEmpty())
                    HistoryButton.this.setDisable(true);
                else
                    HistoryButton.this.setDisable(false);
            }
        });

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if (HistoryButton.this.transitions != null)
                    doAction();
                else
                    throw new IllegalStateException("A Transitions must be set before using this HistoyButton");
            }
        });
        
        setDisable(true);
    }
    
    protected abstract ObservableList<View> getHistory();
    protected abstract void doAction();
    protected abstract void buildView();
}
