package com.it.inv;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class ItemController 
{
	private ItemDAO idao = new ItemDAO();
	
	@RequestMapping(value= {"/items"})
	public String items(Locale locale, Model model) throws SQLException
	{
		List<Item> items;
		
		items=idao.getItems();
		
		model.addAttribute("itms",items);
		
		return "items";
	}
	
	@RequestMapping("/newitem")
	public String ItemEntry(Locale locale, Model model) throws SQLException
	{
		List<String> uoms = idao.populateUOM();
		model.addAttribute("uoms", uoms);
		return "newitem";
	}
	
	@RequestMapping(value="/newitem", method=RequestMethod.POST)
	public String newitem(Model model, @RequestParam("item_id") String item_id, @RequestParam("item_name") String item_name, @RequestParam(value="opening_value", defaultValue="0", required=false) double opening_value, @RequestParam(value="uom",required=true) String uom, @RequestParam(value="rack_loc",required=false) String rack_loc) throws Exception
	{
		
		List<String> uoms = idao.populateUOM();
		model.addAttribute("uoms", uoms);
		
		if(idao.isDupID(item_id))
		{
			return "dupItemID";
		}
		
		Item item = new Item(item_id, item_name, uom, opening_value, rack_loc);
		System.out.println(item);
		
		idao.addItem(item);
		
		return "itemhome";
	}
	@RequestMapping(value="/admin/edititem", method=RequestMethod.GET)
	public String edititem(Model model, @RequestParam("id") String item_id) throws Exception
	{
		
		
		Item item;
		item=idao.getItemByID(item_id);
		
		
		model.addAttribute("itm",item);
		List<String> uoms = idao.populateUOM();
		
		
		model.addAttribute("uoms", uoms);
		
		System.out.println("FROM controller"+item);
		
		
		return "edititem";
	}
	
	@RequestMapping(value="/admin/edititem", method=RequestMethod.POST)
	public String edititem(Model model, @RequestParam("item_id") String item_id, @RequestParam("item_name") String item_name, @RequestParam("opening_value") double opening_value, @RequestParam("uom") String uom, @RequestParam("rack_loc") String rack_loc) throws Exception
	{
		
		
		Item item = new Item(item_id, item_name, uom, opening_value, rack_loc);
		System.out.println(item);
				
		idao.UpdateItem(item);
		
		return "confirm";
	}
	
	@RequestMapping(value="/admin/delitem", method=RequestMethod.GET)
	public String delitem(@RequestParam("id") String item_id) throws Exception
	{
		
		
		boolean x = idao.deleteItem(item_id);
		
		if(x==true)
			return "confirm";
		else
			return "itemDelError";
	}
	
	
}
