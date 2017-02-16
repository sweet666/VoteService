<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">

	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css"  media="screen,projection"/>

	<title><spring:message code="label.title" /></title>
</head>
<body>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="resources/js/materialize.min.js"></script>

<div class="container">
<div class="row">

<a  class="waves-effect waves-light btn" href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>
  
<h4 align="center"><spring:message code="label.title" /></h4>

	<div class="col s12 m4 l2"></div>
	<div class="col s12 m4 l8">

<form:form method="post" action="add" commandName="vote">

	<p><form:label path="name">
		<spring:message code="label.name" />
	</form:label>
	<form:input path="name" />
	</p>

	<p><form:label path="first_option">
			<spring:message code="label.first_option" />
		</form:label>
			<form:input path="first_option" />
	</p>

	<p><form:label path="second_option">
			<spring:message code="label.second_option" />
		</form:label>
			<form:input path="second_option" />
	</p>
	<button class="btn waves-effect waves-light" type="submit"><spring:message code="label.addvote"/>
	</button>

</form:form>
	</div>

	<div class="col s12">

<c:if test="${!empty voteList}">
	<h4 align="center"><spring:message code="label.votes" /></h4>

	<table class="bordered">
		<tr>
			<th><spring:message code="label.name" /></th>
			<th><spring:message code="label.first_option" /></th>
			<th><spring:message code="label.second_option" /></th>
			<th><spring:message code="label.is_open" /></th>
			<th><spring:message code="label.link" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${voteList}" var="vote">
			<tr>
				<td>${vote.name}</td>
				<td>${vote.first_option}</td>
				<td>${vote.second_option}</td>
				<td>${vote.is_open}</td>
				<td><a href="vote/${vote.id}"><spring:message code="label.show" /></a></td>
				<td><a href="delete/${vote.id}"><spring:message code="label.delete" /></a></td>
				<td><a href="close/${vote.id}"><spring:message code="label.close" /></a></td>

			</tr>
		</c:forEach>
	</table>
</c:if>
	</div>

		</div>
</div>

</body>
</html>