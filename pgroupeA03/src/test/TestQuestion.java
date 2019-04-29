package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Question;
import model.Round;

class TestQuestion {

	private static Question question;
	private static Map<String, Boolean> choices;
	private static int trueIndex;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
		
		question = new Question("Mithirsan", Round.FIRST_ROUND, "On which building is Big Ben?", choices);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		question = null;
		choices = null;
		trueIndex = 0;
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHashCode() {
		Question q = new Question("Mithirsan", Round.FIRST_ROUND, "On which building is Big Ben?", choices);
		
		assertEquals(question.hashCode(), q.hashCode());
	}

	@Test
	void testQuestionStringRoundStringMapOfStringBoolean() {
		
		fail("Not yet implemented");
	}

	@Test
	void testQuestionStringRoundString() {
		fail("Not yet implemented");
	}

	@Test
	void testShuffleChoices() {
		fail("Not yet implemented");
	}

	@Test
	void testAddChoices() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAuthor() {
		assertEquals("Mithirsan", question.getAuthor());
	}

	@Test
	void testSetAuthor() {
		fail("Not yet implemented");
	}

	@Test
	void testGetRound() {
		assertEquals(Round.FIRST_ROUND, question.getRound());
	}

	@Test
	void testSetRound() {
		fail("Not yet implemented");
	}

	@Test
	void testGetStatement() {
		assertEquals("On which building is Big Ben?", question.getStatement());
	}

	@Test
	void testSetStatement() {
		fail("Not yet implemented");
	}

	@Test
	void testGetChoices() {
		assertEquals(choices, question.getChoices());
	}

	@Test
	void testSetChoices() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsObject() {
		assertEquals(false, question.equals("Not equals"));
	}

	@Test
	void testToString() {
		assertEquals("author=Mithirsan, round=FIRST_ROUND, On which building is Big Ben?:\n{Big Ben is also the building name=false, Tower Clock=false, Elizabeth tower=true, Augustus Tower=false}", question.toString());
	}

	@Test
	void testGetChoice() {
		assertEquals("Elizabeth tower", question.getChoice(trueIndex));
	}

	@Test
	void testGetChoiceValue() {
		assertEquals(true, question.getChoiceValue(trueIndex));
	}

	@Test
	void testGetChoiceTrue() {
		assertEquals(trueIndex, question.getChoiceTrue());
	}

	@Test
	void testClone() {
		assertEquals(question, question.clone());
	}

}
