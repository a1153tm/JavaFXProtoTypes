package javafxprototypes.client;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class Browser extends StackPane {
    private Transitions transitions;
    private Header header;
    private Body body;
    private Fotter fotter;
    
    public Browser() {
        this(new Transitions(), null);
    }
    
    public Browser(String title) {
        this(new Transitions(), title);
    }
    
    public Browser(Transitions transitions, String title) {
        this.transitions = transitions;
        buildView(transitions, title);
    }
    
    private void buildView(Transitions transitions, String title) {
        header = new Header(transitions, title);
        body = new Body(transitions);
        fotter = new Fotter();
        
        BorderPane rootPane = new BorderPane();
        rootPane.setTop(header);
        //rootPane.setCenter(body);
        //rootPane.setBottom(fotter);
        getChildren().add(rootPane);
    }
}
