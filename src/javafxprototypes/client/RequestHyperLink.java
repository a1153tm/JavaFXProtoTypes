package javafxprototypes.client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Hyperlink;

public class RequestHyperLink extends Hyperlink implements Requestable
{
    private String url;
    private String method;
    private RequestHelper<RequestHyperLink> helper;

    public RequestHyperLink(String url)
    {
        this(url, url);
    }
    public RequestHyperLink(String url, String title)
    {
        this.setText(title);
        this.url = url;
        this.method = GET;
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
