package javafxprototypes.client;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class AddressBar extends StackPane implements Requestable {
    private Browser browser;
    private TextField inputBox;
    private String url;
    private String method = GET;

    public AddressBar(Browser browser)
    {
        this.browser = browser;
        inputBox = new TextField();
        inputBox.setPrefWidth(1000);
        inputBox.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    AddressBar.this.url = inputBox.getText();
                    doRequest();
                }
            });
        getChildren().add(inputBox);
    }

    @Override
    public void doRequest()
    {
        browser.getBroker().sendRequest(url, method);
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getMethod() {
        return method;
    }
}
