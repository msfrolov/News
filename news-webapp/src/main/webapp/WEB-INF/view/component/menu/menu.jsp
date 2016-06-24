<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<style>
    .menu-main {
        background-color: lightgray
    }

    .menu-navigation {
        background-color: darkgray;
        font-size: large;
    }
</style>
<div class="menu-main">
    <div class="menu-navigation">
        <h4><spring:message code="menu.navigation"/></h4>
    </div>
    <br/>
    <a href="list"><spring:message code="menu.list"/></a>
    <br/>
    <a href="add"><spring:message code="menu.add"/></a>
    <br/>
</div>