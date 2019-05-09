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
	
	private List<Question> allQuestions;
	
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
		questions = new ArrayList<>(15);
		jokers = new ArrayList<>(4);
		allQuestions = new ArrayList<>();
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
	
	public boolean addAllQuestions(Question q) {
		if(!allQuestions.contains(q)) {
			allQuestions.add(q);
			return true;
		}
		return false;
	}
	
	public boolean addQuestion(Question x){
		if(!questions.contains(x)) {
			questions.add(x);
			return true;
		}
		return false;
	}
	
	public boolean deleteAllDeck(List<Question> x){
		return allQuestions.removeAll(x);
	}
	
	public boolean deleteSingleQuestion(Question x) {
		return allQuestions.remove(x);
	}
	
	public boolean update(Question x) {
		int ind = getInstance().allQuestions.indexOf(x);
		if(ind == -1) {
			return false;
		} 
		allQuestions.set(ind, x);
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
		
		List<Question> round1 = new ArrayList<Question>();
		List<Question> round2 = new ArrayList<Question>();
		List<Question> round3 = new ArrayList<Question>();
		
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
			addAllQuestions(x);
		}
		getInstance().addQuestions(round1, round2, round3);
	}
	
	private void addQuestions(List<Question> round1, List<Question> round2, List<Question> round3) {
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

	public void addQuestions() {
		List<Question> round1 = new ArrayList<Question>();
		List<Question> round2 = new ArrayList<Question>();
		List<Question> round3 = new ArrayList<Question>();
		index = 0;
		getInstance().questions.clear();
		Collections.shuffle(allQuestions);
		for(Question q : allQuestions) {
			switch (q.getRound()) {
				case FIRST_ROUND: 
					round1.add(q);
					break;
				case SECOND_ROUND: 
					round2.add(q);
					break;
				default : 
					round3.add(q);
			}
		}
		getInstance().addQuestions(round1, round2, round3);
	}

	public void loadState(List<Question> state) {
		questions.clear();
		state.forEach(element -> {
			questions.add(element.clone());
		});
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

	public void setJokers(List<Boolean> jokers) {
		this.jokers = jokers;
	}
	
	public void jokerReset(){
		 for(int i =0 ; i <jokers.size();i++) { 
			jokers.set(i, true);
		}
	}

	public List<Question> getAllQuestion(){
		return allQuestions;
	}
}
