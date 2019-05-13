package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * 
 * @author GROUP_A03
 *
 */
public class Serializable {
	
	/**This method allow the program to read a Deck from a file
	 * 
	 * @param fileName name of the file with extension
	 * @return String The file contains in a String
	 */
	public static String readDeck(String fileName) {
		String tmp = "";
		try(Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream(fileName)))){
			while(scan.hasNext()) {
				tmp += scan.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	
	/**This method allow the program to write a instance of a Deck into a Json by receiving the contains of the deck in in a jsonObject
	 * 
	 * @param jsonObject instance of Deck in jsonObject 
	 * @param fileName name of the file in String
	 */
	
	public static void writeDeck(String jsonObject, String fileName) {
		try(PrintWriter json = new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName)))) {
			json.write(jsonObject);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**This method allow the program to read a saved game and return the contain of the file
	 * 
	 * @return A String with the contains of gameSaved
	 */
	public static String readSavedGame() {
		String tmp = "";
		try(Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream("resources/gameSaved.json")))){
			while(scan.hasNext()) {
				tmp += scan.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	
	/**This method allow the program to write a game into the saveGamed file
	 * 
	 * @param jsonObject a json object with the contain of Game
	 */
	
	public static void writeSaveGame(String jsonObject) {
		try(PrintWriter json = new PrintWriter(new BufferedOutputStream(new FileOutputStream("resources/gameSaved.json")))) {
			json.write(jsonObject);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**This method allow the program to read the contain of the statistic file 
	 * 
	 * @return A String with the contains of statsSaved
	 */
	public static String readSavedStats() {
		String tmp = "";
		try(Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream("resources/statsSaved.json")))){
			while(scan.hasNext()) {
				tmp += scan.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}
	/**This method allow the program to write the statistic of the game into the statsSaved file
	 * 
	 * @param jsonObject a json object with the contain of Stats
	 */
	public static void writeSaveStats(String jsonObject) {
		try(PrintWriter json = new PrintWriter(new BufferedOutputStream(new FileOutputStream("resources/statsSaved.json")))) {
			json.write(jsonObject);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
