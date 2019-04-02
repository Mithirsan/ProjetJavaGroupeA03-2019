package view;

import model.JokerStrategy;

public class AnotherChanceStrategy implements JokerStrategy{
	private GamePlayChoicesGridPane nodeChoices;

	@Override
	public void effectOfJoker() {
		nodeChoices.setAChance(true);
	}

	public void setNodeChoices(GamePlayChoicesGridPane nodeChoices) {
		this.nodeChoices = nodeChoices;
	}		
}