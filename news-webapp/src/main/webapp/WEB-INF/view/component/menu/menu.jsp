<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div style="background-color: lightgray">
    <div style="background-color: darkgray; font-size: large;">
        <h4><fmt:message key="menu.navigation"/></h4>
    </div>
    <br/>
    <a action="news?method=showNewsList"><fmt:message key="menu.list"/></a>
    <br/>
    <a action="news?method=addNews"><fmt:message key="menu.add"/></a>
    <br/>
</div>