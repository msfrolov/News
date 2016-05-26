<%@ taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="t" uri="http://struts.apache.org/tags-tiles" %>
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
    }
</style>
<h2><t:getAsString name='title' ignore='true'/></h2>
<h:form action="/news?method=update">
    <div class="c001" style="text-align: left;">
        <div class="c002">Title:</div>
        <div class="c003"><h:text name="newsForm" property="news.title"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002">Date:</div>
        <div class="c003"><h:text name="newsForm" property="news.dateFormat"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002">Brief:</div>
        <div class="c004"><h:textarea name="newsForm" property="news.brief"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002">Content:</div>
        <div class="c004"><h:textarea name="newsForm" property="news.content"/></div>
    </div>
    <h:submit value="SAVE"/>
    <h:reset onclick="history.back()" value="CANCEL"/>
</h:form>