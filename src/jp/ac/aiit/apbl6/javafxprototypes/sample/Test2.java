package jp.ac.aiit.apbl6.javafxprototypes.sample;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.View;
import jp.ac.aiit.apbl6.javafxprototypes.browser.RequestHyperLink;

public class Test2 extends Activity
{
    @FXML
    VBox vbox;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbox.getChildren().add(new RequestHyperLink("/test1", "back to Test2"));
    }

    @Override
    public void setParent(Activity parent) {
    }
    
    public View postTest(Map<String,String> params)
    {
        SampleEntry entry = new SampleEntry();

        entry.setTextField(params.get("textField"));
        entry.setRadioButton(params.get("radio"));
        entry.setCheckBoxA(params.get("checkBox_A"));
        entry.setCheckBoxB(params.get("checkBox_B"));
        entry.setChoiceBox(params.get("choiceBox"));

        entry.add();
        entry.save();
        return view;
    }
}
