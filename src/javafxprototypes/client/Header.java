package javafxprototypes.client;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Header extends StackPane
{
    private Browser browser;
    private BackButton backButton;
    private ForwardButton forwardButton;
    private AddressBar addresBar;
    private String title;
    
    public Header(Transitions transitions, String title)
    {
        buildView(transitions, title);
    }
        
    private void buildView(Transitions transitions, String title)
    {
        HBox tray = buildTray();

        buildHistoryButtons(transitions);
        buildAddressBar(transitions);
        tray.getChildren().addAll(backButton, forwardButton, addresBar);

        getChildren().add(tray);
    }

    private HBox buildTray()
    {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5, 5, 5, 5));
        hbox.setSpacing(5);
        hbox.setStyle("-fx-background-color: #e6e6fa;");
        return hbox;
    }
    
    private void buildHistoryButtons(Transitions transitions)
    {
        backButton = new BackButton(transitions);
        forwardButton = new ForwardButton(transitions);
    }

    private void buildAddressBar(Transitions transitions)
    {
        addresBar = new AddressBar(transitions);
    }
}
