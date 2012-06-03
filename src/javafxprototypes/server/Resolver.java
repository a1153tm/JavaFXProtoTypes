/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxprototypes.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ahayama
 */
public class Resolver {
    
    private static final Resolver instance = new Resolver();

    private static final String PATH = "route.txt";
    
    private Map<String, Target> routes = new HashMap<String, Target>();

    public static Resolver getInstance() {
        return instance;
    }
    
    private Resolver() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(PATH));
            String line;
            while ((line = br.readLine()) != null) {
                String[] params = line.split("¥t");
                String[] activity = params[1].split("#");
                Target target = new Target(activity[0], activity[1]);
                this.routes.put(params[0], target);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
     }
    
    public Target resolve(String url, String method) {
        return this.routes.get(url);
    }
    
}
