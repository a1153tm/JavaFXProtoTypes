package jp.ac.aiit.apbl6.javafxprototypes.sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.ActivityFactory;

public class Test extends Application {
    
    public static void main(String[] args) {
        Application.launch(Test.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        ActivityFactory factory = ActivityFactory.getInstance();
        //Activity rootActivity = factory.createActivity("jp.ac.aiit.apbl6.javafxprototypes.sample.Login");
        
        //Activity rootActivity = new Test1Activity();
        Activity rootActivity = factory.createActivity(Test2.class.getName());
        Group rootView = new Group();
        rootView.getChildren().add(rootActivity.getView().toNode());
        stage.setScene(new Scene(rootView));
        stage.show();
    }
    
}
