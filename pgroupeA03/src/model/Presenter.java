package model;

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
