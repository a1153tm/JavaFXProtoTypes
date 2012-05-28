package javafxprototypes.client;

import javafx.scene.layout.StackPane;

public class Body extends StackPane{
    private View view;
    private final Transitions transitions;
    
    public Body(Transitions transitions) {
        this.transitions = transitions;
    };
    

    
    public final void setView(View view) {
        getChildren().clear();
        getChildren().add(view);
    }
}
