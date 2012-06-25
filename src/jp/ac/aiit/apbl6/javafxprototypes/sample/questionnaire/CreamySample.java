/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.sample.questionnaire;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jp.ac.aiit.apbl6.javafxprototypes.browser.Browser;

/**
 *
 * @author ahayama
 */
public class CreamySample extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
//        
//        stage.setScene(new Scene(root));
//        stage.show();
        
        stage.setTitle("Questionnaire");

        Browser browser = new Browser();
        stage.setScene(new Scene(browser, 800, 600));
        stage.show();
    }
}
