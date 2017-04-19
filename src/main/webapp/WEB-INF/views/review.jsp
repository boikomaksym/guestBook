<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:url var="firstUrl" value="/book/1/${pages.size}/${order}"/>
<c:url var="lastUrl" value="/book/${pages.totalPages}/${pages.size}/${order}"/>
<c:url var="prevUrl" value="/book/${currentIndex - 1}/${pages.size}/${order}"/>
<c:url var="nextUrl" value="/book/${currentIndex + 1}/${pages.size}/${order}"/>
<html>
<body>
<style>
    th {
        background: #a8a5b4;
        color: white;
    }

    td, th {
        border: 1px solid gray;

        text-align: left;
        padding: 1px 1px;
    }
</style>
<spring:message code="language"/> : <a href="?lang=en">EN</a>|<a href="?lang=ru">RU</a>
</br>
<a href="/add"><spring:message code="index.link.add"/></a>
<ul>
    <spring:message code="book.records"/>:
    <a href="/book/1/5/${order}">5</a>
    <a href="/book/1/10/${order}">10</a>
    <a href="/book/1/50/${order}">50</a>
    <a href="/book/1/${pages.totalElements}/${order}"><spring:message code="book.allRecords"/></a>
</ul>
<div>

    <table>
        <tr>
            <th width="120"><spring:message code="title"/></th>
            <th width="400"><spring:message code="body"/></th>
            <th width="120"><a href="/book/${currentIndex}/${pages.size}/date"><spring:message code="date"/></a></th>
            <th width="120"><a href="/book/${currentIndex}/${pages.size}/name"><spring:message code="name"/></a></th>
            <th width="120"><a href="/book/${currentIndex}/${pages.size}/rating"><spring:message code="rating"/></a>
            </th>
        </tr>

        <c:forEach items="${reviews}" var="review">
            <tr>
                <td>${review.title} </td>
                <td>${review.body}</td>
                <td>${review.date}</td>
                <td>${review.name}</td>
                <td>
                    <a href="/rating?id=${review.id}">&#9650;</a>
                    <a href="/rating?id=${review.id}&down">&#9660;</a>
                        ${review.rating}
                </td>
            </tr>
        </c:forEach>
    </table>
    <ul>
        <c:choose>
            <c:when test="${currentIndex == 1}">
                <a href="#">&lt;&lt;</a>
                <a href="#">&lt;</a>
            </c:when>
            <c:otherwise>
                <a href="${firstUrl}">&lt;&lt;</a>
                <a href="${prevUrl}">&lt;</a>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/book/${i}/${pages.size}/${order}"/>
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <a href="${pageUrl}"><c:out value="${i}"/></a>
                </c:when>
                <c:otherwise>
                    <a href="${pageUrl}"><c:out value="${i}"/></a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${currentIndex == pages.totalPages}">
                <a href="#">&gt;</a>
                <a href="#">&gt;&gt;</a>
            </c:when>
            <c:otherwise>
                <a href="${nextUrl}">&gt;</a>
                <a href="${lastUrl}">&gt;&gt;</a>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
</body>
</html>
