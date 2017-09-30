package auth;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

public class MyContext implements SecurityContext{
	private User user;
	public MyContext(User u) {
		this.user=u;
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}

	@Override
	public Principal getUserPrincipal() {
		return user;
	}

	@Override
	public boolean isSecure() {
		return false;
	}

	@Override
	public boolean isUserInRole(String role) {
		return user.getRole().contains(role);
	}

}
