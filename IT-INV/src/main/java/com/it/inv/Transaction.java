package com.it.inv;

public class Transaction 
{
	private long TRANS_ID;
	private String TRANS_DATE;
	private int TYPE_ID;
	private String SUPPLIER;
	private int DEPARTMENT;
	private double QUANTITY;
	private double RATE;
	private double VALUE;
	private String NARATION;
	private String REMARK;
	private String ITEM_ID;
	private String TYPE_NAME;
	private String DOCUMENT_NO;
	private String DOCUMENT_DATE;
	private double TAX_AMT;
	private String DEPT_NAME;
	
	@Override
	public String toString() {
		return "Transaction [TRANS_ID=" + TRANS_ID + ", TRANS_DATE=" + TRANS_DATE + ", TYPE_ID=" + TYPE_ID
				+ ", SUPPLIER=" + SUPPLIER + ", DEPARTMENT=" + DEPARTMENT + ", QUANTITY=" + QUANTITY + ", RATE=" + RATE
				+ ", VALUE=" + VALUE + ", NARATION=" + NARATION + ", REMARK=" + REMARK + ", ITEM_ID=" + ITEM_ID
				+ ", TYPE_NAME=" + TYPE_NAME + ", DOCUMENT_NO=" + DOCUMENT_NO + ", DOCUMENT_DATE=" + DOCUMENT_DATE
				+ ", TAX_AMT=" + TAX_AMT + ", DEPT_NAME=" + DEPT_NAME + "]";
	}




	public Transaction()
	{
		//Default Constructor
	}
	
	
	
	
	public long getTRANS_ID() {
		return TRANS_ID;
	}
	public void setTRANS_ID(long tRANS_ID) {
		TRANS_ID = tRANS_ID;
	}
	public String getTRANS_DATE() {
		return TRANS_DATE;
	}
	public void setTRANS_DATE(String tRANS_DATE) {
		TRANS_DATE = tRANS_DATE;
	}
	public int getTYPE_ID() {
		return TYPE_ID;
	}
	public void setTYPE_ID(int tYPE_ID) {
		TYPE_ID = tYPE_ID;
	}
	public String getSUPPLIER() {
		return SUPPLIER;
	}
	public void setSUPPLIER(String sUPPLIER) {
		SUPPLIER = sUPPLIER;
	}
	public int getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(int dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	public double getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(double qUANTITY) {
		QUANTITY = qUANTITY;
	}
	public double getRATE() {
		return RATE;
	}
	public void setRATE(double rATE) {
		RATE = rATE;
	}
	public double getVALUE() {
		return (RATE*QUANTITY);
	}
	public void setVALUE(double vALUE) {
		VALUE = vALUE;
	}
	public String getNARATION() {
		return NARATION;
	}
	public void setNARATION(String nARATION) {
		NARATION = nARATION;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	public String getITEM_ID() {
		return ITEM_ID;
	}
	public void setITEM_ID(String iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}
	public String getTYPE_NAME() {
		return TYPE_NAME;
	}
	public void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}
	public String getDOCUMENT_NO() {
		return DOCUMENT_NO;
	}
	public void setDOCUMENT_NO(String dOCUMENT_NO) {
		DOCUMENT_NO = dOCUMENT_NO;
	}
	public String getDOCUMENT_DATE() {
		return DOCUMENT_DATE;
	}
	public void setDOCUMENT_DATE(String dOCUMENT_DATE) {
		DOCUMENT_DATE = dOCUMENT_DATE;
	}
	public double getTAX_AMT() {
		return TAX_AMT;
	}
	public void setTAX_AMT(double tAX_AMT) {
		TAX_AMT = tAX_AMT;
	}
	public String getDEPT_NAME() {
		return DEPT_NAME;
	}
	public void setDEPT_NAME(String dEPT_NAME) {
		DEPT_NAME = dEPT_NAME;
	}
	
	
	
	
}
