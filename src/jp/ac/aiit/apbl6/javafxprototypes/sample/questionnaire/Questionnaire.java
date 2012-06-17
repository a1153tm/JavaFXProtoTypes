/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.sample.questionnaire;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
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
public class Questionnaire extends Activity {
    
    @FXML
    private HBox submitBox;

    @FXML
    private Label title;

    @FXML
    private Label coursetitle;

    @FXML
    private TextField course;

    @FXML
    private Label qlabel1;

    @FXML
    private Label qlabel2;

    @FXML
    private Label qlabel3;

    @FXML
    private Label qlabel4;

    @FXML
    private Label qlabel5;

    @FXML
    private Label qlabel6;

    @FXML
    private RadioButton radioButton4;

    @FXML
    private RadioButton radioButton5;

    @FXML
    private RadioButton radioButton6;
    
    @FXML
    private Slider sliderHorizontal;

    @FXML
    private TextField answer4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RequestButton reqbtn = new RequestButton("/results", RequestButton.POST, "送信");
        submitBox.getChildren().add(reqbtn);
        title.setText("講座名：");
        qlabel1.setText("１．本講座を受講した成果はありましたか。");
        qlabel2.setText("２．時間は適切でしたか。");
        qlabel3.setText("３．説明は分かりやすかったですか。");
        qlabel4.setText("４．テキストは理解に役立ちましたか。");
        qlabel5.setText("５．講座全体の感想をお聞かせください。");
        qlabel6.setText("ご協力ありがとうございました。");
        radioButton4.setText("適切");
        radioButton5.setText("長い");
        radioButton6.setText("短い");

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
