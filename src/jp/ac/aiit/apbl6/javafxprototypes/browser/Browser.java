package jp.ac.aiit.apbl6.javafxprototypes.browser;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class Browser extends StackPane {
    private Transitions transitions;
    private Header header;
    private Body body;
    private Fotter fotter;
    private Broker broker;
    
    public Browser()
    {
        this(new Transitions(), null);
    }
    
    public Browser(String title)
    {
        this(new Transitions(), title);
    }
    
    public Browser(Transitions transitions, String title)
    {
        this.transitions = transitions;
        this.broker = new Broker(this);
        buildView(transitions, title);
    }
    
    private void buildView(Transitions transitions, String title)
    {
        header = new Header(this, title);
        body = new Body(transitions);
        fotter = new Fotter();
        
        BorderPane rootPane = new BorderPane();
        rootPane.setTop(header);
        rootPane.setCenter(body);
        rootPane.setBottom(fotter);
        getChildren().add(rootPane);
    }
    
    public Broker getBroker()
    {
        return broker;
    }
    
    public void goTo(View view)
    {
        transitions.goTo(view);
    }
    
    public Transitions getTransitions()
    {
        return transitions;
    }
}
