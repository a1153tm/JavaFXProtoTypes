/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.sample.questionnaire;

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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.View;
import jp.ac.aiit.apbl6.javafxprototypes.browser.RequestHyperLink;
import jp.ac.aiit.apbl6.javafxprototypes.sample.SampleEntry;

/**
 *
 * @author ahayama
 */
public class Results extends Activity {
    
    @FXML
    private Label title;

    @FXML
    private VBox vbox;
    
    @FXML
    private TableView tableView;
    
    @FXML
    private TableColumn noCol;
    
    @FXML
    private TableColumn courseCol;
    
    @FXML
    private TableColumn answer1Col;
    
    @FXML
    private TableColumn answer2Col;
    
    @FXML
    private TableColumn answer3Col;
    
    @FXML
    private TableColumn answer4Col;
    
    @FXML
    private TableColumn answer5Col;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        title.setText("集計結果");
        vbox.getChildren().add(new RequestHyperLink("/menu", "メニューに戻る"));
        
        noCol.setCellValueFactory(new PropertyValueFactory<ResultsEntry,Integer>("id"));
        courseCol.setCellValueFactory(new PropertyValueFactory<ResultsEntry,String>("course"));
        answer1Col.setCellValueFactory(new PropertyValueFactory<ResultsEntry,String>("answer1"));
        answer2Col.setCellValueFactory(new PropertyValueFactory<ResultsEntry,String>("answer2"));
        answer3Col.setCellValueFactory(new PropertyValueFactory<ResultsEntry,String>("answer3"));
        answer4Col.setCellValueFactory(new PropertyValueFactory<ResultsEntry,String>("answer4"));
        answer5Col.setCellValueFactory(new PropertyValueFactory<ResultsEntry,String>("answer5"));
    }    
    public View show(Map<String,String> params)
    {
        ResultsEntry entry = new ResultsEntry();

        entry.setCourse(params.get("course"));
        entry.setAnswer1(params.get("answer1"));
        entry.setAnswer2(params.get("answer2"));
        entry.setAnswer3(params.get("answer3"));
        entry.setAnswer4(params.get("answer4"));
        entry.setAnswer5(params.get("answer5"));

        entry.add();
        entry.save();
        
        List<SampleEntry> all = entry.findAll();
        ObservableList<SampleEntry> entries = FXCollections.observableArrayList(all);
        tableView.setItems(entries);
        return view;
    }

    @Override
    public void setParent(Activity parent) {
    }
    
}
