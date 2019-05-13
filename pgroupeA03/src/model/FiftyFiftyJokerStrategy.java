package model;

import java.util.Random;

/**This class implements JokerStrategy and let us define how FiftyFiftyJokerStrategy work. 
 * It contain the id of the true choice
 * 
 * @author GROUP_A03
 *
 */
public class FiftyFiftyJokerStrategy implements JokerStrategy {
	
	private int idTrue;

	/**
	 * This method call useJoker of Deck, get the value of the true choice of the actual question. 
	 */
	@Override
	public void effectOfJoker() {
		Deck.getInstance().useJoker("FiftyFifty");
		idTrue = Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoiceTrue();
	}

	/**This method create a vector of 2 int, find 2 different int between 0 and 3 also different of the true choice.
	 * 
	 * @return
	 */
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
