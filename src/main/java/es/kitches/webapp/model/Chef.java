package es.kitches.webapp.model;

public class Chef {
	
	private int id;
	private String name;
	
	public Chef(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Farm [id=" + id + ", name=" + name + "]";
	}

}
