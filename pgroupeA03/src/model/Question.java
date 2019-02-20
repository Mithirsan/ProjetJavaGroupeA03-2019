package model;


import java.util.HashMap;
import java.util.Map;

import exception.AlreadyFourChoicesException;
import exception.AlreadyTrueChoice;


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
		try {
			this.setChoices(choices);
		} catch (AlreadyTrueChoice e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyFourChoicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Question(String author, Round round, String statement) {
		super();
		this.setAuthor(author);
		this.setRound(round);
		this.setStatement(statement);
		choices = new HashMap<String, Boolean>();
	}

	public boolean addChoices(String rep,Boolean value) throws AlreadyFourChoicesException, AlreadyTrueChoice{
		if(choices.size()>NB_CHOICES_MAX) {
			throw new AlreadyFourChoicesException((byte) 0);
		}
		if(value==true) {
			if(choices.containsValue(true)) {
				throw new AlreadyTrueChoice((byte) 0);
			}
			else {
				choices.put(rep, value);
				return true;
			}	
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

	public boolean setChoices(Map <String,Boolean> choices) throws AlreadyTrueChoice, AlreadyFourChoicesException{
		int nbTrue = 0, nbChoice = 0;
		for(Map.Entry<String, Boolean> entry : choices.entrySet()) {
			Boolean v = entry.getValue();
			nbChoice ++;
			if (v == true)
				nbTrue ++;
		}
		if (nbChoice > NB_CHOICES_MAX)
			throw new AlreadyFourChoicesException((byte) 1);
		
		if (nbTrue == 1) {
			this.choices = choices;
			return true;
		}
		throw new AlreadyTrueChoice((byte) 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((statement == null) ? 0 : statement.hashCode());
		return result;
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
