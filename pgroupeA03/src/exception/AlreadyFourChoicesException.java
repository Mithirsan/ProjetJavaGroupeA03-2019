package exception;

public class AlreadyFourChoicesException extends Exception{
	
	public AlreadyFourChoicesException(byte i) {
		
		super(getMsg(i));
	}
	
	private static String getMsg(byte i) {
		if (i == 0) {
			return "The statement have already 4 choices!";
		} else {
			return "You gave more than 4 choices!";
		}
	}
}
