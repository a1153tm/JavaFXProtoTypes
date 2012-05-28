package javafxprototypes.client;

public class BackButton extends HistoryButton {

    public BackButton(Transitions transitions)
    {
        super(transitions);
    }

    @Override
    protected void changed(Transitions newTransitions)
    {
        if (newTransitions.isLastOfHistory())
        {
        }
    }

    @Override
    protected void doAction()
    {
        transitions.get().goBack();
    }

    @Override
    protected void setView()
    {
        setStyle("-fx-content-display: graphic-only;");
        setStyle("-fx-graphic: url(\"nav-back.png\")");
    }
}
