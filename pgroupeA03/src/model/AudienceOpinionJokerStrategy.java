package model;

import java.util.ArrayList;
import java.util.List;

/**This class implements JokerStrategy and let us define how AudienceOpinionJokerStrategy work. It contain a list of 4 double 
 * and a list of 4 boolean according the choices of a question
 * 
 * @author GROUP_A03
 *
 */
public class AudienceOpinionJokerStrategy implements JokerStrategy {

	private double[] audienceChoices = {0, 0, 0, 0};
	private List<Boolean> vals = new ArrayList<Boolean>();
	
	/**
	 * This method call useJoker of Deck, get the value of choices of the actual question and run 
	 * a method depending on the question round. 
	 */
	@Override
	public void effectOfJoker() {
		Deck.getInstance().useJoker("AudienceOpinion");
		for (int i = 0; i < 4; i++) {
			audienceChoices[i] = 0;
			vals.add(Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoiceValue(i)); 
		}
		switch (Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getRound()) {
			case FIRST_ROUND : firstRoundQuestions();
				break;
			case SECOND_ROUND : secondRoundQuestion();
				break;
			default : lastRoundQuestion();
		}	
	}
	
	/**This private method is called by effectOfJoker, it set the list double with a pseudo randomiser 
	 * 
	 */
	private void firstRoundQuestions() {
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
	
	/**This private method is called by effectOfJoker, it set the list double with a pseudo randomiser 
	 * 
	 */
	private void secondRoundQuestion() {
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
	
	/**This private method is called by effectOfJoker, it set the list double with a pseudo randomiser 
	 * 
	 */
	private void lastRoundQuestion() {
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

	/**This method return a list 4 of double in % according to audienceChoices
	 * 
	 * @return list 4 of double
	 */
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
