package jp.ac.aiit.apbl6.javafxprototypes.model;

import java.io.IOException;
import java.util.List;

public abstract class Entity
{
    protected Store store;
    protected Integer id;
    
    public Entity()
    {
        //store = new Store(this);
        store = EntityManager.getInstance().getStore(this);
    }

    protected void load()
    {
        if (!store.loaded())
            store.load();
    }
    
    public final Integer getId()
    {
        return id;
    }
    
    public final void setId(Integer id)
    {
        this.id = id;
    }
    
    @SuppressWarnings("unchecked")
    protected void add()
    {
        load();
        store.add(this);
    }
    
    protected <T> T findById(Integer id)
    {
        load();
        return (T)store.findById(id);
    }

    protected <T> List<T> findAll()
    {
        load();
        return store.findAll();
    }    

    protected final void save()
    {
        load();
        store.save();
    }
}
