package model;

public class AnotherChanceStrategy implements JokerStrategy{

	@Override
	public void effectOfJoker() {
		Deck.getInstance().jokerUse("AnotherChance");
	}		
}