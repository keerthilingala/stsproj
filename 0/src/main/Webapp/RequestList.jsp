<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserRegistrations</title>
<link rel="stylesheet" type="text/css" href="/style.css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<div align="center">
<div style="text-align:center">
<h2>UserRequests</h2>

<div align="center">
<table border="2" class="t1">

<tr>
<td>AdminId</td>
<td>FirstName</td>
<td>LastName</td>
<td>Gender</td>
<td>ContactNumber</td>
<td>Status</td>
<td>Accept</td>
<td>Reject</td>
</tr>
<c:forEach items="${list}" var="admin"> 

<tr>
<td>${admin.getAnalystId()}</td>
<td>${admin.getFirstName()}</td>
<td>${admin.getLastName()}</td>
<td>${admin.getGender()}</td>
<td>${admin.getContactNumber()}</td>
<td>${admin.getStatus()}</td>

<td>
<a href="accept?name=${admin.getAnalystId()}"><button>Accept</button></a></td>
<td>
<a href="reject?name=${admin.getAnalystId()}"><button>Reject</button></a>

</td>
</tr>
</c:forEach>
</table>

</div>
${message}
</div>
<%
RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
rd.include(request,response);
%>
</div>

</body>
</html>