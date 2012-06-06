package jp.ac.aiit.apbl6.javafxprototypes.model;

import java.io.IOException;
import java.util.List;

public abstract class Entity
{
	protected Store store;
	
	protected Integer id;
	
	protected abstract void setStore();
	
	public final Integer getId() {
		return id;
	}
	
	public final void setId(Integer id) {
		this.id = id;
	}
	
	protected final void load() throws IOException {
		store.load();
	}
	
	protected final void save() throws IOException {
		store.save();
	}
	
	@SuppressWarnings("unchecked")
	protected void add(Entity element) {
		store.add(element);
	}
	
	@SuppressWarnings("rawtypes")
	protected List findAll() {
		return store.findAll();
	}    
}
