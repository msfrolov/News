<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<style>
    .c001add {
        border: 1px solid #000000;
        border-radius: 1px;
        margin: 1px 0;
        padding: 1%;
    }

    .c002add {
        font-size: 17px;
    }

    .c003add {
        font-size: 15px;
    }

    .c004add {
        font-size: 15px;
        width: 800px;
    }
</style>
<h2><spring:message code="body.title.add"/></h2>
<form:form action="add" modelAttribute="newsItem" method="post">
    <div class="c001" style="text-align: left;">
        <div class="c002"><form:label path="title"><spring:message code="body.field.title"/>:</form:label></div>
        <div class="c003"><form:input path="title"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><form:label path="date"><spring:message code="body.field.date"/>:</form:label></div>
        <spring:message code="date.format" var="datePattern" scope="page"/>
        <f:formatDate value="${newsItem.date}" pattern="${datePattern}" var="dateFormatter"/>
        <div class="c003"><form:input path="date" value="${dateFormatter}"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><form:label path="brief"><spring:message code="body.field.brief"/>:</form:label></div>
        <div class="c004"><form:input path="brief"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><form:label path="content"><spring:message code="body.field.content"/>:</form:label></div>
        <div class="c004"><form:input path="content"/></div>
    </div>
    <c:if test="${not empty message}">
        <div>
            <label style="text-decoration-color: green" for="button-submit"><spring:message code="${message}"/></label>
        </div>
    </c:if>
    <input id="button-submit" type="submit" value="<spring:message code='body.button.save'/>">
    <input type="button" value="<spring:message code='body.button.cancel'/>"
           onclick="javascript:document.location.href='<c:out value="list"/>'"/>
</form:form>