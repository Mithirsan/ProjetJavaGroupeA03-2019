package model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import util.Serializable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private static int index = 0;
	private static final int NBQUESTION = 15;
	private static Deck instance;
	private List<Question> questions;
	private List<Boolean> jokers;
	
	private static List<Question> round1 = new ArrayList<Question>();
	private static List<Question> round2 = new ArrayList<Question>();
	private static List<Question> round3 = new ArrayList<Question>();
	
	public static Deck getInstance() {
		if(instance == null) {
			synchronized (Deck.class) {
				if(instance == null) {
					instance = new Deck();
				}
			}
		}
		return instance;
	}

	public Deck() {
		questions = new ArrayList<>();
		jokers = new ArrayList<>(4);
		for(int i = 0; i<4; i++) {
			jokers.add(true);
		}
	}
	
	public int getIndex() {
		return index%NBQUESTION;
	}

	public static void increaseIndex() {
		if(index < NBQUESTION) {
			index ++;
		} 
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setDeck(List<Question> questions){
		for(Question q : questions) {
			this.addQuestion(q);
		}
	}
	
	public boolean addQuestion(Question x){
		if(!questions.contains(x)) {
			questions.add(x);
			return true;
		}
		return false;
	}
	
	public boolean deleteAllDeck(List<Question> x){
		return questions.removeAll(x);
	}
	
	public boolean deleteSingleQuestion(Question x) {
		return questions.remove(x);
	}
	
	public boolean update(Question x) {
		int ind = getInstance().questions.indexOf(x);
		if(ind == -1) {
			return false;
		} 
		questions.set(ind, x);
		return true;
	}
	
	public String toString() {
		return "Deck : " + questions;
	}

	public String toJSon() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	public static Deck fromJSon(String json) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.fromJson(json, Deck.class);
	}
	
	public void downloadData(File file) throws FileNotFoundException, IOException {
		Deck fileDeck = fromJSon(Serializable.readDeck(file.getAbsolutePath()));
		for(Question x : fileDeck.getQuestions()) {
			getInstance().addQuestion(x);
		}
	}
	
	public void loadDeck(File file) throws FileNotFoundException, IOException {
		Deck fileDeck = fromJSon(Serializable.readDeck(file.getAbsolutePath()));
		getInstance().round1.clear();
		getInstance().round2.clear();
		getInstance().round3.clear();
		
		for(Question x : fileDeck.getQuestions()) {
			switch (x.getRound()) {
				case FIRST_ROUND: 
					round1.add(x);
					break;
				case SECOND_ROUND: 
					round2.add(x);
					break;
				default : 
					round3.add(x);
			}
		}
		getInstance().addQuestions();
	}
	
	public void addQuestions() {
		int nb1 = 0, nb2 = 0, nb3 = 0;
		index = 0;
		getInstance().questions.clear();
		Collections.shuffle(round1);
		Collections.shuffle(round2);
		Collections.shuffle(round3);
		for(Question q : round1) {
			q.shuffleChoices();
			if(getInstance().addQuestion(q)) {
				nb1++;
			}
			if (nb1 == 5) {
				break;
			}
		}
		for(Question q : round2) {
			q.shuffleChoices();
			if(getInstance().addQuestion(q)) {
				nb2++;
			}
			if (nb2 == 5) {
				break;
			}
		}
		for(Question q : round3) {
			q.shuffleChoices();
			if(getInstance().addQuestion(q)) {
				nb3++;
			}
			if (nb3 == 5) {
				break;
			}
		}
	}

	public void loadState(List<Question> state) {
		questions.clear();
		state.forEach(element -> {
			questions.add(element.clone());
		});
	}

	public static void saveGame() {
		// TODO Auto-generated method stub
		
	}

	public static void setInstance(Deck instance) {
		Deck.instance = instance;
	}

	public void jokerUse(String string) {
		switch (string) {
		case "AudienceOpinion": 
			jokers.set(0, false);
			break;
		case "FiftyFifty": 
			jokers.set(1, false);
			break;
		case "TimeFreeze": 
			jokers.set(2, false);
			break;
		case "AnotherChance" : 
			jokers.set(3, false);
			break;
		default : ;
		}
		
	}

	public boolean getJoker(int i) {
		return jokers.get(i);
	}

	public List<Boolean> getJokers() {
		return jokers;
	}
}
