package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import util.Serializable;

public class Game {
	private int index;
	private int timerLeft;
	private List<Boolean>jokerUsed;
	private Deck deck;
	
	
	public Game(int index, int timerLeft, List<Boolean> jokerUsed, Deck deck) {
		super();
		this.index = index;
		this.timerLeft = timerLeft;
		this.jokerUsed = jokerUsed;
		this.deck = deck;
	}
	
	public Game() {
		
	}

	@Override
	public String toString() {
		return "Game [index=" + index + ", timerLeft=" + timerLeft + ", JokerUsed=" + jokerUsed + ", deck=" + deck
				+ "]";
	}
	
	public String toJSon() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	public static Game fromJSon(String json) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.fromJson(json, Game.class);
	}
	
	public Game downloadData() throws FileNotFoundException, IOException {
		Game savedGame= fromJSon(Serializable.readSavedGame());
		return savedGame;
	}
	
	public int getIndex() {
		return index;
	}

	public int getTimerLeft() {
		return timerLeft;
	}

	public List<Boolean> getJokerUsed() {
		return jokerUsed;
	}

	public Deck getDeck() {
		return deck;
	}
}
