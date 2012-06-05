package jp.ac.aiit.apbl6.javafxprototypes.activity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Toggle;
import javafx.scene.layout.Pane;

public abstract class Activity implements Initializable
{
    protected Activity parent;

    @FXML
    protected Pane view;

    @Override
    abstract public void initialize(URL url, ResourceBundle rb);

    public final Pane getView()
    {
        return view;
    }

    public final void setView(Pane view)
    {
        this.view = view;
    }
        
    public abstract void setParent(Activity parent);

    // called from ActivityFactory
    // return list of child Activitiy name
    public List<String> listChildren()
    {
        List<String> children = new ArrayList<String>();
        for (Field f : listChildFields())
            children.add(f.getType().getName());
        return children;
    }

    // called from ActivityFactory
    // set child Activity instanct to child Activity field
    public final void setChild(Activity child)
    {
        setChildToField(child);
        setChildToView(child);
    }

    protected List<Field> listChildFields()
    {
        List<Field> fields = new ArrayList<Field>();
        for (Field f : getClass().getDeclaredFields()) {
            for (Annotation an : f.getDeclaredAnnotations())
                if (an instanceof ChildActivity)
                    fields.add(f);
        }
        return fields;
    }

    protected Field getChildField(Class clazz)
    {
        for (Field f : listChildFields()) {
            if (f.getType().equals(clazz))
                return f;
        }
        return null;
    }

    protected void setChildToField(Activity child)
    {
        Field field = getChildField(child.getClass());
        if (field == null)
            //ToDo:Throw custom exception
            System.err.println("field:" + child.getClass().getName() + " not found");
        if (!field.getType().equals(child.getClass()))
            //ToDo:Throw custom exception
            System.err.println("field:" + child.getClass().getName() + " type different");
        try {
            field.setAccessible(true);
            field.set(this, child);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Activity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //protected final void setChildToView(String controllerName, Node node) {
    protected final void setChildToView(Activity child)
    {
        //String nodeId = controllerName.replaceAll("Controller$", "");
        String nodeId = getClassName(child.getClass().getName());
        Pane target = getPane(nodeId);
        if (child == null)
            //ToDo:Throw custom exception
            System.err.println("child node:" + nodeId + " not found.");
        target.getChildren().add(child.getView());
    }

    protected Pane getPane(String nodeId)
    {
        List<Pane> targetPanes = new ArrayList<Pane>();
        findPane(view, nodeId, targetPanes);
        return targetPanes.isEmpty()? null : targetPanes.get(0);
    }
    
    protected static void findPane(Pane pane, String nodeId, List<Pane> targetPanes)
    {
        for (Node node : pane.getChildren()) {
            if (Pane.class.isAssignableFrom(node.getClass())) {
                if (node.getId() != null && node.getId().equals(nodeId))
                    //ToDo:Type check
                    targetPanes.add((Pane)node);
                else
                    findPane((Pane)node, nodeId, targetPanes);
            }
        }
    }

    protected static String getClassName (String className)
    {
        int idx = className.lastIndexOf('.') + 1;
        return className.substring(idx, className.length());
    }
}
