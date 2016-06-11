<%@ taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="t" uri="http://struts.apache.org/tags-tiles" %>
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
    }
</style>
<h2><b:message key="body.title.edit"/></h2>
<h:form action="/news?method=update">
    <div class="c001" style="text-align: left;">
        <div class="c002"><b:message key="body.field.title"/>:</div>
        <div class="c003"><h:text name="newsForm" property="title"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><b:message key="body.field.date"/>:</div>
        <div class="c003"><h:text name="newsForm" property="date"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><b:message key="body.field.brief"/>:</div>
        <div class="c004"><h:textarea name="newsForm" property="brief"/></div>
    </div>
    <div class="c001" style="text-align: left;">
        <div class="c002"><b:message key="body.field.content"/>:</div>
        <div class="c004"><h:textarea name="newsForm" property="content"/></div>
    </div>
    <h:submit><b:message key="body.button.save"/></h:submit>
    <h:reset onclick="history.back()"><b:message key="body.button.cancel"/></h:reset>
</h:form>