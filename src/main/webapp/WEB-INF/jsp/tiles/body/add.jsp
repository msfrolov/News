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
<h:form action="/news?method=save">
    <div class="c001">
        <div class="c002">Title:</div>
        <h:text styleClass="c003" name="newsForm" property="news.title"/>
        <div class="c002">Date:</div>
        <b:define id="news" name="newsForm"/>
        <h:text styleClass="c003" name="news" property="date"/>
        <div class="c002">Brief:</div>
        <h:textarea styleClass="c004" name="newsForm" property="news.brief"/>
        <div class="c002">Content:</div>
        <h:textarea styleClass="c004" name="newsForm" property="news.content"/>
    </div>
    <h:submit value="SAVE"/>
    <h:reset onclick="history.back()" value="CANCEL"/>
</h:form>