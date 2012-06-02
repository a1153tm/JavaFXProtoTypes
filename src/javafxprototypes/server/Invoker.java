/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprototypes.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 * @author ahayama
 */
public class Invoker {
    public static View invoke(AbstractActivity activity, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        return (View)method.invoke(activity, method);
    }
    
}
