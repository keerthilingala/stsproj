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
	var pwd=document.getElementById("password").value;
	 if(pwd==" "){
			document.getElementById("password").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
	 var pwd1=document.getElementById("Conformpassword").value;
	 if(pwd1!=pwd){
			document.getElementById("Conformpassword").style.borderColor = "red";
			alert("password and conform password are not same");
				return false;
			}
}

</script>
</head>
<body>
<div class="header">

</div>
<h2>Reset password</h2>
<div class="formdata">
<div align="center">
<form:form onsubmit="return validate()" action="updatepwd" method="post" modelAttribute="name1">
<table>
<tr>
<tr>
<td>
<form:hidden path="uid"/>
</td>
</tr>
<tr>
<td>Password:</td>
<td><form:input path="pwd" class="formcontrol" id="pwd" type="password"/></td>
</tr>
<tr>
<td>ConformPassword:</td>
<td><form:input path="pwd1" class="formcontrol" id="pwd1" type="password"/></td>
</tr>
</table>
<input type="submit" value="submit" class="formsubmitbutton"/>
</form:form>
Want to login?<a href="adminlogin">Click here</a>
<br>
<br>
${message}
</div>
</div>
</body>
</html>