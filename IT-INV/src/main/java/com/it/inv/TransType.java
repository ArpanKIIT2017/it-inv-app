package com.it.inv;

public class TransType 
{
	int TYPE_ID;
	String TYPE_NAME;
	String FUNCTION_TYPE;
	
	
	public TransType() {}
	
	public TransType(int tYPE_ID, String tYPE_NAME, String fUNCTION_TYPE) {
		super();
		TYPE_ID = tYPE_ID;
		TYPE_NAME = tYPE_NAME;
		FUNCTION_TYPE = fUNCTION_TYPE;
	}
	
	
	public int getTYPE_ID() {
		return TYPE_ID;
	}
	public void setTYPE_ID(int tYPE_ID) {
		TYPE_ID = tYPE_ID;
	}
	public String getTYPE_NAME() {
		return TYPE_NAME;
	}
	public void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}
	public String getFUNCTION_TYPE() {
		return FUNCTION_TYPE;
	}
	public void setFUNCTION_TYPE(String fUNCTION_TYPE) {
		FUNCTION_TYPE = fUNCTION_TYPE;
	}
	@Override
	public String toString() {
		return "TransType [TYPE_ID=" + TYPE_ID + ", TYPE_NAME=" + TYPE_NAME + ", FUNCTION_TYPE=" + FUNCTION_TYPE + "]";
	}
	
	
	
	
}
