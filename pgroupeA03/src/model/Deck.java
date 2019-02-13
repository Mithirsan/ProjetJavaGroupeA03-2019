package model;

import java.util.List;

public class Deck {
	private List<Question> questions;

	//CRUD
	//Create
	public Deck(List<Question> questions) {
		super();
		this.questions = questions;
	}
	//Read
	public List<Question> getDeck() {
		return this.questions;
	}
	//Update
	public void setDeck(List<Question> questions){
		this.questions=questions;
	}
	//Delete
	public void deleteDeck(){
		this.questions=null;
	}
	
	public String toString() {
		return "Deck : [" + questions + "]";
	}	 
	
}
