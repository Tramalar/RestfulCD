package error;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EntryNotFoundExceptionMapper implements ExceptionMapper<EntryNotFoundException> {
		@Override
		public Response toResponse(EntryNotFoundException ex) {
			ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),400,"");
			return Response.serverError().status(Status.BAD_REQUEST)
					.entity(errorMessage)
					.build();
		}
}
