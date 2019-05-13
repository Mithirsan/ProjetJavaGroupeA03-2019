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

/**This class is the core of our program, it contains the 15 played questions, all available questions, 
 * an index of the actual played question, a list of 4 boolean that represent the use of jokers and an instance of himself. 
 * In fact this class is treated as a singleton on our programme. 
 * 
 * @author GROUP_A03
 */
public class Deck {
	
	private static int index = 0;
	private static final int NBQUESTION = 15;
	private static Deck instance;
	private List<Question> gameQuestion;
	private List<Boolean> jokers;
	private List<Question> questions;
	
	/**This static method allows us to create an instance of the deck that we can easily call.
	 * 
	 * @return the instance of the deck
	 */
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

	/**The constructor of Deck initialize all list and put true value for the jokers 
	 * 
	 */
	public Deck() {
		gameQuestion = new ArrayList<>(15);
		jokers = new ArrayList<>(4);
		questions = new ArrayList<>();
		for(int i = 0; i<4; i++) {
			jokers.add(true);
		}
	}
	
	/**This method return the index of the actual played question. 
	 * 
	 * @return index modulo NBQUESTION
	 */
	public int getIndex() {
		return index%NBQUESTION;
	}

	/**
	 * This method allow the program to increase the value of index
	 */
	public static void increaseIndex() {
		if(index < NBQUESTION) {
			index ++;
		} 
	}
	
	/**
	 * This method return the list of the playable questions. 
	 * @return gameQuestion : list of the playable question
	 */
	public List<Question> getGameQuestions() {
		return gameQuestion;
	}

	/**This method put questions on playable question via addGameQuestions().
	 * 
	 * @param questions
	 */
	public void setPlayingDeck(List<Question> questions){
		for(Question q : questions) {
			this.addGameQuestions(q);
		}
	}
	
	/**This method add a single question into questions. If the question is already on questions,
	 * the question isn't added. 
	 * 
	 * @param q : a single question
	 * @return boolean added(true):not added(false)
	 */
	public boolean addQuestions(Question q) {
		if(!questions.contains(q)) {
			questions.add(q);
			return true;
		}
		return false;
	}
	
	/**This method add a single question into gameQuestion. if there is already 15 question or 
	 * if the question is already on the list, the question isn't added. 
	 * 
	 * @param x : a single question
	 * @return boolean added(true):not added(false)
	 */
	public boolean addGameQuestions(Question x){
		if(gameQuestion.size() == NBQUESTION)
			return false;
		if(!gameQuestion.contains(x)) {
			gameQuestion.add(x);
			return true;
		}
		return false;
	}
	
	/**This method delete a list of question to questions
	 * 
	 * @param x : a list of questions
	 * @return boolean depending on removeAll method form list
	 */
	public boolean deleteQuestionsFromQuestions(List<Question> x){
		return questions.removeAll(x);
	}
	
	/**This method delete a single question to questions
	 * 
	 * @param x : a single question
	 * @return boolean depending on remove method from list
	 */
	public boolean deleteSingleQuestionFromQuestions(Question x) {
		return questions.remove(x);
	}
	
	/**This method can update a single question from questions
	 * 
	 * @param x : a single question
	 * @return true if the question was updated, false if the question wasn't found in questions
	 */
	public boolean updateQuestions(Question x) {
		int ind = getInstance().getQuestions().indexOf(x);
		if(ind == -1) {
			return false;
		} 
		questions.set(ind, x);
		return true;
	}
	
	/**This method return a string with Class name and the list of playable questions. 
	 * 
	 * @return string with Class name and the list of playable questions. 
	 */
	public String toString() {
		return "Deck : " + gameQuestion;
	}

