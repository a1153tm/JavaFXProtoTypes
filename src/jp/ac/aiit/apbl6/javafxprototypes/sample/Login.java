package jp.ac.aiit.apbl6.javafxprototypes.sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.ChildActivity;

public class Login extends Activity {
    
    @FXML
    private AnchorPane view;
            
    @ChildActivity
    private UserType userType;
    
    @ChildActivity
    private InputBoxes inputBoxes;

    @ChildActivity
    private CommandButtons commandButtons;
    
    @Override
    public final void setParent(Activity parent) {}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void mediate(UserType ctrl) {
       if (ctrl.userSelectted()) {
           inputBoxes.setTtextFieldEnabled(true);
           inputBoxes.setPasswordField(true);
           commandButtons.setLoginEnaled(false);
       } else if (ctrl.guestSelectted()) {
           inputBoxes.setTtextFieldEnabled(false);
           inputBoxes.setPasswordField(false);
           commandButtons.setLoginEnaled(true);
       }
    }
    
    public void mediate(InputBoxes ctrl) {
        
    }
}
