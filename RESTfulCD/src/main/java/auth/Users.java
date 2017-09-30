package auth;

import java.util.ArrayList;
import java.util.List;

public class Users {

	private static List<User> users;
	private static boolean loaded=false;

	public Users() {
		if(!loaded) {
			users=new ArrayList<User>();
			users.add(new User("user","password","user"));
			users.add(new User("admin","password","admin"));
			loaded=true;
		}
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
