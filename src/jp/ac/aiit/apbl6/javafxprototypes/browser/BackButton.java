package jp.ac.aiit.apbl6.javafxprototypes.browser;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackButton extends HistoryButton {

    public BackButton(Transitions transitions)
    {
        super(transitions);
        buildView();
    }

    @Override
    protected void doAction()
    {
        transitions.goBack();
    }

    @Override
    protected void buildView()
    {
        Image image = new Image(getClass().getResourceAsStream("nav-back.png"));
        setGraphic(new ImageView(image));
        setStyle("-fx-content-display: graphic-only;");
    }

    @Override
    protected ObservableList<View> getHistory() {
        return transitions.getBackHistory();
    }
}
