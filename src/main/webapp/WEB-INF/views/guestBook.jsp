<%--
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<html>
<head>
<style>
	.blue-button{
		background: #25A6E1;
		filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
		padding:3px 5px;
		color:#fff;
		font-family:'Helvetica Neue',sans-serif;
		font-size:12px;
		border-radius:2px;
		-moz-border-radius:2px;
		-webkit-border-radius:4px;
		border:1px solid #1A87B9
	}
	table {
		font-family: "Helvetica Neue", Helvetica, sans-serif;
		width: 50%;
	}
	th {
		background: SteelBlue;
		color: white;
	}
	td,th{
		border: 1px solid gray;
		width: 25%;
		text-align: left;
		padding: 5px 10px;
	}
</style>
</head>
<body>

<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST" action="/add" modelAttribute="review">
	<table>
		<tr>
			<td><form:label path="title">title</form:label></td>
			<td><form:input path="title"/></td>
		</tr>
		<tr>
			<td><form:label path="body">body</form:label></td>
			<td><form:input path="body"/></td>
		</tr>
		<tr>
			<td><form:label path="name">name</form:label></td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td><form:label path="rating">rating</form:label></td>
			<td><form:input path="rating"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"/></td>
		</tr>
	</table>
</form:form>

<h3>Review List</h3>
<c:if test="${!empty listReviews}">
	<table class="tg">
	<tr>
		<th width="80">Title</th>
		<th width="120">Body</th>
		<th width="60">Name</th>
		<th width="60">Rating</th>
		<th width="120">Date</th>
	</tr>
	<c:forEach items="${listReviews}" var="review">
		<tr>
			<td>${review.title}</td>
			<td>${review.body}</td>
			<td>${review.name}</td>
			<td>${review.rating}</td>
			<td>${review.date}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
--%>
