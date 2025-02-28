package model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	List<Seller>sellers=new ArrayList<>();

	public Department () {
	}
	public Department(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Seller> getSellers() {
		return sellers;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", sellers=" + sellers + "]";
	}

}
