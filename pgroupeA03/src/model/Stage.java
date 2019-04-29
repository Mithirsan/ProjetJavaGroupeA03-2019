package model;

public enum Stage {
	STAGE_01 ("-1 day"),
	STAGE_02 ("-2 days"),
	STAGE_03 ("-3 days"),
	STAGE_04 ("-5 days"),
	STAGE_05 ("-7 days"),
	STAGE_06 ("-15 days"),
	STAGE_07 ("-30 days"),
	STAGE_08 ("-60 days"),
	STAGE_09 ("-90 days"),
	STAGE_10 ("-120 days"),
	STAGE_11 ("-240 days"),
	STAGE_12 ("-360 days"),
	STAGE_13 ("-720 days"),
	STAGE_14 ("-1080 days"),
	STAGE_15 ("-1800 days");
	
	String stage;
	
	Stage(String stage){
		this.stage = stage;
	}
	
	public String getStage() {
		return stage;
	}
}
