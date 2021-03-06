<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%--<link href="<c:out value='/css/style.css'/>" rel="stylesheet">--%>
<%--<spring:url value="/WEB-INF/css/style.css" var="style"/>--%>
<%--<link href="${style}" rel="stylesheet"/>--%>
<style>
    .c000newslist {
        border: 1px solid #000000;
        border-radius: 1px;
        margin: 1px 0;
        padding: 1%;
    }

    .c001newslist {
        border: 1px solid gainsboro;
        border-radius: 1px;
        margin: 1px 0;
        padding: 6px;
    }

    .c002newslist {
        font-size: 17px;
    }

    .c003newslist {
        font-size: 15px;
    }
</style>
<%--<f:setLocale value="${sessionScope.}"/>--%>
<h2><spring:message code="body.title.list"/></h2>
<form:form action="delete" modelAttribute="ids">
    <c:forEach items="${newsList}" var="newsDTO">
        <div class="c000newslist">
            <div class="c001newslist" style="text-align: left;">
                <div class="c002newslist"><spring:message code="body.field.title"/>:</div>
                <div class="c003newslist">${newsDTO.title}</div>
            </div>
            <div class="c001newslist" style="text-align: left;">
                <div class="c002newslist"><spring:message code="body.field.date"/>:</div>
                <div class="c003newslist">
                    <spring:message code="date.format" var="datePattern" scope="page"/>
                    <f:formatDate value="${newsDTO.date}" pattern="${datePattern}"/>
                </div>
            </div>
            <div class="c001newslist" style="text-align: left;">
                <div class="c002newslist"><spring:message code="body.field.brief"/>:</div>
                <div class="c003newslist">${newsDTO.brief}</div>
            </div>
            <a href="view?id=${newsDTO.id}"><spring:message code="body.button.view"/></a>
            <a href="edit?id=${newsDTO.id}"><spring:message code="body.button.edit"/></a>
            <form:checkbox value="${newsDTO.id}" path="ids"/><spring:message code="body.checkbox.select"/>
        </div>
    </c:forEach>
    <input type="submit" value="<spring:message code='body.button.delete'/>"/>
</form:form>





