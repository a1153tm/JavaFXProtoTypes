/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprototypes.server;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ahayama
 */
public class ActivityManager {
    
    private Map<String, AbstractActivity> activities = new HashMap<String, AbstractActivity>();
    
    private ActivityManager() {
    }
    
    public static ActivityManager getInstance() {
        return ActivityManagerHolder.INSTANCE;
    }
    
    private static class ActivityManagerHolder {

        private static final ActivityManager INSTANCE = new ActivityManager();
    }
    
    public AbstractActivity getActivity(String clazz) {
        return activities.get(clazz);
    }
}
