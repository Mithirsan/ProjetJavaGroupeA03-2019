package model;

/**This class define how the time freeze joker work
 * 
 * @author GROUP_A03
 *
 */
public class TimeFreezeJokerStrategy implements JokerStrategy {
	@Override
	public void effectOfJoker() {
		Deck.getInstance().useJoker("TimeFreeze");
	}
}
