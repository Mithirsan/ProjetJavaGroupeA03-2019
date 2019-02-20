package exception;

public class AlreadyFourChoicesException extends Exception{
	
	public AlreadyFourChoicesException() {
		super("The statement have already 4 choices!");
	}
}
