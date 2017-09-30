package auth;

import java.util.ArrayList;
import java.util.List;

public class Users {

	private static List<User> users;
	private static boolean loaded=false;

	public Users() {
		if(!loaded) {
			users=new ArrayList<User>();
			users.add(new User("user","password"));
			User adm= new User("admin","password");
			adm.addRole("admin");
			users.add(adm);
			loaded=true;
		}
	}
	
	public boolean addUser(User user) {
		if(getUser(user.getProfName())!=null)return false;
		users.add(user);
		return true;
	}

	public boolean userExists(String name,String pass) {
		for(User u : users)
			if(u.getProfName().equals(name))
				if(u.getPassword().equals(pass))return true;
		return false;
	}
	public User getUser(String name) {
		for(User u : users)
			if(u.getProfName().equals(name))return u;
		return null;
	}


}
