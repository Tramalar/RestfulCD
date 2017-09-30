package auth;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.Priorities;

import error.ErrorMessage;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getAbsolutePath().toString().contains("addUser"))return;
		Users users=new Users();
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		if (authHeader != null && authHeader.size() > 0) {
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			byte[] decodedBytes = Base64.getDecoder().decode(authToken);
			String decodedString=new String (decodedBytes,"UTF-8");
			String[] uap=decodedString.split(":");
			String username = uap[0];
			String password = uap[1];
			User user = users.getUser(username);
			if (user==null) {
				abort("No such user", 401,requestContext);
				return;	
			}
			else if (!users.userExists(username, password)) {
				abort("Wrong password", 401,requestContext);
				return;	
			}
			else {
				requestContext.setSecurityContext(new MyContext(user));
				return;				
			}
		}
		abort ("Not Authorized", 401, requestContext);
	}

	private void abort(String em, int ec,ContainerRequestContext rc) {
		ErrorMessage errorMessage = new ErrorMessage(em, ec,"");
		Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
				.entity(errorMessage)
				.build();
		rc.abortWith(unauthorizedStatus);

	}
}

