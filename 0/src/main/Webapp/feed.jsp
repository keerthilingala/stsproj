<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="/style.css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

<c:set var="income" scope="request" value="${sa}"/>
<%
String userid =(String) session.getAttribute("name");
if(userid==null)
{
	response.sendRedirect("/admin/");
}
%>

<div class="container-fluid">
<div class="row mainheader">
<div class="col-sm text-nowrap">

</div>

<div class="col-sm">

 <span class="userloginmessage">hlo :) , <%=userid%></span>

  </div>
</div>
 </div>
 
</div>
</div></div>
<div align="center">
<table border="1">


<tr>

<td>Feedback Id:</td>
<td>Customer Name:</td>
<td>information on the website is clear and easy to understand:</td>
<td>Responses and services from analyst and admin:</td>

<td>Description:</td>
</tr>
<c:forEach items="${feedlist}" var="c">
<tr>
<td> ${c.customerId}</td>
<td> ${c.saname }</td>
<td>${c.ans1}</td>

<td>${c.ans2}</td>
<td>${c.description}</td>

</tr><tr>
</tr>

</c:forEach>
</table>
<a href="AdminHome.jsp" >BACK</a>
<br>
</div></body></html>

