package javafxprototypes.client;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Transitions
{
    private ObjectProperty<View> currentView;
    private ObservableList<View> backHistory;
    private ObservableList<View> forwardHistory;

    public Transitions()
    {
        currentView = new SimpleObjectProperty<View>();
        backHistory = FXCollections.observableArrayList();
        forwardHistory = FXCollections.observableArrayList();
    }

    public View getCurrentView()
    {
        return currentView.get();
    }
    
    public void goTo(View newView)
    {
        View oldView = currentView.get();
        currentView.set(newView);
        
        if (oldView != newView)
        {
            forwardHistory.clear();
            backHistory.add(oldView);
        }
    }
    
    public void goForward()
    {
        if (!forwardHistory.isEmpty())
        {
            if (currentView.get() != null) {
                System.out.println("forwarding");
                backHistory.add(backHistory.size(), currentView.get());
            }
            View forwardView = forwardHistory.remove(0);
            currentView.set(forwardView);
        }
    }
        
    public void goBack()
    {
        if (!backHistory.isEmpty())
        {
            if (currentView.get() != null)
                forwardHistory.add(0, currentView.get());
            View backView = backHistory.remove(backHistory.size() - 1);
            currentView.set(backView);
        }
    }

    public boolean isTopOfHistory()
    {
        return forwardHistory.isEmpty();
    }

    public boolean isLastOfHistory()
    {
        return backHistory.isEmpty();
    }

    public ObjectProperty<View> currentViewProperty()
    {
        return currentView;
    }

    public ObservableList<View> getBackHistory()
    {
        return backHistory;
    }

    public ObservableList<View> getForwardHistory()
    {
        return forwardHistory;
    }
    
    public void setCurrentView(View view)
    {
        currentView.set(view);
    }
}
