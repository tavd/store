<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.store.util.User"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page</title>
</head>
<body>
<%User user = (User) session.getAttribute("User"); %>
<h3>Hi <%=user.getFirstname() %></h3>
<strong>Your Email</strong>: <%=user.getEmail() %><br>
<strong>Your Country</strong>: <%=user.getCountry() %><br>
<br>

<a href="item-list.jsp" title="Item">Item List</a>

<%--<a href="/Item" title="Item">Item List</a>--%>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
${pageContext.request.userPrincipal.name}|</c:if>
<form action="Logout" method="post">
    <a href="login.jsp">Logout</a>
</form>


</body>
</html>