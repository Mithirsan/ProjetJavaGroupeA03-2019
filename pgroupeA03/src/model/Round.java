package model;

/**This enumeration contains the rounds of a question
 * 
 * @author GROUP_A03
 */
public enum Round {
	FIRST_ROUND ("FIRST_ROUND"),
	SECOND_ROUND ("SECOND_ROUND"), 
	LAST_ROUND ("LAST_ROUND");
	
	String round;
	
	Round (String round){
		this.round=round;
	}
	
	public String getRound() {
		return round;
	}
}