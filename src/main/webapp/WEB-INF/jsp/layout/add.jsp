<%@taglib prefix="t" uri="http://struts.apache.org/tags-tiles" %>
<%@taglib prefix="l" uri="http://struts.apache.org/tags-logic" %>
<%@taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<h2>Add news</h2>
<h:form action="/news?method=save">
    <h4>News Title</h4>
    <h:text name="newsForm" property="news.title"></h:text>
    <h4>News Date</h4>
    <h:text name="newsForm" property="news.date"></h:text>
    <h4>News brief</h4>
    <h:textarea name="newsForm" property="news.brief"></h:textarea>
    <h4>News content</h4>
    <h:textarea name="newsForm" property="news.content"></h:textarea>
    <h:submit value="SAVE" />
    <h:reset onclick="history.back()" value="CANCEL"/>
</h:form>