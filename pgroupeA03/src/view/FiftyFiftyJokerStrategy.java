package view;

import java.util.Random;

import model.Deck;
import model.JokerStrategy;

public class FiftyFiftyJokerStrategy implements JokerStrategy {
	
	private int idTrue;

	@Override
	public void effectOfJoker() {
		for (int i = 0; i < 4; i++) {
			if(Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoiceValue(i)) {
				idTrue = i;
			} 
		}
	}

	public int[] get2FalseIndex() {
		int[] tmp = {0, 0};		
		int nb = 0;
		int test2 = idTrue;
		int num;
		Random rand = new Random();
		while(true) {
			num = rand.nextInt(3);
			if(num != idTrue && num != test2) {
				tmp[nb] = num;
				test2 = num;
				System.out.println(num);
				nb++;
			}
			if(nb == 2)
				break;
		}
		return tmp;
	}
}
