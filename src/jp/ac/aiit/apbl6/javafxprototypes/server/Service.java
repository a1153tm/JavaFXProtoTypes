/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.server;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;
import jp.ac.aiit.apbl6.javafxprototypes.activity.Activity;
import jp.ac.aiit.apbl6.javafxprototypes.activity.View;
import jp.ac.aiit.apbl6.javafxprototypes.browser.Browser;
import jp.ac.aiit.apbl6.javafxprototypes.browser.Request;

/**
 * 
 * @author ahayama
 */
public class Service {
    
    private static final Service instance = new Service();

    private Service() {
    }
    
    public static Service getInstance() {
        return instance;
    }
    
    public void doService(Request request) {
        String url = request.getUrl();
        String method = request.getMethod();
        Browser browser = request.getBrowser();
        
        Target target = Resolver.getInstance().resolve(method, url);
        String clazz = target.getActivity().getName();
        Activity activity 
                = ActivityManager.getInstance().getActivity(clazz);
        
        View view = null;
        try {
            view = Invoker.invoke(activity, target.getMethod(), request.getParameters());
            
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        browser.goTo(view);        
    }
}
