package com.it.inv;


public class Item 
{
	private String ITEM_ID;		
	private String ITEM_NAME;
	private String UOM;
	private double OP_BAL;
	private double OP_VALUE;
	private double IN_QTY;
	private double OUT_QTY;
	private double OUT_VALUE;
	private double CLOSING_VAL;
	private double CLOSING_QTY;
	private String RACK_LOC;
	
	public Item() {}
	
	public Item(String iTEM_ID, String iTEM_NAME, String uOM, double oP_VALUE, String rACK_LOC) {
		super();
		ITEM_ID = iTEM_ID;
		ITEM_NAME = iTEM_NAME;
		OP_VALUE=oP_VALUE;
		UOM = uOM;
		RACK_LOC = rACK_LOC;
	}
	
	public String getITEM_ID() {
		return ITEM_ID;
	}
	public void setITEM_ID(String iTEM_ID) {
		ITEM_ID = iTEM_ID;
	}
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public void setITEM_NAME(String iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
	}
	public String getUOM() {
		return UOM;
	}
	public void setUOM(String uOM) {
		UOM = uOM;
	}
	public double getOP_BAL() {
		return OP_BAL;
	}
	public void setOP_BAL(double oP_BAL) {
		OP_BAL = oP_BAL;
	}
	public double getOP_VALUE() {
		return OP_VALUE;
	}
	public void setOP_VALUE(double oP_VALUE) {
		OP_VALUE = oP_VALUE;
	}
	public double getIN_QTY() {
		return IN_QTY;
	}
	public void setIN_QTY(double iN_QTY) {
		IN_QTY = iN_QTY;
	}
	public double getOUT_QTY() {
		return OUT_QTY;
	}
	public void setOUT_QTY(double oUT_QTY) {
		OUT_QTY = oUT_QTY;
	}
	public double getOUT_VALUE() {
		return OUT_VALUE;
	}
	public void setOUT_VALUE(double oUT_VALUE) {
		OUT_VALUE = oUT_VALUE;
	}
	public double getCLOSING_VAL() {
		return CLOSING_VAL;
	}
	public void setCLOSING_VAL(double cLOSING_VAL) {
		CLOSING_VAL = cLOSING_VAL;
	}
	public double getCLOSING_QTY() {
		return CLOSING_QTY;
	}
	public void setCLOSING_QTY(double cLOSING_QTY) {
		CLOSING_QTY = cLOSING_QTY;
	}
	public String getRACK_LOC() {
		return RACK_LOC;
	}
	public void setRACK_LOC(String rACK_LOC) {
		RACK_LOC = rACK_LOC;
	}
	@Override
	public String toString() {
		return "Item [ITEM_ID=" + ITEM_ID + ", ITEM_NAME=" + ITEM_NAME + ", UOM=" + UOM + ", OP_BAL=" + OP_BAL
				+ ", OP_VALUE=" + OP_VALUE + ", IN_QTY=" + IN_QTY + ", OUT_QTY=" + OUT_QTY + ", OUT_VALUE=" + OUT_VALUE
				+ ", CLOSING_VAL=" + CLOSING_VAL + ", CLOSING_QTY=" + CLOSING_QTY + ", RACK_LOC=" + RACK_LOC + "]";
	}
	
	public void computeStock()
	{
		CLOSING_QTY=(OP_VALUE+IN_QTY)-OUT_QTY;
	}
	
	public boolean isValid()
	{
		boolean flag=true;
		
		if(ITEM_ID==null||ITEM_ID.equals("")||ITEM_ID.equals(" "))
			flag=false;
		
		if(OUT_QTY>(OP_VALUE+IN_QTY));
			flag=false;
			
		return flag;
	}

}
