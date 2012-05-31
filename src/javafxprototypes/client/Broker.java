package javafxprototypes.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class Broker
{
    private Browser browser;

    public Broker(Browser browser)
    {
        this.browser = browser;
    }

    public synchronized void sendRequest(String url, String method)
    {
        Request request = createRequest(url, method);
        Service.getInstance().doService(request);
    }
    public synchronized <T extends Node & Requestable> void sendRequest(T control)
    {
        Request request = createRequest(control);
        Service.getInstance().doService(request);
        showParameters(request.getParameters());
    }

    private Request createRequest(String url, String method)
    {
        Request request = new Request();
        request.setUrl(url);
        request.setMethod(method);
        request.setBrowser(browser);
        return request;
    }

    private <T extends Node & Requestable> Request createRequest(T control)
    {
        Request request = createRequest(control.getUrl(), control.getMethod());
        request.setParameters(collectParameters(control));
        return request;
    }

    private <T extends Node & Requestable> Map collectParameters(T control)
    {
        Map parameters = new HashMap<String, String>();

        Pane parent = null;
        Object o = control.getParent();
        while (o != null && o instanceof Node) {
            if (Pane.class.isAssignableFrom(o.getClass())) {
                parent = (Pane)o;
                break;
            }
            o = ((Node)o).getParent();
        }
        if (parent == null) return parameters;
        
        ObservableList<Node> nodes = parent.getChildren();
        for (Iterator<Node> it = nodes.iterator(); it.hasNext();) {
            Node node = it.next();
            if (TextField.class.isAssignableFrom(node.getClass()))
            {
                setTextField(parameters, (TextField)node);
            }
            else if (PasswordField.class.isAssignableFrom(node.getClass()))
            {
                setPasswordField(parameters, (PasswordField)node);
            }
        }
        return parameters;
    }

    private void setTextField(Map parameters, TextField textField)
    {
        String key = textField.getId();
        if (key == null || key.equals(""))
            return;
        String value = textField.getText();
        System.out.println(value);
        parameters.put(key, value);
    }

    private void setPasswordField(Map parameters, PasswordField passwordField)
    {
        String key = passwordField.getId();
        if (key == null || key.equals(""))
            return;
        String value = passwordField.getText();
        parameters.put(key, value);
    }

    private void setRadioButton(Map parameters, RadioButton radioButton)
    {
        ToggleGroup group = radioButton.getToggleGroup();
        if (group == null)
            return;
        if (!radioButton.isSelected())
            return;
        String key = group.toString();
        if (key == null || key.equals(""))
            return;
        String value = radioButton.getUserData().toString();
        parameters.put(key, value);
    }

    private void setChoiceBox(Map parameters, ChoiceBox choiceBox)
    {
        String key = choiceBox.getId();
        if (key == null || key.equals(""))
            return;
        String value = choiceBox.getSelectionModel().getSelectedItem().toString();
        parameters.put(key, value);
    }

    private void showParameters(Map parameters)
    {
        Set<String> keys = parameters.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext();)
        {
            String key = it.next();
            String value = (String) parameters.get(key);
            System.out.println("key:" + key + ", value:" + value);
        }
    }
}
