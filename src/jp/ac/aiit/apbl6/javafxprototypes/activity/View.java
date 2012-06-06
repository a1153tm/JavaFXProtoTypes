package jp.ac.aiit.apbl6.javafxprototypes.activity;

import javafx.scene.layout.Pane;

public class View<NodeType extends Pane>
{
    private NodeType node;
    
    public View(NodeType node)
    {
        this.node = node;
    }
    
    public Pane toNode()
    {
        return node;
    }
}