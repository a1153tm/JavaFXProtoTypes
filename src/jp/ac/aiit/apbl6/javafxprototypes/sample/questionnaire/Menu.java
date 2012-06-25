/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.sample.questionnaire;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.View;
import jp.ac.aiit.apbl6.javafxprototypes.browser.RequestButton;
import jp.ac.aiit.apbl6.javafxprototypes.browser.RequestHyperLink;

/**
 *
 * @author ahayama
 */
public class Menu extends Activity {
    
    @FXML
    private ChoiceBox choiceBox1;

    @FXML
    private VBox vBox1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequestHyperLink rh1 = new RequestHyperLink("/questionnaire", 
                LocalizeLabel.getLabel(this.getClass(), "questionnaire"));
        rh1.setFont(new Font(20.0));
        vBox1.getChildren().add(rh1);
        RequestButton rh2 = new RequestButton("/results", RequestButton.POST, 
                LocalizeLabel.getLabel(this.getClass(), "results"));
        rh2.setFont(new Font(14.0));
        vBox1.getChildren().add(rh2);
        
        choiceBox1.setItems(FXCollections.observableArrayList(
            LocalizeLabel.getLabel(this.getClass(), "choice1"), 
            LocalizeLabel.getLabel(this.getClass(), "choice2"), 
            LocalizeLabel.getLabel(this.getClass(), "choice3"))
        );
        choiceBox1.getSelectionModel().selectFirst();        
    }

    @Override
    public void setParent(Activity parent) {
    }
    
    public View show(Map params)
    {
        return view;
    }

}
