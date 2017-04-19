<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h1><spring:message code="index.name"/></h1>
<ul>
    <li><spring:message code="language"/> : <a href="?lang=en">EN</a>|<a href="?lang=ru">RU</a></li>
    <li><a href="/book/1/5/name"><spring:message code="index.link.review"/></a></li>
    <li><a href="/add"><spring:message code="index.link.add"/></a></li>
</ul>
</body>
</html>
