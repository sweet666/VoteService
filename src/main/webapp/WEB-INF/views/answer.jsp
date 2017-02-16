<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">

	<!-- Compiled and minified CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">

    <title><spring:message code="label.vote" /></title>
</head>
<body>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>

<div class="container">

	<div class="row">

    <h3 align="center">${vote.name}</h3>

		<div class="col s12 m4 l2"></div>
		<div class="col s12 m4 l8">


        <table class="bordered">
        <tr>
            <th>${vote.first_option}</th>
            <th>${vote.second_option}</th>
            <th>&nbsp;</th>
        </tr>
        <tr>
            <th>${vote.first_counter}</th>
            <th>${vote.second_counter}</th>
            <th>&nbsp;</th>
        </tr>
        <tr>
			<td><a href="/1/${vote.id}" class="waves-effect waves-light btn"><spring:message code="label.answer" /></a></td>
			<td><a href="/2/${vote.id}" class="waves-effect waves-light btn"><spring:message code="label.answer" /></a></td>
        </tr>
</table>

		</div>
	</div>
</div>

</body>
</html>