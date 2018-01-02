package com.it.inv;

public class Supplier 
{
	private String SUPPLIER;
	private String SUPPLIER_NAME;
	
	
	
	@Override
	public String toString() {
		return "Supplier [SUPPLIER=" + SUPPLIER + ", SUPPLIER_NAME=" + SUPPLIER_NAME + "]";
	}
	
	public Supplier(String sUPPLIER, String sUPPLIER_NAME) {
		super();
		SUPPLIER = sUPPLIER;
		SUPPLIER_NAME = sUPPLIER_NAME;
	}
	public String getSUPPLIER() {
		return SUPPLIER;
	}
	public void setSUPPLIER(String sUPPLIER) {
		SUPPLIER = sUPPLIER;
	}
	public String getSUPPLIER_NAME() {
		return SUPPLIER_NAME;
	}
	public void setSUPPLIER_NAME(String sUPPLIER_NAME) {
		SUPPLIER_NAME = sUPPLIER_NAME;
	}
	
	
}
