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

<%--<div style="background-color : lightgray; widht:100%; height:120px;">--%>
<%--<h1>News management</h1>--%>
<%--<div style="right: auto">--%>
<%--Select your language :--%>
<%--<a href="changeLocale.do?method=english">English</a>--%>
<%--<a href="changeLocale.do?method=french">French</a>--%>
<%--<a href="changeLocale.do?method=german">German</a>--%>
<%--<a href="changeLocale.do?method=italian">Italian</a>--%>
<%--</div>--%>
<%--</div>--%>


<%--<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>--%>
<%--<div style="background-color : lightgray; widht:100%; height:120px;">--%>
<%--<h1>News management</h1>--%>
<%--<div align="right">--%>
<%--<html:link action="/locale?lang=english">English</html:link>--%>
<%--<html:link action="/locale?lang=russian">Русский</html:link>--%>
<%--</div>--%>
<%--</div>--%>