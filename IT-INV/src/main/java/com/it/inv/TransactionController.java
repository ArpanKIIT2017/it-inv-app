package com.it.inv;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class TransactionController 
{
	
	TransactionDAO tdao = new TransactionDAO();
	
	@RequestMapping("/newtrans")
	public String newTrans(Model model) throws SQLException
	{
		List<TransType> ttypeLOV = tdao.TransTypeLOV();
		List<Item> itemLOV = tdao.ItemLOV();
		List<Supplier> suplrLOV = tdao.SupplierLOV();
		List<Department> deptLOV = tdao.DeptLOV();
		
		model.addAttribute("ttypeLOV",ttypeLOV);
		model.addAttribute("itemLOV",itemLOV);
		model.addAttribute("suplrLOV",suplrLOV);
		model.addAttribute("deptLOV",deptLOV);
		
		System.out.println(deptLOV.toString());
		
		return "newtrans";
	}
	
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/newtrans", method=RequestMethod.POST)
	public String SaveTrans(
			Model model,
			
			@RequestParam(value="item_id", required=true) String item_id,
			@RequestParam(value="supplier_id", required=true) String supplier,
			@RequestParam(value="dept_id", required=true) int dept_id,
			@RequestParam(value="qty", required=true) float qty,
			@RequestParam(value="rate", required=true) float rate,
			@RequestParam(value="remark", required=false) String remark,
			@RequestParam(value="trans_type", required=true) int type_id,
			@RequestParam(value="trans_date", required=true) String trans_date,
			@RequestParam(value="doc_date", required=true) String doc_date,
			@RequestParam(value="doc_id", required=true) String doc_no,
			@RequestParam(value="naration", required=false) String naration
							
						) throws Exception
	
	{
		
		//SetAttribute
		List<TransType> ttypeLOV = tdao.TransTypeLOV();
		List<Item> itemLOV = tdao.ItemLOV();
		List<Supplier> suplrLOV = tdao.SupplierLOV();
		List<Department> deptLOV = tdao.DeptLOV();
		
		model.addAttribute("ttypeLOV",ttypeLOV);
		model.addAttribute("itemLOV",itemLOV);
		model.addAttribute("suplrLOV",suplrLOV);
		model.addAttribute("deptLOV",deptLOV);
		
		Transaction transaction = new Transaction();
		
		transaction.setITEM_ID(item_id);
		transaction.setSUPPLIER(supplier);
		transaction.setDEPARTMENT(dept_id);
		transaction.setQUANTITY(qty);
		transaction.setRATE(rate);
		transaction.setREMARK(remark);
		transaction.setTYPE_ID(type_id);
		transaction.setTRANS_DATE(trans_date);
		transaction.setDOCUMENT_DATE(doc_date);
		transaction.setDOCUMENT_NO(doc_no);
		transaction.setNARATION(naration);
		
		System.out.println(transaction);
		
		tdao.saveTrans(transaction);
		
		return "home";
	}
	
	@RequestMapping(value="/showTrans")
	public String showTrans(Model model) throws SQLException
	{
		
		List<Transaction> transactionS=tdao.fetchTransData();
		
		model.addAttribute("transactionS",transactionS);
		
		return "showtrans";
	}
	
	@RequestMapping(value="/admin/deltrans", method=RequestMethod.GET)
	public String delTrans(@RequestParam("id") int trans_id) throws SQLException
	{
		tdao.delTrans(trans_id);
		return "confirm";
	}
	
	
}
