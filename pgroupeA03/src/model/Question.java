package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import exception.AlreadyFourChoicesException;
import exception.AlreadyTrueChoiceException;

/**This class allow the program to create Question which is used on many of other Class on our program. 
 * it define by an author (string), a round (Round), a statement (String), 4 choices (1 true, 3 false)
 * 
 * @author GROUP_A03
 *
 */
public class Question {
	private String author;
	private Round round;
	private String statement;
	private Map <String,Boolean> choices;
	private final int NB_CHOICES_MAX=4;
	
	/**The constructor using all field
	 * 
	 * @param author (String)
	 * @param round (Round)
	 * @param statement (String)
	 * @param choices (Map)
	 */
	public Question(String author, Round round, String statement, Map<String, Boolean> choices) {
		super();
		this.setAuthor(author);
		this.setRound(round);
		this.setStatement(statement);
		try {
			this.setChoices(choices);
		} catch (AlreadyTrueChoiceException e) {
			e.printStackTrace();
		} catch (AlreadyFourChoicesException e) {
			e.printStackTrace();
		}
	}
	
	/**The constructor using all field except choices
	 * 
	 * @param author (String)
	 * @param round (Round)
	 * @param statement (String)
	 */
	public Question(String author, Round round, String statement) {
		super();
		this.setAuthor(author);
		this.setRound(round);
		this.setStatement(statement);
		choices = new HashMap<String, Boolean>();
	}
	
	/**This method shuffle the order of choices
	 * 
	 */
	public void shuffleChoices() {
		List<String> list = new ArrayList<>(choices.keySet());
	    Collections.shuffle(list);

	    Map<String, Boolean> shuffleMap = new LinkedHashMap<>();
	    list.forEach(e->shuffleMap.put(e, choices.get(e)));
	    choices = shuffleMap;
	}

	/**This method add a choice into choices
	 * 
	 * @param rep the key of the map (String)
	 * @param value the value of the map (boolean)
	 * @return boolean according to choice was put (true) or not (false)
	 * @throws AlreadyFourChoicesException (when there is already 4 choices on the map)
	 * @throws AlreadyTrueChoiceException (when there is already a true choice on the map)
	 */
	public boolean addChoice(String rep,Boolean value) throws AlreadyFourChoicesException, AlreadyTrueChoiceException{
		if(choices.size()>NB_CHOICES_MAX) {
			throw new AlreadyFourChoicesException((byte) 0);
		}
		if(value==true) {
			if(choices.containsValue(true)) {
				throw new AlreadyTrueChoiceException((byte) 0);
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

	/**This method return the author
	 * 
	 * @return author (String)
	 */
	public String getAuthor() {
		return author;
	}

	/**This method set the value of author
	 * 
	 * @param author (String)
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**This method return the Round 
	 * 
	 * @return rounf (Round)
	 */
	public Round getRound() {
		return round;
	}
	
	/**This method set the value of round
	 * 
	 * @param round (Round)
	 */
	public void setRound(Round round) {
		this.round = round;
	}

	/**This method return the statement
	 * 
	 * @return statement (String)
	 */
	public String getStatement() {
		return statement;
	}

	/**This method set the value of statement
	 * 
	 * @param statement
	 */
	public void setStatement(String statement) {
		this.statement = statement;
	}

	/**This method return the map of choices
	 * 
	 * @return
	 */
	public Map<String, Boolean> getChoices() {
		return choices;
	}

	/**This method set the map of choices
	 * 
	 * @param choices (map)
	 * @return boolean true if set, false if not
	 * @throws AlreadyTrueChoiceException the map contain more than 4 choices
	 * @throws AlreadyFourChoicesException the map count more than 1 true choice
	 */
	public boolean setChoices(Map <String,Boolean> choices) throws AlreadyTrueChoiceException, AlreadyFourChoicesException{
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
		throw new AlreadyTrueChoiceException((byte) 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((statement == null) ? 0 : statement.hashCode());
		return result;
	}

	/**This equals method check on statement
	 * 
	 * @return true if same, false if not
	 */
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
		return "author=" + author + ", round=" + round + ", " + statement + ":\n" + choices;
	}

	/**This method return the key of the choice i
	 * 
	 * @param i int between 0 and 3
	 * @return key (String)
	 */
	public String getChoice(int i) {
		return (String) choices.keySet().toArray()[i];
	}
	
	/**This method return the value of the choice i
	 * 
	 * @param i between 0 and 3
	 * @return value (boolean)
	 */
	public boolean getChoiceValue(int i) {
		return (boolean) choices.values().toArray()[i];
	}
	
	/**Thsi method return the index of the true chocie
	 * 
	 * @return int between -1 and 3
	 */
	public int getChoiceTrue() {
		for (int i =0 ; i<= choices.size();i++){
			if ((boolean) choices.values().toArray()[i]) {
				return i;
			}
		}
		return -1;
	}
	
	/**This method return a clone of the question
	 * 
	 * @return question (clone)
	 */
	public Question clone() {
		return new Question(getAuthor(), getRound(), getStatement(), getChoices());
	}
}
