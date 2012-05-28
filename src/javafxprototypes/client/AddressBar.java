package javafxprototypes.client;

import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

public class AddressBar extends StackPane {
    TextField inputBox;

    public AddressBar(Transitions transitions)
    {
        inputBox = new TextField();
        inputBox.setPrefWidth(1000);
        getChildren().add(inputBox);
    }
}
