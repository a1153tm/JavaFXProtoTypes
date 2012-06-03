/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprototypes.server;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxprototypes.client.AbstractActivity;

/**
 *
 * @author ahayama
 */
public class ActivityManager {
    
    private static final ActivityManager instance = new ActivityManager();
    
    private Map<String, AbstractActivity> activities = new HashMap<String, AbstractActivity>();
    
    private ActivityManager() {
    }
    
    public static ActivityManager getInstance() {
        return instance;
    }
    
    public AbstractActivity getActivity(String clazz) {
        AbstractActivity activity = activities.get(clazz);
        if (activity == null) {
            try {
                try {
                    activity = (AbstractActivity) Class.forName(clazz).newInstance();
                    activities.put(clazz, activity);
                } catch (InstantiationException ex) {
                    Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ActivityManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return activity;
    }
}
