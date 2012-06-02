/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprototypes.server;

import java.lang.reflect.Method;
import java.util.Map;

/**
 *
 * @author ahayama
 */
public class Request {
    private String url;
    private String method;
    private Map<String, String> parameters;
    private Browser browser;
    
    public String getUrl() {return url;}
    public String getMethod() {return method;}
    public Map getParameters() {return parameters;}
    public Browser getBrowser() {return browser;}
    public void setUrl(String url) {this.url = url;}
    public void setMethod(String method) {this.method = method;}
    public void setParameters(Map parameters) {this.parameters = parameters;}
    public void setBrowser(Browser browser) {this.browser = browser;}
}
