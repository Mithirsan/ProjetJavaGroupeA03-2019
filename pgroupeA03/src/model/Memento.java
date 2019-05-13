package model;

import java.util.ArrayList;
import java.util.List;

/**This class define a memento.
 * 
 * @author GROUP_A03
 *
 */
public class Memento {
	private List<Question>stateList;
	
	/**Constructor
	 * 
	 * @param tmpList : the list a question at the moment T
	 */
	public Memento(List<Question>tmpList) {
		this.stateList=new ArrayList<>();
		tmpList.stream().forEach(e->{
			this.stateList.add(e.clone());
		});
	}

	/**This method is use to get the list of the memento
	 * 
	 * @return List of question at the moment T
	 */
	public List<Question> getStateList() {
		List<Question> copy = new ArrayList<>();
		stateList.stream().forEach(element -> {
			copy.add(element.clone());
		});
		return copy;
	}
}
