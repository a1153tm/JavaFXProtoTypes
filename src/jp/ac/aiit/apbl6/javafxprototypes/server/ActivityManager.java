/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.server;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.ActivityFactory;


/**
 *
 * @author ahayama
 */
public class ActivityManager {
    
    private static final ActivityManager instance = new ActivityManager();
    
    private Map<String, Activity> activities = new HashMap<String, Activity>();
    
    private ActivityManager() {
    }
    
    public static ActivityManager getInstance() {
        return instance;
    }
    
    public Activity getActivity(String clazz) {
        Activity activity = activities.get(clazz);
        if (activity == null) {
            /*
            try {
                try {
                    activity = (Activity) Class.forName(clazz).newInstance();
                    activities.put(clazz, activity);
                } catch (InstantiationException ex) {
                    Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            */
            activity = ActivityFactory.getInstance().createActivity(clazz);
        }
        return activity;
    }
}
