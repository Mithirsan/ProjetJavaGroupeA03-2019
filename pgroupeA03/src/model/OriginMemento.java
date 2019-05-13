package model;

import java.util.ArrayList;
import java.util.List;

/**This class is used to create a memento and set the list of question.
 * 
 * @author GROUP_A03
 *
 */
public class OriginMemento {
	private List<Question> stateList;
	
	/**This method allow the program to set the list of question
	 * 
	 * @param tmpList list of question
	 */
	public void setState(List<Question> tmpList) {
		this.stateList = new ArrayList<>();
		tmpList.stream().forEach(e -> {
			this.stateList.add(e.clone());
		});
	}
	
	/**This method is used to get the list a a memento
	 * 
	 * @return List of question
	 */
	public List<Question> getState() {
		List<Question> copy = new ArrayList<>();
		stateList.stream().forEach(e -> {
			copy.add(e.clone());
		});
		return copy;
	}
	/**This method is used to build a memento
	 * 
	 * @return A memento
	 */
	public Memento saveToMemento() {
		return new Memento(stateList);
	}
	
	/**This method is used to get the list from a memento 
	 * 
	 * @param m a memento
	 */
	public void getFromMemento(Memento m) {
		stateList = m.getStateList();
	}

}
