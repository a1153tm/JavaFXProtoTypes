package jp.ac.aiit.apbl6.javafxprototypes.model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntityManager
{
    public static EntityManager manager = new EntityManager();
    private Map<Class, Store> stores = new HashMap<Class, Store>();

    private EntityManager() {}

    public static EntityManager getInstance()
    {
        return manager;
    }

    public <T extends Entity> Store getStore(T obj)
    {
        Class clazz = obj.getClass();
        Store store = stores.get(clazz);
        if (store == null)
        {
            store = new Store(obj);
        }
        return store;
    }
}
