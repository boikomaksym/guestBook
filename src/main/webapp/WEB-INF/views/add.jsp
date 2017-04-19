<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="add.review"/></title>
</head>

<body>
<spring:message code="language"/> : <a href="?lang=en">EN</a>|<a href="?lang=ru">RU</a>

<form:form method="POST" action="/add" modelAttribute="review" commandName="review">
   <%-- <form:errors path="*" element="div"/>--%>
    <table>
        <tr>
            <td><form:label path="title"><spring:message code="title"/></form:label></td>
            <td><form:input path="title"/></td>
            <td><form:errors path="title" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td><form:label path="body"><spring:message code="body"/></form:label></td>
            <td><form:textarea path="body"/></td>
            <td><form:errors path="body" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td><form:label path="name"><spring:message code="name"/></form:label></td>
            <td><form:input path="name" value="Anonymous"/></td>
            <td><form:errors path="name" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="<spring:message code="submit"/>"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
