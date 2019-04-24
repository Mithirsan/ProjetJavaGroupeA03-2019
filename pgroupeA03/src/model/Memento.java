package model;

import java.util.ArrayList;
import java.util.List;

public class Memento {
	private List<Question>stateList;
	
	public Memento(List<Question>tmpList) {
		this.stateList=new ArrayList<>();
		tmpList.stream().forEach(e->{
			this.stateList.add(e.clone());
		});
	}

	public List<Question> getStateList() {
		List<Question> copy = new ArrayList<>();
		stateList.stream().forEach(element -> {
			copy.add(element.clone());
		});
		return copy;
	}
}
