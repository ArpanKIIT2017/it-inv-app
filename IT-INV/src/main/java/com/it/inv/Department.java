package com.it.inv;

public class Department 
{
	int DEPT_ID;
	String DEPT_NAME;
	
	
	public Department(int dEPT_ID, String dEPT_NAME) {
		super();
		DEPT_ID = dEPT_ID;
		DEPT_NAME = dEPT_NAME;
	}
	
	public int getDEPT_ID() {
		return DEPT_ID;
	}
	public void setDEPT_ID(int dEPT_ID) {
		DEPT_ID = dEPT_ID;
	}
	public String getDEPT_NAME() {
		return DEPT_NAME;
	}
	public void setDEPT_NAME(String dEPT_NAME) {
		DEPT_NAME = dEPT_NAME;
	}
	
	
}
