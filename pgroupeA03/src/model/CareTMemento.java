package model;

import java.util.ArrayList;
import java.util.List;

/**This class contain a list of all memento
 * 
 * @author GROUP_A03
 *
 */
public class CareTMemento {
	private List<Memento> mementos;
	
	/**The constructor initialise the list of memento
	 * 
	 */
	public CareTMemento() {
		mementos = new ArrayList<Memento>();
	}
	
	/**This method add a memento into the memento list
	 * 
	 * @param m
	 */
	public void add(Memento m) {
		mementos.add(m);
	}
	
	/**this method return a memento according to the index in the list
	 * 
	 * @param index : number
	 * @return a memento
	 */
	public Memento get(int index) {
		return mementos.get(index);
	}
}
