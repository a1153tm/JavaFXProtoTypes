package jp.ac.aiit.apbl6.javafxprototypes.browser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import jp.ac.aiit.apbl6.javafxprototypes.server.Service;

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
        showParameters(request.getParameters());
        return request;
    }

    private <T extends Node & Requestable> Map collectParameters(T control)
    {
        Map parameters = new HashMap<String, String>();

        Pane form = null;
        Object o = control.getParent();
        while (o != null && o instanceof Node) {
            if (Pane.class.isAssignableFrom(o.getClass()) &&
                ((Pane)o).getId() != null && ((Pane)o).getId().equals("form"))
            {
                form = (Pane)o;
                break;
            }
            System.out.println(((Node)o).getId());
            o = ((Node)o).getParent();
        }
        if (form == null)
        {
            System.out.println("form is null");
            return parameters;
        }
        searchParameters(form, parameters);
        return parameters;
    }
        
    private void searchParameters(Pane pane, Map parameters)
    {
        ObservableList<Node> nodes = pane.getChildren();
        for (Iterator<Node> it = nodes.iterator(); it.hasNext();) {
            Node node = it.next();
            if (Pane.class.isAssignableFrom(node.getClass()))
            {
                searchParameters((Pane)node, parameters);
            }
            else if (TextField.class.isAssignableFrom(node.getClass()))
            {
                setTextField(parameters, (TextField)node);
            }
            else if (PasswordField.class.isAssignableFrom(node.getClass()))
            {
                setPasswordField(parameters, (PasswordField)node);
            }
            else if (RadioButton.class.isAssignableFrom(node.getClass()))
            {
                setRadioButton(parameters, (RadioButton)node);
            }
            else if (CheckBox.class.isAssignableFrom(node.getClass()))
            {
                setCheckBox(parameters, (CheckBox)node);
            }
            else if (ChoiceBox.class.isAssignableFrom(node.getClass()))
            {
                setChoiceBox(parameters, (ChoiceBox)node);
            }
        }
    }

    private void setTextField(Map parameters, TextField textField)
    {
        String key = textField.getId();
        if (key == null || key.equals(""))
            return;
        String value = textField.getText();
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
        if (!radioButton.isSelected())
            return;
        String key = radioButton.getId();
        if (key == null || key.equals(""))
            return;
        //String value = radioButton.getUserData().toString();
        String value = radioButton.getText();
        parameters.put(key, value);
    }

    private void setCheckBox(Map parameters, CheckBox checkBox)
    {
        if (!checkBox.isSelected())
            return;
        String key = checkBox.getId();
        if (key == null || key.equals(""))
            return;
        //String value = radioButton.getUserData().toString();
        String value = checkBox.getText();
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
        System.out.println("----- send parameters ------");
        Set<String> keys = parameters.keySet();
        for (Iterator<String> it = keys.iterator(); it.hasNext();)
        {
            String key = it.next();
            String value = (String) parameters.get(key);
            System.out.println("key:" + key + ", value:" + value);
        }
    }
}
