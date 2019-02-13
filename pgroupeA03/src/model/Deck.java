package model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
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
		return "Deck : [" + questions + "]";
	}	
}
