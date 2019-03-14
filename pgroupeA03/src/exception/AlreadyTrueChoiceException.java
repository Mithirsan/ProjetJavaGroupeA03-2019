package exception;

public class AlreadyTrueChoiceException extends Exception {
	
	public AlreadyTrueChoiceException(byte i) {
		super(getMsg(i));
	}
	
	private static String getMsg(byte i) {
		if (i == 0) {
			return "The statement have already a true choice!";
		} else {
			return "You gave too many True on choices";
		}
	}
}
