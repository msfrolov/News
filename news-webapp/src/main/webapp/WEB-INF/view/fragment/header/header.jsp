<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div style="background-color : lightgray; widht:100%; height:120px;">
    <h1><spring:message code="header.title"/></h1>
    <div align="right">
        <spring:message code="header.language"/>
        <a href="?lang=en">English</a>
        <a href="?lang=ru">Русский</a>
    </div>
</div>