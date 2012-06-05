package jp.ac.aiit.apbl6.javafxprototypes.browser;

import java.util.Map;

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
