/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.server;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.ac.aiit.apbl6.javafxprototypes.browser.AbstractActivity;

/**
 *
 * @author ahayama
 */
public class Target {
    private Class<AbstractActivity> activity;
    private Method method;
    
    public Target(String activity, String method)
    {
        try {
            this.activity = (Class<AbstractActivity>) Class.forName(activity);
            this.method = this.activity.getMethod(method, (Class<AbstractActivity>)null);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Class getActivity()
    {
        return this.activity;
    }
    
    public Method getMethod()
    {
        return this.method;
    }
    
}
