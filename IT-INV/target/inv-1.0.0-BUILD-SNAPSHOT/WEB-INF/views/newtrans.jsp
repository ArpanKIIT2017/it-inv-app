<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	
	div{
		font-size:20px;
	}
	
</style>

</head>
<body bgcolor="beige">

<div style="display:block;margin-left: auto;margin-right: auto; align-content:center; text-align:center">

	<h1>New Transaction</h1>
	<hr>
	<div id="">
		<p id="Msg" style="font-face:bold;"></p>
	</div>
	
	
	<form style=" display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: left;" method="post" action="newitem">
    
    <div id="left" style="float:left">
    	
    <strong>Item:</strong><br>
   <select name="item_id">
   		<c:forEach items="${itemLOV}" var="itemLOV">
          <option value="${itemLOV.ITEM_ID}">${itemLOV.ITEM_NAME}</option> 
 		</c:forEach>
   </select>
   <br><br>
    
      <strong>Supplier:</strong><br>
   <select name="supplier_id">
   		<c:forEach items="${suplrLOV}" var="suplrLOV">
          <option value="${suplrLOV.SUPPLIER}">${suplrLOV.SUPPLIER_NAME}</option> 
 		</c:forEach>
   </select>
   <br><br>
    
    <strong>Department:</strong><br>
   <select name="dept_id">
   		<c:forEach items="${deptLOV}" var="deptLOV">
          <option value="${deptLOV.DEPT_ID}">${deptLOV.DEPT_NAME}</option> 
 		</c:forEach>
   </select>
   <br><br>
    
    <strong>Quantity:</strong><br>
   <input type="text" name="qty"><br><br>
   
   <strong>Rate:</strong><br>
   <input type="text" name="rate"><br><br>
   
   <strong>Remark:</strong><br>
   <textarea name="remark"></textarea><br><br> 
    </div>
    <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    
    
    <div id="Right" style="float:right">
    <strong>Transaction Type:</strong><br>
   <select name="trans_type"> 
   		<c:forEach items="${ttypeLOV}" var="ttypeLOV">
          <option value="${ttypeLOV.TYPE_ID}">${ttypeLOV.TYPE_NAME}</option> 
 		</c:forEach>
   </select>
   <br><br>
    
    	<strong>Transaction Date:</strong><br>
   <input type="date" name="trans_date">
   <br><br>
   
   <strong>Document Date:</strong><br>
   <input type="date" name="doc_date">
   <br><br>
   
  		
   <strong>Document ID:</strong><br>
   <input type="text" name="doc_id"><br><br>
   
   <strong>Naration:</strong><br>
   <textarea name="naration"></textarea><br><br>
   
   
   
    </div>
    
   
    </form>
    
    <div id="center" style="float:center">
    	<input type="submit" name="submit" value="Submit" style="font-size:20px">
    </div>
</div>

</body>
</html>