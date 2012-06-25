/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.sample.questionnaire;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

/**
 *
 * @author ahayama
 */
public class LocalizeLabel {
    
    private Properties prop;
    private String ctrlName;
    
    private static final LocalizeLabel instance = new LocalizeLabel();
    
    public static LocalizeLabel getInstance() {
        return instance;
    }
    
    public LocalizeLabel()
    {
        prop = new Properties();
        try {  
            InputStream is = this.getClass().getResourceAsStream(
                    "/jp/ac/aiit/apbl6/javafxprototypes/sample/questionnaire/label_ja.properties");
            prop.load(is);  
        } catch (Exception e) {  
        }  

    }
    
    public static void localizeLabel(Class clazz, Object o)
    {
        getInstance().ctrlName = clazz.getSimpleName();
        if (o != null && o instanceof Node) {
            if (Pane.class.isAssignableFrom(o.getClass()) && ((Pane)o).getId() != null)
            {
                getInstance().searchLabel((Pane)o);
            }
        }
    }
        
    private void searchLabel(Pane pane)
    {
        ObservableList<Node> nodes = pane.getChildren();
        for (Iterator<Node> it = nodes.iterator(); it.hasNext();) {
            Node node = it.next();
            if (Pane.class.isAssignableFrom(node.getClass()))
            {
                searchLabel((Pane)node);
            }
            else
            {
                String name = node.getId();
                if (prop != null)
                {
                    name = prop.getProperty(ctrlName + "." + name);
                }
                
                if (Label.class.isAssignableFrom(node.getClass()))
                {
                    ((Label)node).setText(name);
                }
                else if (TextField.class.isAssignableFrom(node.getClass()))
                {
                    ((TextField)node).setText(name);
                }
                else if (RadioButton.class.isAssignableFrom(node.getClass()))
                {
                    ((RadioButton)node).setText(name);
                }
                else if (CheckBox.class.isAssignableFrom(node.getClass()))
                {
                    ((CheckBox)node).setText(name);
                }
            }
        }
    }

    public static String getLabel(Class clazz, String key)
    {
        if (getInstance().prop != null)
        {
            return getInstance().prop.getProperty(clazz.getSimpleName() + "." + key);
        }
        return key;
    }
        
 }
