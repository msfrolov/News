<%@ taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="t" uri="http://struts.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<h2><t:getAsString name='title' ignore='true'/></h2>
<h:form action="/news?method=save" >
    <h4>News Title</h4>
    <h:text name="newsForm" property="news.title"/>
    <h4>News Date</h4>
    <h:text name="newsForm" property="news.dateFormat"/>
    <h4>News brief</h4>
    <h:textarea name="newsForm" property="news.brief"/>
    <h4>News content</h4>
    <h:textarea name="newsForm" property="news.content"/>
    <h:submit value="SAVE"/>
    <h:reset onclick="history.back()" value="CANCEL"/>
</h:form>