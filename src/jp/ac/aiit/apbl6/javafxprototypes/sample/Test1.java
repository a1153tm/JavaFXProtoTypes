package jp.ac.aiit.apbl6.javafxprototypes.sample;

import java.beans.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
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
        Button test = new Button("test");
        buttonHerer.getChildren().add(test);
        test.setOnAction(new javafx.event.EventHandler<ActionEvent>()
            {
                @Override
                public void handle(ActionEvent event)
                {
                    checkToggle();
                }
            });
        
        //radioA.get
    }

    @Override
    public void setParent(Activity parent) {
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
