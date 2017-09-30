package auth;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class User implements Principal {
	private String profName;
	private String password;
	private List<String> role=new ArrayList<String>();


	
	public User(String name, String password) {
		this.profName=name;
		this.password=password;
		this.role.add("user");
	}
	public User() {
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addRole(String role) {
		this.role.add(role);
	}
	


	public List<String> getRole() {
		return role;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfName() {
		return profName;
	}
	public void setProfName(String profName) {
		this.profName = profName;
	}

}
