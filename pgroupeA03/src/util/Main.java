package util;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;

import model.Deck;
import model.Question;
import model.Round;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hi");
		System.out.println("Select an option :"+"\n"+"1 : Read a json"+"\n"+"2 : Save a json"+"\n"+"3 : Show the deck"+"\n"
				+"4 : Create a question"+"\n"+"5 : Exit");
		Scanner sc = new Scanner (System.in);
		int input = sc.nextInt();
		while((input>4)||(input<0)) {
			System.out.println("ERROR"+"\n"+"Select an option :"+"\n"+"1 : Read a json"+"\n"+"2 : Save a json"+"\n"+"3 : Show the deck"+"\n"
		+"4 : Create a question"+"\n"+"5 : Exit");
			input = sc.nextInt();
		}
		while(input!=5) {
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
				else if (input==4) {
					System.out.println("please enter your name");
					String strAuthor = sc.next();
					System.out.println("please select the round"+"\n"+"1 : FIRST_ROUND"+"\n"+ 
							"2 : SECOND_ROUND"+"\n" + 
							"3 : LAST_ROUND");
					int tmp= sc.nextInt();
					while ((tmp>3)||(tmp<1)) {
						System.out.println("please select the round"+"\n"+"1 : FIRST_ROUND"+"\n"+ 
								"2 : SECOND_ROUND"+"\n" + 
								"3 : LAST_ROUND");
						tmp= sc.nextInt();
					}
					Round tmprd=Round.FIRST_ROUND;
					switch (tmp) {
					case 1:
						tmprd =Round.FIRST_ROUND;
						break;
					case 2 :
						tmprd =Round.SECOND_ROUND;
						break;
					case 3 :
						tmprd =Round.LAST_ROUND;
						break;
					}
					System.out.println("please enter the statement");
					String strStatement = sc.next();
					Question question = new Question(strAuthor,tmprd,strStatement);
					while(question.getChoices().size()<4) {					
						for(int i=1;i<5;i++) {
							System.out.println("please enter the "+i+" answer");
							String strAnswer = sc.next();
							System.out.println("please select the value of the answer"+"\n"+"1: False"+"\n"+"2: True");
							int value = sc.nextInt();
							boolean bool=false;
							while((value>2)||(value<1)) {
								System.out.println("please select the value of the answer"+"\n"+"1: False"+"\n"+"2: True");
								value = sc.nextInt();	
							}
							if (value==1) {
								bool=false;
							}
							else {
								bool=true;
							}
							question.addChoices(strAnswer, bool);
							}
					}
					Deck.getInstance().addQuestion(question);
				}
				System.out.println("Select an option :"+"\n"+"1 : Read a json"+"\n"+"2 : Save a json"+"\n"+"3 : Show the deck"+"\n"
				+"4 : Create a question"+"\n"+"5 : Exit");
				input = sc.nextInt();
		}
		System.out.println("End of programm");
	}
}
