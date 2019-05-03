package model;

import java.util.ArrayList;
import java.util.List;

public class AudienceOpinionJokerStrategy implements JokerStrategy {

	private double[] audienceChoices = {0, 0, 0, 0};
	private List<Boolean> vals = new ArrayList<Boolean>();
	
	@Override
	public void effectOfJoker() {
		Deck.getInstance().jokerUse("AudienceOpinion");
		for (int i = 0; i < 4; i++) {
			audienceChoices[i] = 0;
			vals.add(Deck.getInstance().getQuestions().get(Deck.getInstance().getIndex()).getChoiceValue(i)); 
		}
		switch (Deck.getInstance().getQuestions().get(Deck.getInstance().getIndex()).getRound()) {
			case FIRST_ROUND : FirstRoundQuestions();
				break;
			case SECOND_ROUND : SecondRoundQuestion();
				break;
			default : LastRoundQuestion();
		}	
	}
	
	public void FirstRoundQuestions() {
		double rand;
		for(int i = 0; i < 1000; i++) {
			rand = Math.random() + 0.45;
			if(vals.get(0)) {
				if(rand<=0.46) {
					audienceChoices[1]++;
				}else if(rand<=0.60) {
					audienceChoices[2]++;
				}else if(rand<=0.69) {
					audienceChoices[3]++;
				}else {
					audienceChoices[0]++;
				}
			}else if(vals.get(1)) {
				if(rand<=0.46) {
					audienceChoices[0]++;
				}else if(rand<=0.60) {
					audienceChoices[3]++;
				}else if(rand<=0.69) {
					audienceChoices[2]++;
				}else {
					audienceChoices[1]++;
				}
			}else if(vals.get(2)) {
				if(rand<=0.46) {
					audienceChoices[0]++;
				}else if(rand<=0.60) {
					audienceChoices[3]++;
				}else if(rand<=0.69) {
					audienceChoices[1]++;
				}else {
					audienceChoices[2]++;
				}
			}else{
				if(rand<=0.46) {
					audienceChoices[2]++;
				}else if(rand<=0.60) {
					audienceChoices[0]++;
				}else if(rand<=0.69) {
					audienceChoices[1]++;
				}else{
					audienceChoices[3]++;
				}
			}
		}
	}
	
	public void SecondRoundQuestion() {
		double rand;
		for(int i = 0; i < 1000; i++) {
			rand = Math.random() + 0.20;
			if(vals.get(0)) {
				if(rand<=0.21) {
					audienceChoices[1]++;
				}else if(rand<=0.40) {
					audienceChoices[2]++;
				}else if(rand<=0.60) {
					audienceChoices[3]++;
				}else {
					audienceChoices[0]++;
				}
			}else if(vals.get(1)) {
				if(rand<=0.21) {
					audienceChoices[0]++;
				}else if(rand<=0.40) {
					audienceChoices[3]++;
				}else if(rand<=0.60) {
					audienceChoices[2]++;
				}else {
					audienceChoices[1]++;
				}
			}else if(vals.get(2)) {
				if(rand<=0.21) {
					audienceChoices[0]++;
				}else if(rand<=0.40) {
					audienceChoices[3]++;
				}else if(rand<=0.60) {
					audienceChoices[1]++;
				}else {
					audienceChoices[2]++;
				}
			}else{
				if(rand<=0.21) {
					audienceChoices[2]++;
				}else if(rand<=0.40) {
					audienceChoices[0]++;
				}else if(rand<=0.60) {
					audienceChoices[1]++;
				}else{
					audienceChoices[3]++;
				}
			}
		}
	}
	
	public void LastRoundQuestion() {
		double rand;
		for(int i = 0; i < 1000; i++) {
			rand = Math.random();
			if(vals.get(0)) {
				if(rand<=0.2) {
					audienceChoices[1]++;
				}else if(rand<=0.5) {
					audienceChoices[2]++;
				}else if(rand>0.8) {
					audienceChoices[3]++;
				}else {
					audienceChoices[0]++;
				}
			}else if(vals.get(1)) {
				if(rand<=0.2) {
					audienceChoices[0]++;
				}else if(rand<=0.5) {
					audienceChoices[3]++;
				}else if(rand>0.8) {
					audienceChoices[2]++;
				}else {
					audienceChoices[1]++;
				}
			}else if(vals.get(2)) {
				if(rand<=0.2) {
					audienceChoices[0]++;
				}else if(rand<=0.5) {
					audienceChoices[3]++;
				}else if(rand>0.8) {
					audienceChoices[1]++;
				}else {
					audienceChoices[2]++;
				}
			}else{
				if(rand<=0.2) {
					audienceChoices[2]++;
				}else if(rand<=0.5) {
					audienceChoices[0]++;
				}else if(rand>0.8) {
					audienceChoices[1]++;
				}else{
					audienceChoices[3]++;
				}
			}
		}
	}

	public double[] getAudienceChoices() {
		int tmp = 0;
		for(int i = 0; i < 4; i++) {
			tmp += audienceChoices[i];
		}
		
		double[] percent = {0, 0, 0, 0};
		for(int i = 0; i < 4; i++) {
			percent[i] = audienceChoices[i]/tmp * 100;
		}
		return percent;
	}

}
