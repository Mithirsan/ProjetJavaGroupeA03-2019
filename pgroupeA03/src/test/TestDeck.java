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
		assertNotNull(deck.getInstance());
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
		deck.addQuestion(question);
		assertTrue(questions.containsAll(deck.getQuestions()));
	}

	@Test
	public void testSetDeck() {
		deck.setDeck(questions);
		assertNotNull(deck.getQuestions());
	}

	@Test
	public void testAddQuestion() {
		assertTrue(deck.addQuestion(question));
		assertFalse(deck.addQuestion(question));
	}

	@Test
	public void testDeleteAllDeck() {
		assertFalse(deck.deleteAllDeck(questions));
	}

	@Test
	public void testDeleteSingleQuestion() {
		assertFalse(deck.deleteSingleQuestion(question));
	}

	@Test
	public void testUpdate() {
		deck.addQuestion(question);
		Question q = new Question("Mithirsan", Round.SECOND_ROUND, "On which building is Big Ben?");
		deck.update(q);
		assertTrue(questions.contains(q));
	}

	@Test
	public void testToString() {
		assertEquals("Deck : []", deck.toString());
	}

	@Test
	public void testToJSon() {
		assertEquals("{\"questions\":[]}", deck.toJSon());
	}

	@Test
	public void testFromJSon() {
		File file = new File("Test.json");
		Deck fileDeck = deck.fromJSon(Serializable.readDeck(file.getAbsolutePath()));
		assertNotNull(fileDeck);
	}

	@Test
	public void testDownloadData() throws FileNotFoundException, IOException {
		File file = new File("Test.json");
		deck.downloadData(file);
		assertTrue(questions.size() > 0);
	}

	@Test
	public void testLoadDeck() throws FileNotFoundException, IOException{
		File file = new File("Test.json");
		deck.loadDeck(file);
		assertNotNull(questions);
		assertTrue(questions.size() < 0);
	}

	@Test
	public void testAddQuestions() throws FileNotFoundException, IOException{
		File file = new File("Test.json");
		deck.loadDeck(file);
		int nb = questions.size();
		deck.addQuestions();
		assertTrue(nb == questions.size());
	}

	@Test
	public void testLoadState() {
		List<Question> qs = new ArrayList<>(questions);
		deck.loadState(qs);
		assertEquals(qs, questions);
	}

	@Test
	public void testSaveGame() {
		fail("Not yet implemented");
	}

}
