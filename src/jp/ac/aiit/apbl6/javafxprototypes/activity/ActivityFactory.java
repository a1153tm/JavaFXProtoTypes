package jp.ac.aiit.apbl6.javafxprototypes.activity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;

public class ActivityFactory {
    private static ActivityFactory factory = new ActivityFactory();

    private ActivityFactory() {}

    public static ActivityFactory getInstance()
    {
        return factory;
    }

    public Activity createActivity(String className)
    {
        return createActivity(className, null);
    }

    private Activity createActivity(String className, Activity parent)
    {
        Activity activity = loadActivity(className, parent);

        List<String> children = activity.listChildren();
        if (children.isEmpty()) return activity;

        for (String child : children)
        {
            Activity childActivity = createActivity(child, activity);
            activity.setChild(childActivity);
        }
        return activity;
    }

    // ToDo:Change FXMLLoder to singleton
    private Activity loadActivity(String className, Activity parent)
    {
        String path = "../sample/" + getPath(className);
        InputStream fxmlStream = null;
        fxmlStream = getClass().getResourceAsStream(path);

        if (fxmlStream != null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.load(fxmlStream);
                Activity activity = (Activity)loader.getController();
                activity.setView();
                activity.setParent(parent); 
                if (activity == null)
                    System.out.println("controlle is null");
                return activity;
            } catch (IOException e) {
                // ToDo:tread exception (wrap with custom exception)
                e.printStackTrace();
                return null;
            }
        } else {
            try
            {
               return (Activity) Class.forName(className).newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ActivityFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ActivityFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ActivityFactory.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                return null;
            }
        }
    }

    private String getPath(String className)
    {
        int idx = className.lastIndexOf('.') + 1;
        return  className.substring(idx, className.length()) + ".fxml";
    }

}
