<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Item Entry</title>

<script type="text/javascript">
	
	function disableSubmit()
	{
		document.getElementById("submit").disabled = true;
	}
	
	
	
	function validate()
	{
		var item_id, OP_VAL;
		
		item_id = document.getElementById("item_id").value;
		OP_VAL = document.getElementById("OP_VAL").value;
		
		if(!item_id.match(/\S/))
		{
			document.getElementById("Msg").innerHTML="Item Code cannot be null...";
			
			
		}
		else
		{
			if(OP_VAL.match([^0-9])!='.')
			{
				document.getElementById("Msg").innerHTML="Invalid Opening Value";
			}
			else
				document.getElementById("submit").disabled = false;
		}
		
		
		
	}
	
</script>



</head>
<body bgcolor="beige">

<div style="display:block;margin-left: auto;margin-right: auto; align-content:center; text-align:center">

	<h1>Edit Item Entry</h1>
	<hr>
	<div id="">
		<p id="Msg" style="font-face:bold;"></p>
	</div>
	<form style=" display: inline-block;
    margin-left: auto;
    margin-right: auto;
    text-align: left;" method="post" action="edititem">
    
   <strong>Item Code:</strong><br>
   <input type="text" name="item_id" id="item_id" value=${ itm.getITEM_ID() } readonly>
   <br><br>
   
   <strong>Item Name:</strong><br>
   <input type="text" name="item_name" size="50px" onchange="validate()" value="${itm.getITEM_NAME() }">
   <br><br>
   
   <strong>Opening Value:</strong><br>
   <input type="text" name="opening_value" id="OP_VAL" value=${ itm.getOP_VALUE() } readonly>
   <br><br>
   
   <strong>IN QTY:</strong><br>
   <input type="text" name="IN_QTY" id="" value=${ itm.getIN_QTY() } disabled>
   <br><br>
   
   <strong>OUT QTY:</strong><br>
   <input type="text" name="OUT_QTY" id="" value=${ itm.getOUT_QTY() } disabled>
   <br><br>
   
    <strong>UOM:</strong>${ itm.getUOM() }<br>
   <select name="uom">
   		<option value=${ itm.getUOM() } selected>${ itm.getUOM() }</option>
   		<c:forEach items="${uoms}" var="uom">
          <option value="${uom}">${uom}</option> 
 		</c:forEach>
   </select>
   <br><br>
   
    <strong>Rack Location:</strong><br>
   	<input type="text" name="rack_loc" onchange="validate()" value=${ itm.getRACK_LOC() }>
   	<br><br><br>
   
   <input type="submit" name="submit" id="submit" value="Submit">
    
    
    
    </form>
</div>

</body>
</html>