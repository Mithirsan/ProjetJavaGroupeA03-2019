package model;

public enum Presenter {
	JPFOUCAULT ("JP-Foucault"),
	THEREAPER ("TheReaper");
	
	String presenter;
	Presenter (String presenter){
		this.presenter=presenter;
	}
	public String getPresenter() {
		return presenter;
	}

}
