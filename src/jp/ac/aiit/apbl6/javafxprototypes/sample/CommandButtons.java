package jp.ac.aiit.apbl6.javafxprototypes.sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;

public class CommandButtons extends Activity {
    
    @FXML
    private Node view;
    
    @FXML
    private Button login;
    
    @FXML
    private Button cancel;
    
    private Login parent;
  
    @Override
    public final void setParent(Activity parent) {
        this.parent = (Login) parent;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    @FXML
    private void login() {
        //parent.mediate();
    }
    
    @FXML
    private void cancel() {
        
    }
    
    public void setLoginEnaled(boolean mode) {
        login.setDisable(!mode);
    }
}
