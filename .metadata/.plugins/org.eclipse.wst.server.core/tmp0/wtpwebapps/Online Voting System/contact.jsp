<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
/*chrome,safari,edge,opera*/
input::-webkit-outer-spin-button,input::-webkit-inner-spin-button
{
-webkit-appearance: none;
margin: 0;
}
/*firfox*/
input[type=number]
{
-moz-appearance: textfield;
}
</style>

<title>Contact Us</title>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class = "formBack">
<form action = "contact" method ="post">
<h5>Please Fill The Details</h5>
<label for="fname" >Name :</label>

<input name = "fname" id = "fname" type = "text" class="contactinput1" style="margin-left:150px;" >
<br>
<label for="phone" >Phone Number :</label>

<input name = "phone" id = "phone" type = "number" style="margin-left:22px;" >
<br>
<label for="emailid" >Email :</label>

<input name = "emailid" id = "emailid" type = "email" style="margin-left:150px;" >
<br>
<label for="comments" >Comments :</label>

<input name = "comments" id = "comments" type = "text" style="height:70px; width:200px;margin-top:8px;text-align:left">
<br>


<button type = "submit" Style="margin-left:190px;">Submit</button>
<button type = "Reset" >Clear</button>




<br>

</form>
</div>

</body>
</html>