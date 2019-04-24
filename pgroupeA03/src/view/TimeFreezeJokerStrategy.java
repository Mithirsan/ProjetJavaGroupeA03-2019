package view;

import model.JokerStrategy;

public class TimeFreezeJokerStrategy implements JokerStrategy {

	GamePlayTimerHBox n;
	
	@Override
	public void effectOfJoker() {
		n.freezeTimer();
	}
	
	public void setNode(GamePlayTimerHBox n) {
		this.n = n;
	}

}
