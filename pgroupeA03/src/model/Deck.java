package model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import util.Serializable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Deck {
	
	private static int index = 0;
	
	private static Deck instance;
	private List<Question> questions;
	
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
	}
	
	public static int getIndex() {
		return index;
	}

	public static void increaseIndex() {
		if(index < 15) {
			index ++;
		}
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

	public void setDeck(List<Question> questions){
		this.questions=questions;
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
		getInstance().questions.clear();
		for(Question x : fileDeck.getQuestions()) {
			x.shuffleChoices();
			getInstance().addQuestion(x);
		}
	}
}
