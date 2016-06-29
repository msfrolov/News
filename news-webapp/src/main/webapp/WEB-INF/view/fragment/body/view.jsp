<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<style>
    .c001view {
        border: 1px solid #000000;
        border-radius: 1px;
        margin: 1px 0;
        padding: 1%;
    }

    .c002view {
        font-size: 17px;
    }

    .c003view {
        font-size: 15px;
    }

    .c004view {
        font-size: 15px;
        width: 800px;
        height: auto;
    }
</style>
<form:form action="edit" method="GET">
    <h2><spring:message code="body.title.view"/></h2>
    <div class="c001view" style="text-align: left;">
        <div class="c002view"><spring:message code="body.field.title"/>:</div>
        <div class="c003view">${newsItem.title}</div>
    </div>
    <div class="c001view" style="text-align: left;">
        <div class="c002view"><spring:message code="body.field.date"/>:</div>
        <spring:message code="date.format" var="datePattern" scope="page"/>
        <f:formatDate value="${newsItem.date}" pattern="${datePattern}"/>
    </div>
    <div class="c001view" style="text-align: left;">
        <div class="c002view"><spring:message code="body.field.brief"/>:</div>
        <div class="c004view">${newsItem.brief}</div>
    </div>
    <div class="c001view" style="text-align: left;">
        <div class="c002view"><spring:message code="body.field.content"/>:</div>
        <div class="c004view">${newsItem.content}</div>
    </div>
    <input type="hidden" value="${newsItem.id}" name="id"/>
    <c:if test="${not empty message}">
        <div>
            <label style="text-decoration-color: green"><spring:message code="${message}"/></label>
        </div>
    </c:if>
    <input type="submit" value="<spring:message code='body.button.edit'/>">
    <input type="button" value="<spring:message code='body.button.cancel'/>"
           onclick="javascript:document.location.href='<c:out value="list"/>'"/>
</form:form>


