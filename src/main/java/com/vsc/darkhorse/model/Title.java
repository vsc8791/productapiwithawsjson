package com.vsc.darkhorse.model;

public class Title {
	
	private String firstTitle;
	private String secondTitle;
	private String thirdTitle;
	private String fourthTitle;
	
	public Title() {
	}

	public Title(String firstTitle, String secondTitle, String thirdTitle, String fourthTitle) {
		super();
		this.firstTitle = firstTitle;
		this.secondTitle = secondTitle;
		this.thirdTitle = thirdTitle;
		this.fourthTitle = fourthTitle;
	}

	public String getFirstTitle() {
		return firstTitle;
	}

	public void setFirstTitle(String firstTitle) {
		this.firstTitle = firstTitle;
	}

	public String getSecondTitle() {
		return secondTitle;
	}

	public void setSecondTitle(String secondTitle) {
		this.secondTitle = secondTitle;
	}

	public String getThirdTitle() {
		return thirdTitle;
	}

	public void setThirdTitle(String thirdTitle) {
		this.thirdTitle = thirdTitle;
	}

	public String getFourthTitle() {
		return fourthTitle;
	}

	public void setFourthTitle(String fourthTitle) {
		this.fourthTitle = fourthTitle;
	}
	
	
	

}
