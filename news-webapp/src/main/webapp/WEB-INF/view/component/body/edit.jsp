<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    .c003 {
        font-size: 15px;
    }

    .c004 {
        font-size: 15px;
        width: 800px;
    }
</style>
<h2><spring:message code="body.title.edit"/></h2>
<form:form action="edit" modelAttribute="newsItem" method="post">
    <div class="c001" style="text-align: left;">
        <div class="c002"><form:label path="title"><spring:message code="body.field.title"/>:</form:label></div>
        <div class="c003"><form:input path="title"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><form:label path="date"><spring:message code="body.field.date"/>:</form:label></div>
        <div class="c003"><form:input path="date"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><form:label path="date"><spring:message code="body.field.brief"/>:</form:label><</div>
        <div class="c004"><form:input path=""</div>
    </div>
    <%--<div class="c001" style="text-align: left;">--%>
    <%--<div class="c002"><spring:message code="body.field.content"/>:</div>--%>
    <%--<div class="c004"><h:textarea name="newsForm" property="content"/></div>--%>
    <%--</div>--%>
    <input type="submit" value="<spring:message code='body.button.save'/>">
    <input type="button" value="<spring:message code='body.button.cancel'/>"
           onclick="javascript:document.location.href='<c:out value="list"/>'"/>
</form:form>