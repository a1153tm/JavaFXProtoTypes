package javafxprototypes;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafxprototypes.client.AbstractActivity;
import javafxprototypes.client.RequestButton;
import javafxprototypes.client.View;

public class Test1Activity extends AbstractActivity
{
    public Test1Activity()
    {
        VBox form = new VBox();
        Label label = new Label("Test1 page");
        label.setFont(new Font("Arial", 30));
        TextField tf = new TextField();
        tf.setId("textTest"); 
        RequestButton rb = new RequestButton("/test2", RequestButton.POST, "To Test2");

        form.getChildren().addAll(label, tf, rb);

        setView(new View(form));

    }
}