	/**This method transform the instance of deck into a json
	 * 
	 * @return json (string)
	 */
	public String toJSon() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	/**The method transform a json into an instance of deck
	 * 
	 * @param json (string)
	 * @return return the Deck with json value.
	 */
	public static Deck fromJSon(String json) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.fromJson(json, Deck.class);
	}
	
	/**The method allow the program to put data from a json file into questions via addQuestions
	 * 
	 * @param json file
	 * @throws FileNotFoundException
	 * @throws IOException 
	 */
	public void downloadData(File file) throws FileNotFoundException, IOException {
		Deck fileDeck = fromJSon(Serializable.readDeck(file.getAbsolutePath()));
		for(Question x : fileDeck.getQuestions()) {
			getInstance().addQuestions(x);
		}
	}
	
	/**This method allow the program to load a playable deck from a json file using 3 list of question according 
	 * to the Round. it also put all question into questions and call addGameQuestions(lsit R1, list R2, list R3)
	 * 
	 * @param json file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void loadDeck(File file) throws FileNotFoundException, IOException {
		Deck fileDeck = fromJSon(Serializable.readDeck(file.getAbsolutePath()));
		
		List<Question> round1 = new ArrayList<Question>();
		List<Question> round2 = new ArrayList<Question>();
		List<Question> round3 = new ArrayList<Question>();
		getInstance().getQuestions().clear();
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
			addQuestions(x);
		}
		getInstance().addGameQuestions(round1, round2, round3);
	}
	
	/**This method create the played Deck with 3 list of question according to the Round.
	 * 
	 * @param round1 list of FIRST_ROUND questions
	 * @param round2 list of SECOND_ROUND questions
	 * @param round3 list of LAST_ROUND questions and unknown round questions
	 */
	private void addGameQuestions(List<Question> round1, List<Question> round2, List<Question> round3) {
		int nb1 = 0, nb2 = 0, nb3 = 0;
		index = 0;
		getInstance().gameQuestion.clear();
		Collections.shuffle(round1);
		Collections.shuffle(round2);
		Collections.shuffle(round3);
		for(Question q : round1) {
			q.shuffleChoices();
			if(getInstance().addGameQuestions(q)) {
				nb1++;
			}
			if (nb1 == 5) {
				break;
			}
		}
		for(Question q : round2) {
			q.shuffleChoices();
			if(getInstance().addGameQuestions(q)) {
				nb2++;
			}
			if (nb2 == 5) {
				break;
			}
		}
		for(Question q : round3) {
			q.shuffleChoices();
			if(getInstance().addGameQuestions(q)) {
				nb3++;
			}
			if (nb3 == 5) {
				break;
			}
		}
	}

	/**This method create an other playable Deck using 3 list of question according 
	 * to the Round and call addGameQuestions(list R1, list R2, list R3)
	 * 
	 */
	public void refreshGameQuestion() {
		List<Question> round1 = new ArrayList<Question>();
		List<Question> round2 = new ArrayList<Question>();
		List<Question> round3 = new ArrayList<Question>();
		index = 0;
		getInstance().gameQuestion.clear();
		Collections.shuffle(questions);
		for(Question q : questions) {
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
		getInstance().addGameQuestions(round1, round2, round3);
	}

	/**This method set the questions from the CareTMemento
	 * 
	 * @param state : list of questions
	 */
	public void loadState(List<Question> state) {
		questions.clear();
		state.forEach(element -> {
			questions.add(element.clone());
		});
	}

	/**This method set the instance of Deck
	 * 
	 * @param instance : an instance of Deck
	 */
	public static void setInstance(Deck instance) {
		Deck.instance = instance;
	}

	/**This method set false after using a joker on jokers list
	 * 
	 * @param string (name of the joker)
	 */
	public void useJoker(String string) {
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

	/**This method return the joker in position i on the list 
	 * 
	 * @param i number between 0 and 3
	 * @return boolean 
	 */
	public boolean getJoker(int i) {
		return jokers.get(i);
	}

	/**This method return the list of jokers
	 * 
	 * @return list of boolean
	 */
	public List<Boolean> getJokers() {
		return jokers;
	}

	/**This method allow the program to set the boolean list of joker
	 * 
	 * @param jokers
	 */
	public void setJokers(List<Boolean> jokers) {
		this.jokers = jokers;
	}
	
	/**This method set the value of all item on jokers list to true
	 * 
	 */
	public void jokerReset(){
		 for(int i =0 ; i <jokers.size();i++) { 
			jokers.set(i, true);
		}
	}

	/**This method return the list of questions
	 * 
	 * @return questions (all available question) 
	 */
	public List<Question> getQuestions(){
		return questions;
	}
}
