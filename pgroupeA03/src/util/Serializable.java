package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Serializable {
	
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
	
	public static void writeDeck(String jsonObject, String fileName) {
		try(PrintWriter json = new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName)))) {
			json.write(jsonObject);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
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
	
	
	public static void writeSaveGame(String jsonObject) {
		try(PrintWriter json = new PrintWriter(new BufferedOutputStream(new FileOutputStream("resources/gameSaved.json")))) {
			json.write(jsonObject);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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
	
	public static void writeSaveStats(String jsonObject) {
		try(PrintWriter json = new PrintWriter(new BufferedOutputStream(new FileOutputStream("resources/statsSaved.json")))) {
			json.write(jsonObject);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
