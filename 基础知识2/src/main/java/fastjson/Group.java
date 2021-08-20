package fastjson;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private Long id;
	private String name;
	private List<Object> users = new ArrayList<Object>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Object> getUsers() {
		return users;
	}

	public void setUsers(List<Object> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", users=" + users + "]";
	}
	
	

}
