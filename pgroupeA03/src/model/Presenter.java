package model;
/**This enumeration contains the name of the picture with the presenter
 * 
 * @author GROUP_A03
 *
 */
public enum Presenter {
	JEAN_PIERRE_FOUCAULT ("JP-Foucault"),
	THE_REAPER ("TheReaper"),
	CAMILLE_COMBAL ("CamilleCombal");
	
	String presenter;
	
	Presenter (String presenter){
		this.presenter=presenter;
	}
	
	public String getPresenter() {
		return presenter;
	}

}
