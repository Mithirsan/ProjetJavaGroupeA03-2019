package exception;

public class alreadyFourChoicesException extends Exception{
	
	public alreadyFourChoicesException() {
		super("The statement have already 4 choices!");
	}
}
