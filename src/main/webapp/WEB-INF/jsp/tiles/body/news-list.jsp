<%@taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="l" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="t" uri="http://struts.apache.org/tags-tiles" %>
<%@ taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .c000 {
        border: 1px solid #000000; /* Белая рамка */
        border-radius: 1px; /* Радиус скругления */
        margin: 1px 0;
        padding: 1%;
    }

    .c001 {
        border: 1px solid gainsboro; /* Белая рамка */
        border-radius: 1px; /* Радиус скругления */
        margin: 1px 0;
        padding: 6px;
    }

    .c002 {
        font-size: 17px;
    }

    .c003 {
        font-size: 15px;
    }
</style>
<h2>News list</h2>
<h:form action="/news?method=delete">
    <l:iterate id="news" property="newsList" name="newsForm">
        <div class="c000">
            <div class="c001" style="text-align: left;">
                <div class="c002">Title:</div>
                <div class="c003"><b:write name="news" property="title"/></div>
            </div>
            <div class="c001" style="text-align: left;">
                <div class="c002">Date:</div>
                <div class="c003"><b:write name="news" property="dateFormat"/></div>
            </div>
            <div class="c001" style="text-align: left;">
                <div class="c002">Brief:</div>
                <div class="c003"><b:write name="news" property="brief"/></div>
            </div>
            <h:link action="/news?method=viewNews">
                <h:param name="idNews" value="${news.id}"/>VIEW</h:link>
            <h:link action="/news?method=editNews">
                <h:param name="idNews" value="${news.id}"/>EDIT</h:link>
            <h:multibox property="idArray" value="${news.id}">SELECT</h:multibox>
        </div>
    </l:iterate>
    <h:submit>
        DELETE
    </h:submit>
</h:form>


