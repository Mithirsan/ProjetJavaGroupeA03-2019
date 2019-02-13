package model;

import java.util.Map;

public class Question {
	private String author;
	private Round round;
	private String statement;
	private Map <String,Boolean> choices;
	private final int NB_CHOICES_MAX=4;
	
	public Question(String author, Round round, String statement, Map<String, Boolean> choices) {
		super();
		this.setAuthor(author);
		this.setRound(round);
		this.setStatement(statement);
		this.setChoices(choices);
	}
	
	public Question(String author, Round round, String statement) {
		super();
		this.setAuthor(author);
		this.setRound(round);
		this.setStatement(statement);
	}

	public boolean addChoices(String rep,Boolean value) {
		if(choices.size()>NB_CHOICES_MAX) {
			return false;
		}
		if(value==true) {
		if(choices.containsValue(true)) {
		}
		return false;
		}
		else {
			choices.put(rep, value);
			return true;
		}
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Map<String, Boolean> getChoices() {
		return choices;
	}

	public boolean setChoices(Map <String,Boolean> choices) {
		int nbTrue = 0, nbChoice = 0;
		for(Map.Entry<String, Boolean> entry : choices.entrySet()) {
			Boolean v = entry.getValue();
			nbChoice ++;
			if (v == true)
				nbTrue ++;
		}
		if (nbChoice > NB_CHOICES_MAX)
			return false;
		
		if (nbTrue == 1) {
			this.choices = choices;
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (statement == null) {
			if (other.statement != null)
				return false;
		} else if (!statement.equals(other.statement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "author=" + author + ", round=" + round + ",\n " + statement + ":\n " + choices + "\n\n";
	}
	
	
	
	
}
