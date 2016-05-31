<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div style="background-color : lightgray; widht:100%; height:120px;">
    <h1><b:message key="header.title"/></h1>
    <div align="right">
        <b:message key="header.language"/>
        <h:link action="/locale?method=english">English</h:link>
        <h:link action="/locale?method=russian">Русский</h:link>
    </div>
</div>
