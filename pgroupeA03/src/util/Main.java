package util;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;

import model.Deck;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hi");
		System.out.println("Select an option :"+"\n"+"1 : Read a json"+"\n"+"2 : Save a json"+"\n"+"3 :Show the deck"+"\n"+"4 :Exit");
		Scanner sc = new Scanner (System.in);
		int input = sc.nextInt();
		while((input>4)||(input<0)) {
			System.out.println("ERROR"+"\n"+"Select an option :"+"\n"+"1 : Read a json"+"\n"+"2 : Save a json"+"\n"+"3 :Show the deck"+"\n"+"4 :Exit");
			input = sc.nextInt();
		}
		while(input!=4) {
				if(input==1) {
					try {
						System.out.println("please , enter a name for the file with .json");
						String str = sc.next();
						Deck.getInstance().loadDeck(new File(str));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if (input ==2) {
					try {
						System.out.println("please , enter a name for the file with .json");
						String str = sc.next();
						Serializable.writeDeck(str);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else if (input ==3) {
				System.out.println(Deck.getInstance());
				}
				System.out.println("Select an option :"+"\n"+"1 : Read a json"+"\n"+"2 : Save a json"+"\n"+"3 :Show the deck"+"\n"+"4 :Exit");
				input = sc.nextInt();
		}
		System.out.println("End of programm");
	}
}
