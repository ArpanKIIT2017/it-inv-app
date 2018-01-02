package com.it.inv;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
public class TransactionDAO 
{
private Connection con;
	
	private void connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/it-inv";
			String user="root";
			String passwd="redhat";
			
			con = DriverManager.getConnection(url,user,passwd);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<TransType> TransTypeLOV() throws SQLException
	{
		TransType tt;
		
		List<TransType> tts = new ArrayList<TransType>();
		
		connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from tranaction_master");
		
		while(rs.next())
		{
			tt=new TransType(rs.getInt("TYPE_ID"),rs.getString("TYPE_NAME"),rs.getString("FUNCTION_TYPE"));
			tts.add(tt);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return tts;
	}
	
	public List<TransType> TransTypeLOV(int type_id) throws SQLException
	{
		TransType tt;
		
		List<TransType> tts = new ArrayList<TransType>();
		
		connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from tranaction_master where TYPE_ID="+type_id);
		
		while(rs.next())
		{
			tt=new TransType(rs.getInt("TYPE_ID"),rs.getString("TYPE_NAME"),rs.getString("FUNCTION_TYPE"));
			tts.add(tt);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return tts;
	}
	
	public List<Item> ItemLOV() throws SQLException
	{
		Item item;
		List<Item> items = new ArrayList<Item>();
		
		connect();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select ITEM_ID,ITEM_NAME from item");
		
		while(rs.next())
		{
			item=new Item();
			
			item.setITEM_ID(rs.getString("ITEM_ID"));
			item.setITEM_NAME(rs.getString("ITEM_NAME"));
				
			items.add(item);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return items;
	}
	
	public List<Supplier> SupplierLOV() throws SQLException
	{
		Supplier supplier;
		List<Supplier> suppliers = new ArrayList<Supplier>();
		
		connect();
		Statement st=con.createStatement();
		
		ResultSet rs = st.executeQuery("select SUPPLIER, SUPPLIER_NAME from supplr_master");
		
		while(rs.next())
		{
			supplier=new Supplier(rs.getString("SUPPLIER"),rs.getString("SUPPLIER_NAME"));
			suppliers.add(supplier);
		}
		
		rs.close();
		st.close();
		con.close();
	
		return suppliers;
	}
	
	public List<Supplier> SupplierLOV(int supplier_id) throws SQLException
	{
		Supplier supplier;
		List<Supplier> suppliers = new ArrayList<Supplier>();
		
		connect();
		Statement st=con.createStatement();
		
		ResultSet rs = st.executeQuery("select SUPPLIER, SUPPLIER_NAME from supplr_master where SUPPLIER="+supplier_id);
		
		while(rs.next())
		{
			supplier=new Supplier(rs.getString("SUPPLIER"),rs.getString("SUPPLIER_NAME"));
			suppliers.add(supplier);
		}
		
		rs.close();
		st.close();
		con.close();
	
		return suppliers;
	}
	
	
	public List<Department> DeptLOV() throws SQLException
	{
		Department dept;
		List<Department> depts = new ArrayList<Department>();
		
		connect();
		Statement st=con.createStatement();
		
		ResultSet rs = st.executeQuery("select DEPT_ID,DEPT_NAME from department");
		
		while(rs.next())
		{
			dept=new Department(rs.getInt("DEPT_ID"),rs.getString("DEPT_NAME"));
			depts.add(dept);
		}
		
		rs.close();
		st.close();
		con.close();
	
		return depts;
	}
	
	public List<Department> DeptLOV(int dept_id) throws SQLException
	{
		Department dept;
		List<Department> depts = new ArrayList<Department>();
		
		connect();
		PreparedStatement st=con.prepareStatement("select DEPT_ID,DEPT_NAME from department where dept_id=?");
		st.setInt(1, dept_id);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			dept=new Department(rs.getInt("DEPT_ID"),rs.getString("DEPT_NAME"));
			depts.add(dept);
		}
		
		
		rs.close();
		st.close();
		con.close();
	
		return depts;
	}
	
	public void saveTrans(Transaction transaction) throws Exception
	{
		String sql="Insert into transaction_data(TRANS_ID,TRANS_DATE,TYPE_ID,SUPPLIER,DEPARTMENT,QUANTITY,RATE,VALUE,NARATION,REMARK,ITEM_ID,DOCUMENT_NO,DOCUMENT_DATE) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		connect();
		PreparedStatement ps = con.prepareStatement(sql);
					
		ps.setLong(1, ReqTransID());	
		ps.setString(2,transaction.getTRANS_DATE());
		ps.setInt(3, transaction.getTYPE_ID());
		ps.setString(4, transaction.getSUPPLIER());
		ps.setInt(5,transaction.getDEPARTMENT());
		ps.setDouble(6, transaction.getQUANTITY());
		ps.setDouble(7, transaction.getRATE());
		ps.setDouble(8, transaction.getVALUE());
		ps.setString(9, transaction.getNARATION());
		ps.setString(10, transaction.getREMARK());
		ps.setString(11, transaction.getITEM_ID());
		ps.setString(12, transaction.getDOCUMENT_NO());
		ps.setString(13, transaction.getDOCUMENT_DATE());
		
		ps.executeUpdate();
		
		ps=con.prepareStatement("select * from tranaction_master where TYPE_ID=?");
		ps.setInt(1,transaction.getTYPE_ID());
		
		ResultSet rs=ps.executeQuery();
		
		String func="";
		while(rs.next())
		{
			func=rs.getString("FUNCTION_TYPE");
		}
		
		if(func.equals("1"))
				UpdateIN_QTYitem(transaction.getQUANTITY(), transaction.getITEM_ID());
		else if(func.equals("2"))
				UpdateOUT_QTYitem(transaction.getQUANTITY(), transaction.getITEM_ID());
		
		rs.close();
		ps.close();
		con.close();
	}
	
	private long ReqTransID() throws Exception
	{
		connect();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select MAX(TRANS_ID)+1 from transaction_data");
		long id=1;
		
		
		while(rs.next())
		{
				id=rs.getInt(1);
		}
		
		
		
		
		rs.close();
		st.close();
		
		return (id);
	}
	
	private void UpdateIN_QTYitem(double qty, String item_id) throws Exception
	{
		connect();
		
		PreparedStatement ps = con.prepareStatement("select * from item where item_id=?");
		ps.setString(1, item_id);
		
		ResultSet rs = ps.executeQuery();
		
		@SuppressWarnings("unused")
		double present_qty=0;
		
		double OUT=0, op_val=0;
		while(rs.next())
		{
			present_qty=rs.getDouble("IN_QTY");
			
			Double val = Double.valueOf(present_qty);
			if(val==null)present_qty=0;
			
			OUT=rs.getDouble("OUT_QTY");
			op_val=rs.getDouble("OP_VALUE");
				
		}
		
		String sql="Update item set IN_QTY=?,CLOSING_QTY=? where ITEM_ID=?";
		ps = con.prepareStatement(sql);
		ps.setDouble(1,(present_qty+qty));
		ps.setDouble(2, (((present_qty+qty)+op_val)-OUT));
		ps.setString(3, item_id);
		
		ps.executeUpdate();
		
		rs.close();
		ps.close();
		con.close();
	}
	
	private void UpdateOUT_QTYitem(double qty, String item_id) throws Exception
	{
		connect();
		
		PreparedStatement ps = con.prepareStatement("select * from item where item_id=?");
		ps.setString(1, item_id);
		
		ResultSet rs = ps.executeQuery();
		
		@SuppressWarnings("unused")
		double present_qty=0;
		
		double IN=0, op_val=0;
		while(rs.next())
		{
			present_qty=rs.getDouble("OUT_QTY");
			
			Double val = Double.valueOf(present_qty);
			if(val==null)present_qty=0;
			
			IN=rs.getDouble("IN_QTY");
			op_val=rs.getDouble("OP_VALUE");
		}
		
		String sql="Update item set OUT_QTY=? CLOSING_QTY=? where ITEM_ID=?";
		ps = con.prepareStatement(sql);
		ps.setDouble(1,(present_qty+qty));
		ps.setDouble(2, (IN+op_val)-((present_qty+qty)));
		ps.setString(3, item_id);
		
		ps.executeUpdate();
		
		ps.close();
		rs.close();
		con.close();
		

	}
	
	public List<Transaction> fetchTransData() throws SQLException
	{
		connect();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from transaction_data");
		
		Transaction transaction;
		
		List<Transaction> transactionS = new ArrayList<Transaction>(); 
		
		while(rs.next())
		{
			transaction = new Transaction();
			
			//get Type Name
			List<TransType> type = TransTypeLOV(rs.getInt("TYPE_ID"));
			List<Department> dept = DeptLOV(rs.getInt("DEPARTMENT"));
			List<Supplier> suppl = SupplierLOV(rs.getInt("SUPPLIER"));
			
			
			transaction.setTRANS_ID(rs.getLong("TRANS_ID"));
			transaction.setTRANS_DATE(rs.getDate("TRANS_DATE").toString());
			transaction.setTYPE_NAME(type.get(0).TYPE_NAME);
			transaction.setDEPT_NAME(dept.get(0).DEPT_NAME);
			transaction.setSUPPLIER(suppl.get(0).getSUPPLIER_NAME());
			transaction.setQUANTITY(rs.getDouble("QUANTITY"));
			transaction.setRATE(rs.getDouble("RATE"));
			transaction.setVALUE(rs.getDouble("VALUE"));
			transaction.setDOCUMENT_DATE(rs.getDate("DOCUMENT_DATE").toString());
			transaction.setDOCUMENT_NO(rs.getString("DOCUMENT_NO"));
			transaction.setNARATION(rs.getString("NARATION"));
			transaction.setREMARK(rs.getString("REMARK"));
			
			transactionS.add(transaction);
			
			
			
		}
		
		rs.close();
		
		rs.close();
		st.close();
		con.close();
		
		return transactionS;
		
	}
	
	public void delTrans(int trans_id) throws SQLException
	{
		connect();
		
		PreparedStatement ps = con.prepareStatement("DELETE FROM transaction_data WHERE TRANS_ID=?");
		ps.setInt(1, trans_id);
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
}
