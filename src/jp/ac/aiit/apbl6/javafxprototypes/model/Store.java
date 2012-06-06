package jp.ac.aiit.apbl6.javafxprototypes.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.arnx.jsonic.JSON;

public class Store<T extends Entity> {
	private ArrayList<T> pojos;
	private T type;
	private File saveFile;
	
	public Store(T pojo) throws IOException {
		pojos = new ArrayList<T>();
		type = pojo;
		saveFile = getFile();
	}
	
	public void load() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(saveFile));
		String line;
		while ((line = reader.readLine()) != null) {
			T pojo = decode(line);
			pojos.add(pojo);
		}
	}
	
	public void save() throws IOException {
		PrintWriter pw = new PrintWriter(saveFile);
		for (Iterator<T> it = pojos.iterator(); it.hasNext();) {
			T elem = it.next();
			String jsonString = encode(elem);
			System.out.println("type:" + elem.getClass().getName());
			System.out.println("jsonString: " + jsonString);
			pw.println(jsonString + ",");
		}
		pw.close();
	}
	
	public synchronized void add(T element) {
		element.setId(getNewId());
		pojos.add(element);
	}
	
	public synchronized void remove(T element) {
		pojos.remove(element);
	}
	
	public List<T> findAll() {
		return pojos;
	}
	
	public T findById(Integer id) {
		for (Iterator<T> it = pojos.iterator(); it.hasNext();) {
			T pojo = it.next();
			if (pojo.getId() == id)
				return pojo;
		}
		return null;
	}
	
	public List<T> find() {
		return null;
	}

	public ArrayList<T> getPojos() {
		return pojos;
	}

	private File getFile() throws IOException {
		String path = getPath();
		saveFile = new File(path);
		if (!saveFile.exists()) {
			saveFile.createNewFile();
		}
		return saveFile;
	}
	
	private String getPath() {
		return "test.json";
	}
	
	private String encode(T pojo) {
		return JSON.encode(pojo);
	}
	
	@SuppressWarnings("unchecked")
	private T decode(String line) {
		return (T) JSON.decode(line.substring(0, line.length() -1), type.getClass());
	}
	
	private int getNewId() {
		if (pojos.isEmpty())
			return 0;
		else
			return getMaxId() + 1;
	}
	
	private int getMaxId() {
		Integer max = 0;
		for (Iterator<T> it = pojos.iterator(); it.hasNext();) {
			T elem = it.next();
			if (elem.getId() > max)
				max = elem.getId();
		}
		return max;
	}
    
}
