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
	var qsn1=document.getElementById("qstn1").value;
	var answr1=document.getElementById("ans1").value;
	var qsn2=document.getElementById("qstn2").value;
	var answr2=document.getElementById("ans2").value;
    
	if(qsn1==""){
		document.getElementById("qstn1").style.borderColor = "red";
		alert("please select the first secret question");
		return false;
		}else if(answr==""){
			document.getElementById("ans").style.borderColor = "red";
			alert("please update first answer field");
				return false;
			}
		else if(qsn2==""){
		document.getElementById("qstn2").style.borderColor = "red";
		alert("please select the second secret question");
		return false;
		}else if(answr2==""){
			document.getElementById("ans2").style.borderColor = "red";
			alert("please update second answer field");
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
<form:form onsubmit="return validate()" action="Aforgotpwd1" method="post" modelAttribute="name2">
<table>
<tr>
<td>UserID:</td>
<td>  <form:input path="uid" readonly="true"/></td>
</tr>
<tr>
<td>Secret Question 1:</td>
<td>
<form:input path="qstn1" id="qstn1"  value ="In which month you born?" readonly="true"/>
<%-- <form:select path="qstn1" id="qstn1" class="select-box" >
<option  selected="selected" value="In which month you born ?">In which month you born?</option>
  <option value="What is your favorite movie?">What is your favorite movie?</option>
  <option value="What is your pet name?">What is your pet name?</option>
</form:select>
--%>
</td>
</tr>
<tr>
<td colspan="2" align="right">
<form:input path="ans1" id="ans1" placeholder="Answer" width="170px" />
</td>
</tr>
<tr>
<td>Secret Question 2:</td>
<td>
<form:input path="qstn2" id="qstn2"  value ="What is your favourite place?" readonly="true"/>
<%-- 
<form:select path="qstn2" id="qstn2" class="select-box" >
<option  selected="selected" value="What is your favourite place?">What is your favourite place?</option>
  <option value="What is your favorite food item?">What is your favorite food item?</option>
  <option value="What is your highest education?">What is your highest education?</option>
</form:select>
--%>
</td>
</tr>
<tr>
<td colspan="2" align="right">
<form:input path="ans2" id="ans2" placeholder="Answer" width="170px" />
</td>
</tr>


</table>
<input type="submit" value ="submit" class="formsubmitbutton"/>

</form:form>
<br><br>
${message }
<br><br>
Want to login?<a href="supportanalystlogin">Click here</a>

</div>
</div>


</body>
</html>