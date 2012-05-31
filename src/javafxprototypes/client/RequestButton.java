package javafxprototypes.client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class RequestButton extends Button implements Requestable
{
    private String url;
    private String method;
    private RequestHelper<RequestButton> helper;

    public RequestButton(String url, String method)
    {
        this(url, method, null);
    }
    public RequestButton(String url, String method, String title)
    {
        this.setText(title);
        this.url = url;
        this.method = method;
        this.helper = new RequestHelper(this);
        this.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    doRequest();
                }
            });
    }

    @Override
    public void doRequest()
    {
        helper.doRequest();
    }

    @Override
    public String getUrl()
    {
        return url;
    }

    @Override
    public String getMethod()
    {
        return method;
    }
    
    public void setUrl(String url)
    {
        this.url = url;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }
}
