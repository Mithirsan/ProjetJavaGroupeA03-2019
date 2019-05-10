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

public class Stats {

		private int partyPlayed =0;
		private int partyWin =0;
		private int totalDays =0;
		private int timePlayed =0;
		
		public Stats() { 
			
		}
		
		public String toJSon() {
			Gson gson = new Gson();
			return gson.toJson(this);
		}
		public static Stats fromJSon(String json) {
			Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			return gson.fromJson(json, Stats.class);
		}
		
		public Stats downloadData() throws FileNotFoundException, IOException {
			Stats statistic = fromJSon(Serializable.readSavedStats());
			return statistic;
		}
		@Override
		public String toString() {
			return "Stats [partyPlayed=" + partyPlayed + ", partyWin=" + partyWin + ", totalDays=" + totalDays
					+ ", timePlayed=" + timePlayed + "]";
		}
		
		public int getPartyPlayed() {
			return partyPlayed;
		}
		
		public int getPartyWin() {
			return partyWin;
		}
		
		public int getTotalDays() {
			return totalDays;
		}
		
		public int getTimePlayed() {
			return timePlayed;
		}

		public void setPartyPlayed() {
			this.partyPlayed +=1;
		}

		public void setPartyWin() {
			this.partyWin +=1;
		}

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

		public void setTimePlayed(int timeLeft) {
			int tmp = 45 - timeLeft;
			this.timePlayed +=tmp; ;
		}		
}