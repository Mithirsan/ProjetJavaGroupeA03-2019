package model;

public class TimeFreezeJokerStrategy implements JokerStrategy {

	@Override
	public void effectOfJoker() {
		Deck.getInstance().useJoker("TimeFreeze");
	}
}
