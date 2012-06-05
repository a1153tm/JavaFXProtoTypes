package jp.ac.aiit.apbl6.javafxprototypes.browser;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ForwardButton extends HistoryButton
{
    public ForwardButton(Transitions transitions)
    {
        super(transitions);
        buildView();
    }

    @Override
    protected void doAction()
    {
        transitions.goForward();
    }

    @Override
    protected void buildView()
    {
        Image image = new Image(getClass().getResourceAsStream("nav-forward.png"));
        setGraphic(new ImageView(image));
        setStyle("-fx-content-display: graphic-only;");
    }

    @Override
    protected ObservableList<View> getHistory() {
        return transitions.getForwardHistory();
    }
}
