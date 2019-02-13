package model;

import java.util.Map;

public class Question {
	private String author;
	private Round round;
	private String statement;
	private Map <String,Boolean> choices;
	
	public Question(String author, Round round, String statement, Map<String, Boolean> choices) {
		super();
		this.setAuthor(author);
		this.setRound(round);
		this.setStatement(statement);
		this.setChoices(choices);
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

	public void setChoices(Map<String, Boolean> choices) {
		this.choices = choices;
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
		return "author=" + author + ", round=" + round + ",\n " + statement + ":\n " + choices;
	}
	
	
	
	
}
