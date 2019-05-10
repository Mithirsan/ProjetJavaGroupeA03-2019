package model;

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