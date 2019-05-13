package model;

/**
 * 
 * @author GROUP_A03
 *
 */
public class TimeFreezeJokerStrategy implements JokerStrategy {

	/**This method define how the time freeze joker work
	 * 
	 */
	@Override
	public void effectOfJoker() {
		Deck.getInstance().useJoker("TimeFreeze");
	}
}
