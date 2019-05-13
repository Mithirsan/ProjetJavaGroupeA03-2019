package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import util.Serializable;

/**This class allow program the save a game with the actual index, the time, the list of ' jokers and a deck
 * 
 * @author GROUP_A03
 *
 */
public class Game {
	private int index;
	private int timerLeft;
	private List<Boolean>jokerUsed;
	private Deck deck;
	
	/**The constructor of game with all params
	 * 
	 * @param index between 0 and 14
	 * @param timerLeft between 1 and 45
	 * @param jokerUsed (list of 4 jokers)
	 * @param deck deck
	 */
	public Game(int index, int timerLeft, List<Boolean> jokerUsed, Deck deck) {
		super();
		this.index = index;
		this.timerLeft = timerLeft;
		this.jokerUsed = jokerUsed;
		this.deck = deck;
	}
	
	//the constructor of game without params
	public Game() {
		
	}

	@Override
	public String toString() {
		return "Game [index=" + index + ", timerLeft=" + timerLeft + ", JokerUsed=" + jokerUsed + ", deck=" + deck + "]";
	}
	
	/**This method transform the instance of game into a json
	 * 
	 * @return json (string)
	 */
	public String toJSon() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	/**The method transform a json into an instance of Game
	 * 
	 * @param json (string)
	 * @return return the Game with json value.
	 */
	public static Game fromJSon(String json) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		return gson.fromJson(json, Game.class);
	}
	
	/**The method allow the program to put data from a json file
	 * 
	 * @param json file
	 * @throws FileNotFoundException
	 * @throws IOException 
	 */
	public Game downloadData() throws FileNotFoundException, IOException {
		Game savedGame= fromJSon(Serializable.readSavedGame());
		return savedGame;
	}
	
	/**This method return the index
	 * 
	 * @return index between 0 and 14
	 */
	public int getIndex() {
		return index;
	}

	/**This method return the time left in the timer
	 * 
	 * @return timerLeft between 0 and 45
	 */
	public int getTimerLeft() {
		return timerLeft;
	}

	/**This method return the list of 4 joker
	 * 
	 * @return jokerUsed list of 4 boolean
	 */
	public List<Boolean> getJokerUsed() {
		return jokerUsed;
	}

	/**This method return an instance of Deck
	 * 
	 * @return deck
	 */
	public Deck getDeck() {
		return deck;
	}
}
