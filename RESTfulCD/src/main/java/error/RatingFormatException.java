package error;

public class RatingFormatException extends RuntimeException {
	private static final long serialVersionUID = -6672553621676928689L;
	public RatingFormatException(String message){
		super(message);
	} 
}
