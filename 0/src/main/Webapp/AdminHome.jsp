<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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

<div align="right">
 
  
     
    <a  href="req">RequestList</a>
   
    
    <a  href="feedbkcustomers">Feedbacks</a>
    <a  href="adminLogout">Logout</a>
    
  </div>
 
</div>
 </div>
 
</div>
</div>
    </div>
    
<div align="center"><br>
 <span class="userloginmessage">Hlo :) , <br><%=userid%></span>



</body>
</html>


    


    