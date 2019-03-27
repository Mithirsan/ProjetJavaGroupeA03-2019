package view;

import java.util.ArrayList;
import java.util.List;

import model.Deck;
import model.JokerStrategy;
import model.Round;

public class AudienceOpinionJokerStrategy implements JokerStrategy {

	private double[] audienceChoices = {0, 0, 0, 0};
	private List<Boolean> vals = new ArrayList<Boolean>();
	private int idTrue;
	
	@Override
	public void effectOfJoker(Round round) {
		for (int i = 0; i < 4; i++) {
			audienceChoices[i] = 0;
			vals.add(Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoiceValue(i));
			if(vals.get(i)) {
				idTrue = i;
			} 
		}
		switch (round) {
			case FIRST_ROUND : FirstRoundQuestions();
				break;
			case SECOND_ROUND : SecondRoundQuestion();
				break;
			default : LastRoundQuestion();
		}	
	}
	
	@Override
	public void FirstRoundQuestions() {
		double rand;
		for(int i = 0; i < 100; i++) {
			rand = Math.random() + 0.45;
			for (int j = 0; j < 4; j++) {
				if(j != idTrue) {
					if(rand <= 0.2) {
						audienceChoices[j] ++;
						break;
					} else if(rand <= 0.5) {
						audienceChoices[j] ++;
						break;
					} else if(rand > 0.9) {
						audienceChoices[j] ++;
						break;
					}
				} else {
					if(rand > 0.5 && rand <= 0.9)
						audienceChoices[j] ++;
					break;
				}
			}
		}
	}
	
	@Override
	public void SecondRoundQuestion() {
		
	}
	
	@Override
	public void LastRoundQuestion() {
		
	}

	public double[] getAudienceChoices() {
		int tmp = 0;
		for(int i = 0; i < 4; i++) {
			tmp += audienceChoices[i];
			System.out.println(audienceChoices[i]);
		}
		
		double[] percent = {0, 0, 0, 0};
		for(int i = 0; i < 4; i++) {
			percent[i] = audienceChoices[i]/tmp;
		}
		return audienceChoices;
	}

}
