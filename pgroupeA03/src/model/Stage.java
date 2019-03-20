package model;

public enum Stage {
	STAGE_01 ("-1 day"),
	STAGE_02 ("-4 days"),
	STAGE_03 ("-7 days"),
	STAGE_04 ("-14 days"),
	STAGE_05 ("-1 month"),
	STAGE_06 ("-2 months"),
	STAGE_07 ("-3 months"),
	STAGE_08 ("-6 months"),
	STAGE_09 ("-1 year"),
	STAGE_10 ("-2 years"),
	STAGE_11 ("-4 years"),
	STAGE_12 ("-8 years"),
	STAGE_13 ("-16 years"),
	STAGE_14 ("-32 years"),
	STAGE_15 ("released");
	
	String stage;
	
	Stage(String stage){
		this.stage = stage;
	}
	
	public String getStage() {
		return stage;
	}
}
