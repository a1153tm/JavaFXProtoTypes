package jp.ac.aiit.apbl6.javafxprototypes.sample;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;

public class InputBoxes extends Activity {
    @FXML
    TextField textField;
    
    @FXML
    PasswordField passwordField;
    
    private Login parent;
  
    @Override
    public final void setParent(Activity parent) {
        this.parent = (Login) parent;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        passwordField.setOnAction(new EventHandler<ActionEvent>()
                {
                    public void handle(ActionEvent e) {
                        
                    }
                });
                *
                */
    }
        
    @FXML
    public void passwordChanged() {
        System.out.println("ok:dudada");
        //passwordField.set
        
    }
    
    public void setTtextFieldEnabled(boolean mode) {
        textField.setEditable(mode);
    }

    public void setPasswordField(boolean mode) {
        passwordField.setEditable(mode);
    }
    
    public String getTextViledValue() {
        return textField.getText();
    }
    
    public String getPasswordField() {
        return passwordField.getText();
    }
}
