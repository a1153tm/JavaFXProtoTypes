package jp.ac.aiit.apbl6.javafxprototypes.sample;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.View;
import jp.ac.aiit.apbl6.javafxprototypes.browser.RequestHyperLink;

public class Test2 extends Activity
{
    @FXML
    VBox vbox;
    
    @FXML TableView tableView;
    @FXML TableColumn idCol;
    @FXML TableColumn textFiledCol;
    @FXML TableColumn radioCol;
    @FXML TableColumn checkBoxACol;
    @FXML TableColumn checkBoxBCol;
    @FXML TableColumn choiceBoxCol;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vbox.getChildren().add(new RequestHyperLink("/test1", "back to Test2"));
        
        idCol.setCellValueFactory(new PropertyValueFactory<SampleEntry,Integer>("id"));
        textFiledCol.setCellValueFactory(new PropertyValueFactory<SampleEntry,String>("textField"));
        radioCol.setCellValueFactory(new PropertyValueFactory<SampleEntry,String>("radioButton"));
        checkBoxACol.setCellValueFactory(new PropertyValueFactory<SampleEntry,String>("checkBoxA"));
        checkBoxBCol.setCellValueFactory(new PropertyValueFactory<SampleEntry,String>("checkBoxB"));
        choiceBoxCol.setCellValueFactory(new PropertyValueFactory<SampleEntry,String>("choiceBox"));
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
        
        List<SampleEntry> all = entry.findAll();
        ObservableList<SampleEntry> entries = FXCollections.observableArrayList(all);
        //ObservableList<SampleEntry> entries = FXCollections.observableArrayList();
        //entries.add(entry);
        tableView.setItems(entries);
        return view;
    }
}
