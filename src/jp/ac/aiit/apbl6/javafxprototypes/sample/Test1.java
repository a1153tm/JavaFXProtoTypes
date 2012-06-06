package jp.ac.aiit.apbl6.javafxprototypes.sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.browser.RequestHyperLink;

public class Test1 extends Activity
{
    @FXML
    VBox vbox;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbox.getChildren().add(new RequestHyperLink("/test2", "go to Test2"));
    }

    @Override
    public void setParent(Activity parent) {
    }
}
