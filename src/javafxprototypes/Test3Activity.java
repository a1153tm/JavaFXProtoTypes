package javafxprototypes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafxprototypes.client.AbstractActivity;
import javafxprototypes.client.RequestButton;
import javafxprototypes.client.RequestHyperLink;
import javafxprototypes.client.View;

public class Test3Activity extends AbstractActivity
{
    public Test3Activity()
    {
        VBox form = new VBox();
        Label label = new Label("Test3 page");
        label.setFont(new Font("Arial", 30));
        TextField tf = new TextField();
        tf.setId("textTest"); 
        //RequestHyperLink rl = new RequestHyperLink("/test3", "To Test3");

        form.getChildren().addAll(label, tf);

        setView(new View(form));
    }
}
