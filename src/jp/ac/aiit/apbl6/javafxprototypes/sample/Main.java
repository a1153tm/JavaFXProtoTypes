package jp.ac.aiit.apbl6.javafxprototypes.sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.ActivityFactory;

public class Main extends Application {
    
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        ActivityFactory factory = new ActivityFactory();
        Activity rootActivity = factory.createActivity("Login.fxml");
        
        Group rootView = new Group();
        rootView.getChildren().add(rootActivity.getView());
        stage.setScene(new Scene(rootView));
        stage.show();
    }
    
}
