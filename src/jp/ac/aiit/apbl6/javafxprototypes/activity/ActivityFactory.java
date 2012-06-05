package jp.ac.aiit.apbl6.javafxprototypes.activity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.fxml.FXMLLoader;

public class ActivityFactory {
    public Activity createActivity(String path)
    {
        return createActivity(path, null);
    }

    private Activity createActivity(String path, Activity parent)
    {
        Activity activity = loadActivity(path);
        activity.setParent(parent);    

        List<String> children = activity.listChildren();
        if (children.isEmpty()) return activity;

        for (String child : children)
        {
            Activity childActivity = createActivity(getPath(child), activity);
            activity.setChild(childActivity);
        }
        return activity;
    }

    private String getPath(String className)
    {
        int idx = className.lastIndexOf('.') + 1;
        return  className.substring(idx, className.length()) + ".fxml";
    }

    // ToDo:Change FXMLLoder to singleton
    private Activity loadActivity(String path)
    {
        path = "../sample/" + path;
        InputStream fxmlStream = null;
        try {
            fxmlStream = getClass().getResourceAsStream(path);
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            if (loader.getController() == null)
                System.out.println("controlle is null");
            return (Activity)loader.getController();
        } catch (IOException e) {
            // ToDo:tread exception (wrap with custom exception)
            e.printStackTrace();
            return null;
        }
    }
}
