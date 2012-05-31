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
import javafxprototypes.client.Service;

public class JavaFXProtoTypes extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("proto type");

        Browser browser = new Browser();
        primaryStage.setScene(new Scene(browser, 1024, 768));
        primaryStage.show();

        
        Test1Activity test1 = new Test1Activity();
        Service.getInstance().addView("/test1", test1.getView());
        Test2Activity test2 = new Test2Activity();
        Service.getInstance().addView("/test2", test2.getView());
        Test3Activity test3 = new Test3Activity();
        Service.getInstance().addView("/test3", test3.getView());        
        browser.getTransitions().setCurrentView(test1.getView());
 
        
    }
}
