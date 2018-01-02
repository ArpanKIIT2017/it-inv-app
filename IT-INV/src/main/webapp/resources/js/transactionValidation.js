/**
 * Client Side Validation logic for transactions
 */

function validateTransaction(p1,p2,p3,p4,p5,p6,p7,qty,rate)
{
	document.getElementById("valErr").innerHTML="";
	isValidMsg(p1);isValidMsg(p2);isValidMsg(p3);isValidMsg(p4);isValidMsg(p5);isValidMsg(p6);isValidMsg(p7);isValidMsg(qty);isValidMsg(rate);
	
	
	if(isValid(p1)&&isValid(p2)&&isValid(p3)&&isValid(p4)&&isValid(p5)&&isValid(p6)&&isValid(p7)&&isValid(qty)&&isValid(rate))
	{
		if((!isNaN(qty.value))&&(!isNaN(rate.value)))
			{
			return true;
			}
			
		else
			
		{
			temp=document.getElementById("valErr").innerHTML;
			document.getElementById("valErr").innerHTML=temp+"Invalid rate or quantity values..";
			alert("Invalid Data!!");
				return false;
			}
			
	}
	else
	{
		alert("Invalid Data!!");
		return false;
	}
		
	
}

function isValid(param)
{
	val=param.value;
	
	temp=document.getElementById("valErr").innerHTML;
	
	if(val==null|| val=="" || val==" ")
	{
		//document.getElementById("valErr").innerHTML=temp+"Required Field "+param.name+" Value missing<br>";
		return false;
	}
	else
	{
		return true;
	}
	
}
function isValidMsg(param)
{
	val=param.value;
	
	temp=document.getElementById("valErr").innerHTML;
	
	if(val==null|| val=="" || val==" ")
	{
		document.getElementById("valErr").innerHTML=temp+"Required Field "+param.name+" Value missing<br>";
		return false;
	}
	else
	{
		return true;
	}
	
}

function checkJSLink()
{
	alert("js working fine");
}


	