package javafxprototypes.client;

import java.util.LinkedList;
import java.util.List;

public class Transitions
{
    private List<View> fowardHistory = new LinkedList<View>();
    private List<View> backHistory = new LinkedList<View>();
    private View currentView = null;
    
    public View getCurrentView()
    {
        return currentView;
    }
    
    public void goTo(View newView)
    {
        View oldView = currentView;
        currentView = newView;
        
        if (oldView != currentView)
        {
            fowardHistory.clear();
            backHistory.add(oldView);
        }
    }
    
    public void goForward()
    {
        if (!fowardHistory.isEmpty())
        {
            if (currentView != null)
                backHistory.add(backHistory.size(), currentView);
            View fowardView = backHistory.remove(0);
            currentView = fowardView;
        }
    }
        
    public void goBack()
    {
        if (!backHistory.isEmpty())
        {
            if (currentView != null)
                fowardHistory.add(0, currentView);
            View backView = backHistory.remove(backHistory.size() - 1);
            currentView = backView;
        }
    }

    public boolean isTopOfHistory()
    {
        return fowardHistory.isEmpty();
    }

    public boolean isLastOfHistory()
    {
        return backHistory.isEmpty();
    }
}
