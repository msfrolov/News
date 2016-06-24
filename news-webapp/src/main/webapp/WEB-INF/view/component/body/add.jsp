<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<link href="<c:out value='/css/style.css'/>" rel="stylesheet">--%>
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
<form:form action="save">
    <div class="c001add">
        <div class="c002add"><spring:message code="body.field.title"/>:</div>
        <form:input styleClass="c003add" path="${newsItem.title}"/>
        <div class="c002add"><spring:message code="body.field.date"/>:</div>
        <form:input styleClass="c003add" path="${newsItem.date}"/>
        <div class="c002add"><spring:message code="body.field.brief"/>:</div>
        <form:textarea styleClass="c004add" path="${newsItem.brief}"/>
        <div class="c002add"><spring:message code="body.field.content"/>:</div>
        <form:textarea styleClass="c004add" path="${newsItem.content}"/>
    </div>
    <input type="submit" value="<spring:message code='body.button.save'/>">
    <input type="button" value="<spring:message code='body.button.cancel'/>"
           onclick="javascript:document.location.href='<c:out value="list"/>'"/>
</form:form>