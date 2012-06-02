/*
 * stub : javafxprototypes.client パッケージのもの
 */
package javafxprototypes.server;

import javafx.scene.Node;

/**
 *
 * @author ahayama
 */
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