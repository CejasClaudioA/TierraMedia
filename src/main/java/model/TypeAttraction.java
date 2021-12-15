package model;

import java.util.HashMap;
import java.util.Map;

public class TypeAttraction {
	private int id;
	private String desc;
	
	private Map<String, String> errors;
	
	public TypeAttraction(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void validate() {
		errors = new HashMap<String, String>();
		if (desc == "") {
			errors.put("desc", "Debe tener caracteres");
		}
	}
	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
}
