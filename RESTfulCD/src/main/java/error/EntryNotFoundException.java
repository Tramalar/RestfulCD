package error;

public class EntryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntryNotFoundException(String message){
		super(message);
	} 
}
