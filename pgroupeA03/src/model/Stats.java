package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import util.Serializable;

/**This class is used to define the game statistic
 * 
 * @author GROUP_A03
 *
 */
public class Stats {

		private int partyPlayed =0;
		private int partyWin =0;
		private int totalDays =0;
		private int timePlayed =0;
		
		/**Constructor
		 * 
		 */
		public Stats() { 
			
		}
		/**This method transform a instance of Stats into a json
		 * 
		 * @return a string with the contain of the instance Stats
		 */
		public String toJSon() {
			Gson gson = new Gson();
			return gson.toJson(this);
		}
		
		/**This method allow the program to read an instance of Stats from a json
		 * 
		 * @param json Contains of the file convert into a string 
		 * @return An instance of Stats
		 */
		public static Stats fromJSon(String json) {
			Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			return gson.fromJson(json, Stats.class);
		}
		/**This method create an instance of Stats with the data receive from the method fromJson()
		 * 
		 * @return An instance of Stats
		 * @throws FileNotFoundException
		 * @throws IOException
		 */
		public Stats downloadData() throws FileNotFoundException, IOException {
			Stats statistic = fromJSon(Serializable.readSavedStats());
			return statistic;
		}
		/**This method is use to get the contains of Stats into a String
		 * 
		 * @return a string with all fields of the Stats
		 */
		@Override
		public String toString() {
			return "Stats [partyPlayed=" + partyPlayed + ", partyWin=" + partyWin + ", totalDays=" + totalDays
					+ ", timePlayed=" + timePlayed + "]";
		}
		
		/**This method is use to get the number of party played
		 * 
		 * @return int
		 */
		public int getPartyPlayed() {
			return partyPlayed;
		}
		
		/**This method is use to get the number of party win
		 * 
		 * @return int
		 */
		public int getPartyWin() {
			return partyWin;
		}
		/**This method is use to get the number of days of freedom
		 * 
		 * @return int
		 */
		public int getTotalDays() {
			return totalDays;
		}
		
		/**This method is use to get the time played in second
		 * 
		 * @return int
		 */
		public int getTimePlayed() {
			return timePlayed;
		}

		/**This method is use to set the value of partyPlayed
		 * 
		 */
		public void setPartyPlayed() {
			this.partyPlayed +=1;
		}

		/**This method is use to set the value of partyWin
		 * 
		 */
		public void setPartyWin() {
			this.partyWin +=1;
		}

		/**This method is use to set the value of totalDays
		 * 
		 * @param stage : the stage of the party when the player quit or win
		 */
		public void setTotalDays(int stage) {
			ObservableList<Stage> stages = FXCollections.observableArrayList(Stage.values());
			List<String>listOfDays = new ArrayList<>();
			for (Stage s : stages) {
				String tmpDays = s.getStage();		
				listOfDays.add(0,tmpDays);
			}
			String tmp =listOfDays.get(14-stage);
			String[] tmpDay =tmp.split("\\ ");
			int days=Integer.parseInt(tmpDay[0]);
			this.totalDays += days;
		}

		/**This method is use to set the value of timeLeft
		 * 
		 * @param timeLeft : the value of the time used at each question 
		 */
		public void setTimePlayed(int timeLeft) {
			int tmp = 45 - timeLeft;
			this.timePlayed +=tmp; ;
		}		
}