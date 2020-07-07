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
	
	var userid=document.getElementById("uid").value;
	
		
		else if(userid=="")
			{
			document.getElementById("uid").style.borderColor = "red";
			alert("please update contact number field");
				return false;
			
			}
}

</script>

</head>
<body>
<div class="header">

</div>
<h2>Forgot Password?</h2>
<div class="formdata3">
<div align="center">
<form onsubmit="return validate()" action="getpwd2" method="post" >
<table>
<tr>
<td>UserID:</td>
<td><input name="uid" id="uid" type="text"/>
</tr>

</table>
<input type="submit" value ="submit" class="formsubmitbutton"/>

</form>
<br><br>
${message }
<br><br>
Want to login?<a href="supportanalystlogin">Click here</a>

</div>
</div>


<%RequestDispatcher
rd=request.getRequestDispatcher("forpass1");
rd.include(request,response);%>
</body>
</html>