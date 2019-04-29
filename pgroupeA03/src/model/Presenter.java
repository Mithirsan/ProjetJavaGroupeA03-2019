package model;

public enum Presenter {
	JP_FOUCAULT ("JP-Foucault"),
	THE_REAPER ("TheReaper"),
	Camille ("CamilleCombal");
	
	String presenter;
	Presenter (String presenter){
		this.presenter=presenter;
	}
	public String getPresenter() {
		return presenter;
	}

}
