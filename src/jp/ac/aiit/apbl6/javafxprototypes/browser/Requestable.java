package jp.ac.aiit.apbl6.javafxprototypes.browser;

public interface Requestable
{
    public String GET = "GET";
    public String POST = "POST";
    
    public void doRequest();
    public String getUrl();
    public String getMethod();   
}
