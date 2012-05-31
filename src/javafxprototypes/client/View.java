package javafxprototypes.client;

import javafx.scene.Node;

public class View<NodeType extends Node>
{
    private NodeType node;
    
    public View(NodeType node)
    {
        this.node = node;
    }
    
    public Node toNode()
    {
        return node;
    }
}