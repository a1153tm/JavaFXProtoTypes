package javafxprototypes.client;

import java.util.HashMap;
import java.util.Map;

public class Service {
    private static Service service = new Service();
    private Map<String, View> routes = new HashMap<String, View>();

    private Service()
    {
    }

    public static Service getInstance()
    {
        return service;
    } 

    public void addView(String url, View view)
    {
        routes.put(url, view);
    }

    public void doService(Request req)
    {
        String url = req.getUrl();
        Browser browser = req.getBrowser();
        View view = routes.get(url);
        browser.goTo(view);
    }
}
