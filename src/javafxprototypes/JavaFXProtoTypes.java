/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprototypes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafxprototypes.client.Browser;
import javafxprototypes.client.Header;

public class JavaFXProtoTypes extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("proto type");

        //Header browser = new Header(null, null);
        Browser browser = new Browser();
        primaryStage.setScene(new Scene(browser, 1024, 768));
        primaryStage.show();
    }
}
