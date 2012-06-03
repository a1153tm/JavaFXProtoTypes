/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprototypes.server;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxprototypes.client.AbstractActivity;
import javafxprototypes.client.Browser;
import javafxprototypes.client.View;

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
        
        Target target = Resolver.getInstance().resolve(url, null);
        String clazz = target.getActivity().getName();
        AbstractActivity activity 
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
