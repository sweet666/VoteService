<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">

	<!-- Compiled and minified CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">

	<title><spring:message code="label.title" /></title>
</head>
<body>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>



<div class="container">

	<a href="<c:url value="/vote" />">
		<spring:message code="label.votes" />
	</a><br/>
	<div class="row">
		<div class="col s12 m4 l2"></div>
		<div class="col s12 m4 l8">

<c:if test="${not empty param.error}">
	<font color="red"> <spring:message code="label.loginerror" />
	: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check" />">
<table>
	<tr>
		<td align="right"><spring:message code="label.login" /></td>
		<td><input type="text" name="j_username" /></td>
	</tr>
	<tr>
		<td align="right"><spring:message code="label.password" /></td>
		<td><input type="password" name="j_password" /></td>
	</tr>
	<tr>
		<td><input type="checkbox" id="test5" name="_spring_security_remember_me" />
		<label for="test5"><spring:message code="label.remember" /></label>
		</td>
	</tr>
	<tr>
		<td>
		<button class="btn waves-effect waves-light" type="submit" value="Login">Login</button>
		<button class="btn waves-effect waves-light" type="reset" value="Reset">Reset</button>
		</td>
	</tr>
</table>
</form>
	</div>
</div>
</div>
</body>
</html>