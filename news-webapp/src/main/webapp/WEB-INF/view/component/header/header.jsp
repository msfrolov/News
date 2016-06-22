<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div style="background-color : lightgray; widht:100%; height:120px;">
    <h1><fmt:message key="header.title"/></h1>
    <div align="right">
        <fmt:message key="header.language"/>
        <a href="/locale?method=english">English</a>
        <a href="/locale?method=russian">Русский</a>
    </div>
</div>