/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import jp.ac.aiit.apbl6.javafxprototypes.browser.AbstractActivity;
import jp.ac.aiit.apbl6.javafxprototypes.browser.View;

/**
 *
 * @author ahayama
 */
public class Invoker {
    public static View invoke(AbstractActivity activity, Method method, Map<String, String> parameters) 
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        return (View)method.invoke(activity, method, new Object[]{parameters});
    }
    
}
