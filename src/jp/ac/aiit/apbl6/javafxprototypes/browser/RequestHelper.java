package jp.ac.aiit.apbl6.javafxprototypes.browser;

import javafx.scene.Node;

public class RequestHelper<T extends Node & Requestable>
{
    private T control;
    private Browser browser;
    
    public  RequestHelper(T control)
    {
        this.control = control;
    }
    
    private void getBrowser()
    {
        Object o = control.getParent();
        while (o != null && o instanceof Node) {
            if (o instanceof Browser) {
                browser = (Browser)o;
                return;
            }
            o = ((Node)o).getParent();
        }
        browser = null;
    }

    public void setBrowser(Browser browser)
    {
        this.browser = browser;
    }
    
    public void doRequest()
    {
        if (browser == null)
            getBrowser();
        if (browser != null)
            browser.getBroker().sendRequest(control);
    }
}
