<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div style="background-color: lightgray">
    <div style="background-color: darkgray; font-size: large;">
        <h4><b:message key="menu.navigation"/></h4>
    </div>
    <br/>
    <h:link action="news?method=showNewsList"><b:message key="menu.list"/></h:link>
    <br/>
    <h:link action="news?method=addNews"><b:message key="menu.add"/></h:link>
    <br/>
</div>