package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.AlreadyFourChoicesException;
import exception.AlreadyTrueChoiceException;
import model.Question;
import model.Round;

public class TestQuestion {
	
	private Question question;
	private Question questionNC;
	private Map<String, Boolean> choices;
	private int trueIndex;

	@Before
	public void setUp() throws Exception {
		choices = new HashMap<>();
		choices.put("Elizabeth tower", true);
		choices.put("Big Ben is also the building name", false);
		choices.put("Tower Clock", false); 
		choices.put("Augustus Tower", false);
		for (int i = 0; i <= choices.size(); i++){
			if ((boolean) choices.values().toArray()[i]) {
				trueIndex = i;
				break;
			}
		}
		questionNC = new Question("Mithirsan", Round.FIRST_ROUND, "On which building is Big Ben?");
		question = new Question("Mithirsan", Round.FIRST_ROUND, "On which building is Big Ben?", choices);
	}

	@After
	public void tearDown() throws Exception {
		choices = null;
		trueIndex = -1;
		question = null;
		questionNC = null;
	}

	@Test
	public void testHashCode() {
		assertEquals(question.hashCode(), questionNC.hashCode());
	}

	@Test
	public void testQuestionStringRoundStringMapOfStringBoolean() {
		assertNotNull(question);
	}

	@Test
	public void testQuestionStringRoundString() {
		assertNotNull(questionNC);
	}

	@Test
	public void testShuffleChoices() {
		Question q = new Question("Mithirsan", Round.FIRST_ROUND, "On which building is Big Ben?", choices);
		q.shuffleChoices();
		
		List<String> choicesKey = new ArrayList<>(choices.keySet());
		List<String> qChoicesKey = new ArrayList<>(q.getChoices().keySet());
			
		assertEquals(choices.size(), q.getChoices().size());
		for(Map.Entry<String, Boolean> value: choices.entrySet()){
	        Boolean actualValue = q.getChoices().get(value.getKey());
	        assertNotNull(actualValue);
	        assertEquals(value.getValue(), actualValue);
	    }
		assertTrue(qChoicesKey.containsAll(choicesKey));
	}

	@Test
	public void testAddChoice() throws AlreadyFourChoicesException, AlreadyTrueChoiceException{
		assertTrue(questionNC.addChoice("Elizabeth tower", true));
		assertTrue(questionNC.addChoice("Big Ben is also the building name", false));
		assertTrue(questionNC.addChoice("Tower Clock", false));
		assertTrue(questionNC.addChoice("Augustus Tower", false));
	}

	@Test
	public void testGetAuthor() {
		assertEquals("Mithirsan", question.getAuthor());
	}

	@Test
	public void testSetAuthor() {
		question.setAuthor("test");
		assertEquals("test", question.getAuthor());
	}

	@Test
	public void testGetRound() {
		assertEquals(Round.FIRST_ROUND, question.getRound());
	}

	@Test
	public void testSetRound() {
		question.setRound(Round.SECOND_ROUND);
		assertEquals(Round.SECOND_ROUND, question.getRound());
	}

	@Test
	public void testGetStatement() {
		assertEquals("On which building is Big Ben?", question.getStatement()); 
	} 

	@Test
	public void testSetStatement() {
		question.setStatement("test");
		assertEquals("test", question.getStatement());
	}

	@Test
	public void testGetChoices() {
		assertEquals(choices, question.getChoices());
	}

	@Test
	public void testSetChoices() throws AlreadyTrueChoiceException, AlreadyFourChoicesException{
		assertTrue(questionNC.setChoices(choices));
	}

	@Test
	public void testEqualsObject() {
		assertTrue(question.equals(questionNC));
	}

	@Test
	public void testToString() {
		assertEquals("author=Mithirsan, round=FIRST_ROUND, On which building is Big Ben?:\n{Big Ben is also the building name=false, Tower Clock=false, Elizabeth tower=true, Augustus Tower=false}", question.toString());
	}

	@Test
	public void testGetChoice() {
		assertEquals("Elizabeth tower", question.getChoice(trueIndex));
	}

	@Test
	public void testGetChoiceValue() {
		assertEquals(true, question.getChoiceValue(trueIndex));
	}

	@Test
	public void testGetChoiceTrue() {
		assertEquals(trueIndex, question.getChoiceTrue());
	}

	@Test
	public void testClone() {
		assertEquals(question, question.clone());
	}

}
