package model;

import java.util.ArrayList;
import java.util.List;

public class CareTMemento {
private List<Memento> mementos;
	
	public CareTMemento() {
		mementos = new ArrayList<Memento>();
	}
	
	public void add(Memento m) {
		mementos.add(m);
	}
	
	public Memento get(int index) {
		return mementos.get(index);
	}
}
