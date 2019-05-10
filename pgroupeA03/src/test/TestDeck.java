package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Deck;
import model.Question;
import model.Round;
import util.Serializable;

public class TestDeck {
	
	Deck deck;
	List<Question> questions;
	Question question;

	@Before
	public void setUp() throws Exception {
		deck = Deck.getInstance();
		
		Field questionsField = Deck.class.getDeclaredField("questions");
		questionsField.setAccessible(true);	
		questions = (List<Question>) questionsField.get(deck);
		
		Map<String, Boolean> choices = new HashMap<>();
		choices.put("Elizabeth tower", true);
		choices.put("Big Ben is also the building name", false);
		choices.put("Tower Clock", false);
		choices.put("Augustus Tower", false);	
		question = new Question("Mithirsan", Round.FIRST_ROUND, "On which building is Big Ben?", choices);
	}

	@After
	public void tearDown() throws Exception {
		Field instance = Deck.class.getDeclaredField("instance");
		instance.setAccessible(true);
		instance.set(null, null);
		
		questions = null;
		
		question = null;
	}
	
	@Test
	public void testGetInstance() {
		assertNotNull(deck);
	}

	@Test
	public void testDeck() {
		assertNotNull(deck);
	}

	@Test
	public void testGetIndex() {
		assertEquals(0, deck.getIndex());
	}

	@Test
	public void testIncreaseIndex() {
		deck.increaseIndex();
		assertEquals(1, deck.getIndex());
	}

	@Test
	public void testGetQuestions() {
		deck.addGameQuestions(question);
		assertTrue(questions.containsAll(deck.getGameQuestions()));
	}

	@Test
	public void testSetDeck() {
		deck.setPlayingDeck(questions);
		assertNotNull(deck.getGameQuestions());
	}

	@Test
	public void testAddQuestion() {
		assertTrue(deck.addGameQuestions(question));
		assertFalse(deck.addGameQuestions(question));
	}

	@Test
	public void testDeleteAllDeck() {
		assertFalse(deck.deleteQuestionsFromQuestions(questions));
	}

	@Test
	public void testDeleteSingleQuestion() {
		assertFalse(deck.deleteSingleQuestionFromQuestions(question));
	}

	@Test
	public void testUpdate() {
		deck.addGameQuestions(question);
		Question q = new Question("Mithirsan", Round.SECOND_ROUND, "On which building is Big Ben?");
		deck.updateQuestions(q);
		assertTrue(questions.contains(q));
	}

	@Test
	public void testToString() {
		assertEquals("Deck : []", deck.toString());
	}

	@Test
	public void testToJSon() {
		System.out.println(deck.toJSon());
		assertEquals("{\"questions\":[],\"jokers\":[true,true,true,true]}", deck.toJSon());
	}

	@Test
	public void testFromJSon() {
		File file = new File("Test.json");
		Deck fileDeck = Deck.fromJSon(Serializable.readDeck(file.getAbsolutePath()));
		assertNotNull(fileDeck);
	}

	@Test
	public void testDownloadData() throws FileNotFoundException, IOException {
		String test = questions.toString();
		File file = new File("Test.json");
		deck.downloadData(file);
		assertNotNull(questions);
		assertFalse(questions.toString().equals(test));
	}

	@Test
	public void testLoadDeck() throws FileNotFoundException, IOException{
		String test = questions.toString();
		File file = new File("Test.json");
		deck.loadDeck(file);
		assertNotNull(questions);
		assertFalse(questions.toString().equals(test));
	}

	@Test
	public void testAddQuestions() throws FileNotFoundException, IOException{
		File file = new File("Test.json");
		deck.loadDeck(file);
		int nb = questions.size();
		String test = questions.toString();
		deck.refreshGameQuestion();
		assertEquals(nb, questions.size());
		assertFalse(questions.toString().equals(test));
	}

	@Test
	public void testLoadState() {
		List<Question> qs = new ArrayList<>(questions);
		deck.loadState(qs);
		assertEquals(qs, questions);
	}
	
	@Test
	public void testSetInstance() {
		Deck d = new Deck();
		Deck.setInstance(d);
		assertNotNull(Deck.getInstance());
		assertEquals(d, Deck.getInstance());
	}
	
	@Test
	public void testJokerUse() {
		deck.useJoker("FiftyFifty");
		assertEquals(false, deck.getJoker(1));
	}
	
	@Test
	public void testGetJoker() {
		assertEquals(true, deck.getJoker(3));
	}
	
	@Test
	public void testGetJokers() {
		assertNotNull(deck.getJokers());
	}
	
	@Test
	public void testSetJokers() {
		List<Boolean> test = new ArrayList<>();
		test.add(true);
		deck.setJokers(test);
		assertNotNull(deck.getJokers());
	}
	
	@Test
	public void testJokerReset() {
		List<Boolean> test = deck.getJokers();
		deck.useJoker("FiftyFifty");
		deck.jokerReset();
		assertEquals(test, deck.getJokers());
	}
}
