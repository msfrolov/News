<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div style="background-color: lightgray">
    <div style="background-color: darkgray; font-size: large;">
        <h4><spring:message code="menu.navigation"/></h4>
    </div>
    <br/>
    <a action="news?method=showNewsList"><spring:message code="menu.list"/></a>
    <br/>
    <a action="news?method=addNews"><spring:message code="menu.add"/></a>
    <br/>
</div>