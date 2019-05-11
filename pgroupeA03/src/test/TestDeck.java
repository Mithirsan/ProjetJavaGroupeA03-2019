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
	List<Question> gameQuestion;
	Question question;

	@Before
	public void setUp() throws Exception {
		deck = Deck.getInstance();
		
		Field questionsField = Deck.class.getDeclaredField("questions");
		questionsField.setAccessible(true);	
		questions = (List<Question>) questionsField.get(deck);
		
		questionsField = Deck.class.getDeclaredField("gameQuestion");
		questionsField.setAccessible(true);	
		gameQuestion = (List<Question>) questionsField.get(deck);
		
		
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
		
		gameQuestion = null;
		
		questions = null;
		
		question = null;
	}
	
	@Test
	public void testGetInstance() {
		assertNotNull(deck);
	}

	@Test
	public void testDeck() {
		assertNotNull(new Deck());
	}

	@Test
	public void testGetIndex() {
		assertEquals(0, deck.getIndex());
	}

	@Test
	public void testIncreaseIndex() {
		Deck.increaseIndex();
		assertEquals(1, deck.getIndex());
	}

	@Test
	public void testGetGameQuestions() {
		deck.addGameQuestions(question);
		assertTrue(gameQuestion.containsAll(deck.getGameQuestions()));
	}

	@Test
	public void testSetPlayingDeck() {
		deck.setPlayingDeck(gameQuestion);
		assertNotNull(deck.getGameQuestions());
	}

	@Test
	public void testAddQuestions() {
		assertTrue(deck.addQuestions(question));
		assertFalse(deck.addQuestions(question));
	}
	
	@Test
	public void testAddGameQuestions() {
		assertTrue(deck.addGameQuestions(question));
		assertFalse(deck.addGameQuestions(question));
	}

	@Test
	public void testDeleteQuestionsFromQuestions() {
		questions.add(question);
		assertTrue(deck.deleteQuestionsFromQuestions(questions));
	}

	@Test
	public void testDeleteSingleQuestionFromQuestions() {
		questions.add(question);
		assertTrue(deck.deleteSingleQuestionFromQuestions(question));
	}

	@Test
	public void testUpdateQuestions() {
		questions.add(question);
		Question q = question.clone();
		q.setRound(Round.SECOND_ROUND);
		assertTrue(deck.updateQuestions(q));
	}

	@Test
	public void testToString() {
		assertEquals("Deck : []", deck.toString());
		gameQuestion.add(question);
		assertEquals("Deck : [author=Mithirsan, round=FIRST_ROUND, On which building is Big Ben?:\n" + 
				"{Big Ben is also the building name=false, Tower Clock=false, Elizabeth tower=true, Augustus Tower=false}]", deck.toString());
	}

	@Test
	public void testToJSon() {
		assertEquals("{\"gameQuestion\":[],\"jokers\":[true,true,true,true],\"questions\":[]}", deck.toJSon());
	}

	@Test
	public void testFromJSon() {
		File file = new File("questions.json");
		Deck fileDeck = Deck.fromJSon(Serializable.readDeck(file.getAbsolutePath()));
		assertNotNull(fileDeck);
	}

	@Test
	public void testDownloadData() throws FileNotFoundException, IOException {
		String test = questions.toString();
		File file = new File("questions.json");
		deck.downloadData(file);
		assertFalse(test.equals(questions.toString()));
	}

	@Test
	public void testLoadDeck() throws FileNotFoundException, IOException{
		String test = questions.toString();
		String test2 = gameQuestion.toString();
		File file = new File("questions.json");
		deck.loadDeck(file);
		assertFalse(questions.toString().equals(test));
		assertFalse(test2.equals(gameQuestion.toString()));
	}

	@Test
	public void testRefreshGameQuestion() throws FileNotFoundException, IOException{
		File file = new File("questions.json");
		deck.loadDeck(file);
		int nb = gameQuestion.size();
		String test = gameQuestion.toString();
		deck.refreshGameQuestion();
		assertEquals(nb, gameQuestion.size());
		assertFalse(gameQuestion.toString().equals(test));
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
	public void testUseJoker() {
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
	
	@Test
	public void testGetQuestions() {
		List<Question> test = deck.getQuestions();
		assertEquals(questions, test);
	}
}
