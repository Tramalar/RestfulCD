package error;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RatingFormatExceptionMapper implements ExceptionMapper<RatingFormatException>{
	@Override
	public Response toResponse(RatingFormatException ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),400,"");
		return Response.status(Status.BAD_REQUEST)
				.entity(errorMessage)
				.build();
	}


}