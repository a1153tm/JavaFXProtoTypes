/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.sample.questionnaire;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.View;
import jp.ac.aiit.apbl6.javafxprototypes.browser.RequestButton;

/**
 *
 * @author ahayama
 */
public class Questionnaire extends Activity {
    
    @FXML
    private HBox submitBox;

    @FXML
    private Label coursetitle;

    @FXML
    private TextField course;

    @FXML
    private Slider sliderHorizontal;

    @FXML
    private TextField answer4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequestButton reqbtn = new RequestButton("/results", RequestButton.POST, 
                LocalizeLabel.getLabel(this.getClass(), "results"));
        submitBox.getChildren().add(reqbtn);

        sliderHorizontal.valueProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> ov,
            Number old_val, Number new_val) {
                answer4.setText(String.format("%.2f", new_val));
        }
        });

    }    
    public View show(Map<String,String> params)
    {
        coursetitle.setText(params.get("choiceBox1"));
        course.setText(params.get("choiceBox1"));
        return view;
    }

    @Override
    public void setParent(Activity parent) {
    }
    
}
