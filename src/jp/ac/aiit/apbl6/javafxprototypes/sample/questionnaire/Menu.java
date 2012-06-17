/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.sample.questionnaire;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
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

    @FXML
    private Label title;

    @FXML
    private Label cource;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequestHyperLink rh1 = new RequestHyperLink("/questionnaire", "アンケートに答える");
        rh1.setFont(new Font(20.0));
        vBox1.getChildren().add(rh1);
        RequestButton rh2 = new RequestButton("/results", RequestButton.POST, "集計結果を見る");
        rh2.setFont(new Font(14.0));
        vBox1.getChildren().add(rh2);
        
        title.setText("講座アンケート");
        cource.setText("講座名：");
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
