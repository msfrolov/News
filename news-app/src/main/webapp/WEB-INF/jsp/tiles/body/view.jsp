<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .c001 {
        border: 1px solid #000000;
        border-radius: 1px;
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
    <h2><b:message key="body.title.view"/></h2>
    <div class="c001" style="text-align: left;">
        <div class="c002"><b:message key="body.field.title"/>:</div>
        <div class="c003"><b:write name="newsForm" property="news.title"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><b:message key="body.field.date"/>:</div>
        <div class="c003"><b:write name="newsForm" property="news.dateFormat"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><b:message key="body.field.brief"/>:</div>
        <div class="c004"><b:write name="newsForm" property="news.brief"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><b:message key="body.field.content"/>:</div>
        <div class="c004"><b:write name="newsForm" property="news.content"/></div>
    </div>
    <b:define id="news" name="newsForm"/>
    <h:submit><b:message key="body.button.edit"/></h:submit>
    <h:reset onclick="history.back()"><b:message key="body.button.cancel"/></h:reset>
</h:form>


