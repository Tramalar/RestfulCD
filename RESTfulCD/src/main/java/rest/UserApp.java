package rest;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import auth.*;
import error.ErrorMessage;

@Path("/addUser")
public class UserApp {
	@Context  private UriInfo info;

	private Users users=new Users();
	@POST
	@PermitAll
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(User user){
		user.addRole("user");

		if(users.addUser(user))
			return "User "+user.getProfName()+" created"; 
		return "User "+user.getProfName()+" already exists";
	}
}
