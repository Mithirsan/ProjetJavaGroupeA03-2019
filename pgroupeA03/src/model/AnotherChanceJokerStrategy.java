package model;

public class AnotherChanceJokerStrategy implements JokerStrategy{

	@Override
	public void effectOfJoker() {
		Deck.getInstance().useJoker("AnotherChance");
	}		
}