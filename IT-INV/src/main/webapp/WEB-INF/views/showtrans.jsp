<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
</head>
<body bgcolor="beige">
<h2 style="text-align: center;">Transactions</h2>
<a href="showTrans">Refresh</a>
<hr>
<table border=1>

<tr>
	<td><strong>Transaction ID</strong></td>
	<td><strong>Transaction Date</strong></td>
	<td><strong>Transaction Type</strong></td>
	<td><strong>Supplier</strong></td>
	<td><strong>Department</strong></td>
	<td><strong>Document Date</strong></td>
	<td><strong>Document Number</strong></td>
	<td><strong>Quantity</strong></td>
	<td><strong>Rate</strong></td>
	<td><strong>Value</strong></td>
	<td><strong>Narration</strong></td>
	<td><strong>Remark</strong></td>
	
</tr>

<c:forEach items="${transactionS}" var="trans">
            <tr>
                <td>${trans.TRANS_ID}</td>
                <td>${trans.TRANS_DATE}</td>
                <td>${trans.TYPE_NAME}</td>
                <td>${trans.SUPPLIER}</td>
                <td>${trans.DEPT_NAME}</td>
                <td>${trans.DOCUMENT_DATE}</td>
                <td>${trans.DOCUMENT_NO}</td>
               	<td>${trans.QUANTITY}</td>
               	<td>${trans.RATE}</td>
               	<td>${trans.VALUE}</td>
               	<td>${trans.NARATION}</td>
               	<td>${trans.REMARK}</td>
               	
                
                <td><a href="" onClick="alert('Are you sure you want to delete this Transaction?');delwin=window.open('admin/deltrans?id=${trans.TRANS_ID}','delwin',width=600,height=300);">Delete</a></td>
            </tr>
 </c:forEach>

</table>






</body>
</html>