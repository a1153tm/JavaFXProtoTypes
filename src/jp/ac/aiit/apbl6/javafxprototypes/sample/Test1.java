package jp.ac.aiit.apbl6.javafxprototypes.sample;

import java.beans.EventHandler;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.View;
import jp.ac.aiit.apbl6.javafxprototypes.browser.RequestButton;
import jp.ac.aiit.apbl6.javafxprototypes.browser.RequestHyperLink;

public class Test1 extends Activity
{
    @FXML
    private TilePane buttonHerer;
    
    @FXML
    private RadioButton radioA;
    
    @FXML
    private ChoiceBox choiceBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequestButton rbtn = new RequestButton("/test2", RequestButton.POST, "Go to Test2");
        buttonHerer.getChildren().add(rbtn);
    }

    @Override
    public void setParent(Activity parent) {
    }
    
    public View getTest(Map params)
    {
        return view;
    }
    
    private void checkToggle()
    {
        //ToggleGroup tg = radioA.getToggleGroup();
        //System.out.println(tg.toString());
        if (choiceBox == null)
            System.out.println("choiceBox is null");
        else
        {
            System.out.println("choiceBox is not null");
            System.out.println(choiceBox.getSelectionModel().getSelectedItem());        
        }
    }
}
