/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.aiit.apbl6.javafxprototypes.server;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ahayama
 */
public class Resolver {
    
    private static final Resolver instance = new Resolver();
    private static final String PATH = "routes";
    private Map<Combination, Target> routes = new HashMap<Combination, Target>();

    public static Resolver getInstance() {
        return instance;
    }
    
    private Resolver() {
        try {
            //BufferedReader br = new BufferedReader(new FileReader(PATH));
            InputStream is = getClass().getResourceAsStream(PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                String[] params = line.split("\\s+");
                String[] activity = params[2].split("#");
                Target target = new Target(activity[0], activity[1]);
                this.routes.put(new Combination(params[0], params[1]), target);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
     }
    
    public Target resolve(String method, String url)
    {
        Combination cmb = searchComb(method, url);
        return this.routes.get(cmb);
    }

    private Combination searchComb(String method, String url)
    {
        for (Combination cmb : routes.keySet())
        {
            if (cmb.getMethod().equals(method) && cmb.getUrl().equals(url))
                return cmb;
        }
        return null;
    }

    class Combination
    {
        private String method;
        private String url;

        Combination(String method, String url)
        {
            this.method = method;
            this.url = url;
        }
        String getMethod() {return method;}
        String getUrl() {return url;}
    }
}
