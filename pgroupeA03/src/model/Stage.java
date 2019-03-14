package model;

public enum Stage {
	STAGE_01 ("01"),
	STAGE_02 ("02"),
	STAGE_03 ("03"),
	STAGE_04 ("04"),
	STAGE_05 ("05"),
	STAGE_06 ("06"),
	STAGE_07 ("07"),
	STAGE_08 ("08"),
	STAGE_09 ("09"),
	STAGE_10 ("10"),
	STAGE_11 ("11"),
	STAGE_12 ("12"),
	STAGE_13 ("13"),
	STAGE_14 ("14"),
	STAGE_15 ("15");
	
	String stage;
	
	Stage(String stage){
		this.stage = stage;
	}
	
	public String getStage() {
		return stage;
	}
}
