<%@taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="l" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="t" uri="http://struts.apache.org/tags-tiles" %>
<%@ taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<style>
    .c000 {
        border: 1px solid #000000;
        border-radius: 1px;
        margin: 1px 0;
        padding: 1%;
    }

    .c001 {
        border: 1px solid gainsboro;
        border-radius: 1px;
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
<h2><b:message key="body.title.list"/></h2>
<h:form action="/news?method=delete">
    <l:iterate id="newsItem" property="newsList" name="newsForm">
        <div class="c000">
            <div class="c001" style="text-align: left;">
                <div class="c002"><b:message key="body.field.title"/>:</div>
                <div class="c003"><b:write name="newsItem" property="title"/></div>
            </div>
            <div class="c001" style="text-align: left;">
                <div class="c002"><b:message key="body.field.date"/>:</div>
                <div class="c003"><b:write name="newsItem" property="date" formatKey="date.format"/></div>
            </div>
            <div class="c001" style="text-align: left;">
                <div class="c002"><b:message key="body.field.brief"/>:</div>
                <div class="c003"><b:write name="newsItem" property="brief"/></div>
            </div>
            <h:link action="/news?method=viewNews">
                <h:param name="idNews" value="${newsItem.id}"/><b:message key="body.button.view"/></h:link>
            <h:link action="/news?method=editNews">
                <h:param name="idNews" value="${newsItem.id}"/><b:message key="body.button.edit"/></h:link>
            <h:multibox property="idArray" value="${newsItem.id}"/>
        </div>
    </l:iterate>
    <h:submit>
        <b:message key="body.button.delete"/>
    </h:submit>
</h:form>


