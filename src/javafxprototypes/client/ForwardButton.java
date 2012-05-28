package javafxprototypes.client;

import javafx.scene.image.Image;

public class ForwardButton extends HistoryButton
{
    public ForwardButton(Transitions transitions)
    {
        super(transitions);
        setView();
    }

    @Override
    protected void changed(Transitions newTransitions)
    {
        if (newTransitions.isTopOfHistory())
        {
        }
    }

    @Override
    protected void doAction()
    {
        transitions.get().goForward();
    }

    @Override
    protected void setView()
    {
        Image imageDecline = new Image(getClass().getResourceAsStream("nav-forward.png"));
        setStyle("-fx-content-display: graphic-only;");
    }
}
