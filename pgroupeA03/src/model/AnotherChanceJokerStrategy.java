package model;

/**This class implements JokerStrategy and let us define how AnotherChanceJokerStrategy work.
 * 
 * @author GROUP_A03
 */
public class AnotherChanceJokerStrategy implements JokerStrategy{

	/**This method call useJoker of Deck. 
	 * 
	 */
	@Override
	public void effectOfJoker() {
		Deck.getInstance().useJoker("AnotherChance");
	}		
}