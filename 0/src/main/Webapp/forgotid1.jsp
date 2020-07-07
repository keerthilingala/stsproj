<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<div class="container-fluid">
<div class="row mainheader">
<div class="col-sm text-nowrap">

<span class="logo">Welcome</span>



<link rel="stylesheet" type="text/css" href="/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</div>
</div>
</div>
<script type="text/javascript">
function validate(){
    
	var phn=document.getElementById("phno").value;
		else if(phn=="")
			{
			document.getElementById("phn").style.borderColor = "red";
			alert("please update contact number field");
				return false;
			
			}
}

</script>

</head>
<body>
<div class="header">

</div>
<h2>Forgot Userid?</h2>
<div class="formdata3">
<div align="center">
<form onsubmit="return validate()" action="Aforgotuid2" method="post">
<table>
<tr>
<td>Contact</td>
<td><input name="phno" id="phno" type="text"/>
</tr>

</table>
<input type="submit" value ="submit" class="formsubmitbutton"/>

</form>
<br><br>
<span style="color: green; font-size: 30px; font: bold;text-decoration: underline;">${message}</span><span style="font-size: 30px; font: bold;margin-left: 5px;">is Your Id</span> 
<br><br>
Want to login?<a href="supportanalystlogin">Click here</a>

</div>
</div>


</body>
</html>

    