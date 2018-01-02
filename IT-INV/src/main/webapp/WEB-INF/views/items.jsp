<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ITEMS</title>





</head>
<body bgcolor="beige">

<h1>Items</h1>
<a href="?pg=newitem">Add New Item</a>
<a href="?pg=items">Refresh</a>
<hr>

<table border=1>

<tr>
	<td><strong>Item Id</strong></td>
	<td><strong>Item Name</strong></td>
	<td><strong>Opening Value</strong></td>
	<td><strong>IN QTY</strong></td>
	<td><strong>OUT QTY</strong></td>
	<td><strong>Stock</strong></td>
	<td><strong>Rack Location</strong></td>
	
</tr>

<c:forEach items="${itms}" var="itm">
            <tr>
                <td>${itm.ITEM_ID}</td>
                <td>${itm.ITEM_NAME}</td>
                <td>${itm.OP_VALUE}</td>
                <td>${itm.IN_QTY}</td>
                <td>${itm.OUT_QTY}</td>
                <td>${itm.CLOSING_QTY}</td>
                <td>${itm.RACK_LOC}</td>
                <td><a href="" onClick="editwin=window.open('admin/edititem?id=${itm.ITEM_ID}','editwin',width=600,height=300);">Edit</a></td>
                <td><a href="" onClick="alert('Are you sure you want to delete this item?');delwin=window.open('admin/delitem?id=${itm.ITEM_ID}','delwin',width=600,height=300);">Delete</a></td>
            </tr>
 </c:forEach>

</table>



	

</body>
</html>