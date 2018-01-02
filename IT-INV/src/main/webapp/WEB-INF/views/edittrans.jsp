<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<c:url value="/resources/js/transactionValidation.js" />" /></script>
<script>window.onload = function() {
	defTransDateLimit();
};</script>
<title>New Transaction Entry</title>

<style>
	input
	{
		font-size:16px;font-weight:"500";
	}
	
	select
	{
		font-size:18px;font-weight:"500";
	}
	
	div
	{
		font-size:20px;
	}
	
	#valErr
	{
		color:red;
			
	}
	
</style>

</head>
<body bgcolor="beige" onload="">

<div style="display:block;margin-left: auto;margin-right: auto; align-content:center; text-align:center">

	<h1>New Transaction</h1>
	<hr>
	<p id="valErr">
		
	</p>
	<div id="">
		<p id="Msg" style="font-face:bold;"></p>
	</div>
	
	 <form  method="post" action="newtrans" onsubmit="return validateTransaction(item_id,supplier_id,dept_id,trans_type,doc_date,doc_id,trans_date,qty,rate)">
	
	<div style=" display: inline-block;
    margin-left: auto;
    margin-right: auto;
   
    text-align: left;">
   
    <div id="left" style="float:left">
    	
    <strong>Item:</strong><br>
   <select name="item_id" required>
   		<option value="">Select Item</option>
   		<c:forEach items="${itemLOV}" var="itemLOV">
          <option value="${itemLOV.ITEM_ID}">${itemLOV.ITEM_NAME}</option> 
 		</c:forEach>
   </select>
   <br><br>
    
      <strong>Supplier:</strong><br>
   <select name="supplier_id" required>
   		<option value="">Select Supplier</option>
   		<c:forEach items="${suplrLOV}" var="suplrLOV">
          <option value="${suplrLOV.SUPPLIER}">${suplrLOV.SUPPLIER_NAME}</option> 
 		</c:forEach>
   </select>
   <br><br>
    
    <strong>Department:</strong><br>
   <select name="dept_id" required>
   <option value="">Select Department</option>
   		<c:forEach items="${deptLOV}" var="deptLOV">
          <option value="${deptLOV.DEPT_ID}">${deptLOV.DEPT_NAME}</option> 
 		</c:forEach>
   </select>
   <br><br>
    
    <strong>Quantity:</strong><br>
   <input type="text" name="qty" required><br><br>
   
   <strong>Rate:</strong><br>
   <input type="text" name="rate" required><br><br>
   
   <strong>Remark:</strong><br>
   <textarea name="remark" required></textarea><br><br> 
    </div>
    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    
    
    <div id="Right" style="float:right">
    <strong>Transaction Type:</strong><br>
   <select name="trans_type" required> 
   		<option value="">Select Transaction Type</option>
   		<c:forEach items="${ttypeLOV}" var="ttypeLOV">
          <option value="${ttypeLOV.TYPE_ID}">${ttypeLOV.TYPE_NAME}</option> 
 		</c:forEach>
   </select>
   <br><br>
    
    	<strong>Transaction Date:</strong><br>
   <input type="date" name="trans_date" value="" required>
   <br><br>
   <script>
   defTransDateLimit();
   </script>
   <strong>Document Date:</strong><br>
   <input type="date" name="doc_date" required>
   <br><br>
   
  		
   <strong>Document ID:</strong><br>
   <input type="text" name="doc_id" required><br><br>
   
   <strong>Naration:</strong><br>
   <textarea name="naration" required></textarea><br><br>
   
   
   </div>
   </div>
   	<div id="center" style="float:center">
    	<input type="submit" name="submit" value="Submit" style="font-size:20px" onclick="isValid(item_id)">
    	<input type="reset" style="font-size:20px">
    </div>
    
    </form>
    
    
</div>

</body>
</html>