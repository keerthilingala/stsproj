<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<div class="container-fluid">
<div class="row mainheader">
<div class="col-sm text-nowrap">

</div>
</div>
</div>
<script type="text/javascript">
function validate(){
	var sname=document.getElementById("saname").value;

		
		else if(sname=="")
			{
			document.getElementById("saname").style.borderColor = "red";
			alert("please update contact number field");
				return false;
			
			}
}
</script>

</head>

<body>
<div class="header"/>

</div>
<h2>Customer Feedback</h2>
<div align="center">
<form:form onsubmit="return validate()" action="feedbackques" modelAttribute="feedbk" method="post">
<table border="2">

<form:input path="saname" id="saname" readonly="true"></form:input>
<tr>
<td>Questions</td><td>Agree</td><td>Disagree</td><td>StronglyAgree</td><td>StronglyDisagree</td><td>NeitherNorAgree</td></tr><tr>
<td>Information on the website is clear and easy to understand:</td>
<td><form:radiobutton path="ans1" value="agree" id="ans1" /></td>
<td>
<form:radiobutton path="ans1" value="disagree" id="ans1" /></td>
<td>
<form:radiobutton path="ans1" value="Stronglyagree" id="ans1" /></td>
<td>
<form:radiobutton path="ans1" value="Stronglydisagree" id="ans1" /></td>
<td>
<form:radiobutton path="ans1" value="Neithernoragree" id="ans1" /></td>
</tr>
<tr>
<td>Responses and services from analyst and admin:</td>
<td><form:radiobutton path="ans2" value="agree" id="ans2" /></td>
<td>
<form:radiobutton path="ans2" value="disagree" id="ans2" /></td>
<td>
<form:radiobutton path="ans2" value="Stronglyagree" id="ans2" /></td>
<td>
<form:radiobutton path="ans2" value="Stronglydisagree" id="ans2" /></td>
<td>
<form:radiobutton path="ans2" value="Neithernoragree" id="ans2" /></td>
</tr>
<tr>
<td>Any other feedbacks</td>
<td colspan="5"><form:textarea path="description" cols="70" rows="5"></form:textarea></td>
</tr>
</table>

</div>
<br>
<br>
<tr>
<div align="center">
<input type="submit" value ="submit"/>
<a href="SupportAnalystHome.jsp" >UserHome</a>
</form:form>
</div>
<br><br>
${message }
<%
RequestDispatcher rd=request.getRequestDispatcher("SupportAnalystHome.jsp");
rd.include(request,response);
%>
</body>
</html>