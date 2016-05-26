<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .c001 {
        border: 1px solid #000000; /* Белая рамка */
        border-radius: 1px; /* Радиус скругления */
        margin: 1px 0;
        padding: 1%;
    }

    .c002 {
        font-size: 17px;
    }

    .c003 {
        font-size: 15px;
    }

    .c004 {
        font-size: 15px;
        width: 800px;
        height: auto;
    }
</style>
<h:form action="/news?method=editNews&idNews=${newsForm.news.id}">
    <h2>View news</h2>
    <div class="c001" style="text-align: left;">
        <div class="c002">ID:</div>
        <div class="c003"><b:write name="newsForm" property="news.idString"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002">Title:</div>
        <div class="c003"><b:write name="newsForm" property="news.title"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002">Date:</div>
        <div class="c003"><b:write name="newsForm" property="news.dateFormat"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002">Brief:</div>
        <div class="c004"><b:write name="newsForm" property="news.brief"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002">Content:</div>
        <div class="c004"><b:write name="newsForm" property="news.content"/></div>
    </div>
    <b:define id="news" name="newsForm"/>
    <h:submit value="EDIT"/>
    <h:reset onclick="history.back()" value="CANCEL"/>
</h:form>


