package model;

import java.util.Random;

public class FiftyFiftyJokerStrategy implements JokerStrategy {
	
	private int idTrue;

	@Override
	public void effectOfJoker() {
		Deck.getInstance().jokerUse("FiftyFifty");
		idTrue = Deck.getInstance().getQuestions().get(Deck.getInstance().getIndex()).getChoiceTrue();
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
				nb++;
			}
			if(nb == 2)
				break;
		}
		return tmp;
	}
}
