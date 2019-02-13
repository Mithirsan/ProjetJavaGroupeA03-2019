package util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.Deck;


public class Serializable {
	
	public static String readDeck(String fileName) throws FileNotFoundException, IOException {
		String res = "";
		String tmp = "";
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		while((tmp = reader.readLine()) != null) {
			res += tmp;
		}
		reader.close();
		return res;
	}
	
	public static void writeDeck(String fileName) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(Deck.toJSon());
		writer.close();
	}

}
