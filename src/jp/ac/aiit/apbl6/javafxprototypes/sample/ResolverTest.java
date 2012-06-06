package jp.ac.aiit.apbl6.javafxprototypes.sample;

import jp.ac.aiit.apbl6.javafxprototypes.server.Resolver;
import jp.ac.aiit.apbl6.javafxprototypes.server.Target;

public class ResolverTest {
    public static void main(String[] args)
    {
        Resolver rsv = Resolver.getInstance();
        Target tgt = rsv.resolve("GET", "/test1");
        System.out.println(tgt.getClass().getName());
        System.out.println(tgt.getMethod().getName());
    }
}
