package util;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import model.Deck;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hi");
		try {
			Deck.getInstance().loadDeck(new File("Test.json"));		
			System.out.println(Deck.getInstance());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
