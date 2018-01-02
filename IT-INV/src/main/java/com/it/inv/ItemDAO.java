package com.it.inv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ItemDAO 
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

	public List<Item> getItems() throws SQLException
	{
		Item item;
		List<Item> items = new ArrayList<Item>();
		
		connect();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from item");
		
		while(rs.next())
		{
			item=new Item();
			
			item.setITEM_ID(rs.getString("ITEM_ID"));
			item.setITEM_NAME(rs.getString("ITEM_NAME"));
			item.setOP_VALUE(rs.getFloat("OP_VALUE"));
			item.setUOM(rs.getString("UOM"));
			item.setRACK_LOC(rs.getString("RACK_LOC"));
			item.computeStock();
			item.getCLOSING_QTY();
			
			items.add(item);
		}
		
		return items;
	}
	
	public void addItem(Item item) throws Exception
	{
		System.out.println(item);
		String sql="Insert into item (ITEM_ID,ITEM_NAME, UOM, OP_VALUE, RACK_LOC) values(?,?,?,?,?)";
		connect();
		PreparedStatement ps = con.prepareStatement(sql);
		 
		
		
		ps.setString(1, item.getITEM_ID());
		ps.setString(2,item.getITEM_NAME());
		ps.setString(3, item.getUOM());
		ps.setDouble(4, item.getOP_VALUE());
		ps.setString(5, item.getRACK_LOC());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	public void UpdateItem(Item item) throws Exception
	{
		System.out.println(item);
		//String sql1="Insert into item (ITEM_ID,ITEM_NAME, UOM, OP_VALUE, RACK_LOC) values(?,?,?,?,?)";
		String sql="Update item set ITEM_NAME=?, UOM=?, OP_VALUE=?, RACK_LOC=? where ITEM_ID=?";
		connect();
		PreparedStatement ps = con.prepareStatement(sql);
		 
		
		
		
		ps.setString(1,item.getITEM_NAME());
		ps.setString(2, item.getUOM());
		ps.setDouble(3, item.getOP_VALUE());
		ps.setString(4, item.getRACK_LOC());
		ps.setString(5, item.getITEM_ID());
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	
	public Item getItemByID(String id) throws SQLException
	{
		
		String sql="select * from item where item_id=?";
		connect();
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs=ps.executeQuery();
		
		Item item=new Item();
		
		rs.next();
		
						
		item.setITEM_ID(rs.getString("ITEM_ID"));
		item.setITEM_NAME(rs.getString("ITEM_NAME"));
		item.setOP_VALUE(rs.getFloat("OP_VALUE"));
		item.setIN_QTY(rs.getFloat("IN_QTY"));
		item.setOUT_QTY(rs.getFloat("OUT_QTY"));
		item.setUOM(rs.getString("UOM"));
		item.setRACK_LOC(rs.getString("RACK_LOC"));
			
		rs.close();
		ps.close();
		con.close();
		
		
		return item;
		
	}
	
	public int transAgainstItem(String item_id) throws SQLException
	{
		int x=0;
		
		connect();
		
		PreparedStatement ps = con.prepareStatement("select * from transaction_data where item_id=?");
		ps.setString(1, item_id);
		ResultSet rs = ps.executeQuery(); 
		
		while(rs.next())
			x++;
		
		return x;
	}
	
	public boolean deleteItem(String id) throws SQLException
	{
		connect();
		String sql="delete from item where ITEM_ID=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		if(transAgainstItem(id)>0)
		{
			return false;
		}
		else
		{
			ps.executeUpdate();
		}
		
		ps.close();
		con.close();
		return true;
		
	}
	
	public List<String> populateUOM() throws SQLException
	{
		
		connect();
		
		String sql="select Units from UNITS";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<String> uoms = new ArrayList<String>();
		
		while(rs.next())
		{
			uoms.add(rs.getString("UNITS"));
		}
		
		return uoms;
	}
	
	public boolean isDupID(String id) throws Exception 
	{
		boolean flag=false;
		
		connect();
		
		PreparedStatement ps = con.prepareStatement("select * from item where ITEM_ID=?");
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			flag=true;
		}
		
		return flag;
	}

}
