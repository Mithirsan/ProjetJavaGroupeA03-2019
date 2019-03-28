package model;

import java.util.ArrayList;
import java.util.List;

public class OriginMemento {
private List<Question> stateList;
	

	public void setState(List<Question> tmpList) {
		this.stateList = new ArrayList<>();
		tmpList.stream().forEach(e -> {
			this.stateList.add(e.clone());
		});
	}
	
	public List<Question> getState() {
		List<Question> copy = new ArrayList<>();
		stateList.stream().forEach(e -> {
			copy.add(e.clone());
		});
		return copy;
	}
	
	public Memento saveToMemento() {
		return new Memento(stateList);
	}
	
	public void getFromMemento(Memento m) {
		stateList = m.getStateList();
	}

}
