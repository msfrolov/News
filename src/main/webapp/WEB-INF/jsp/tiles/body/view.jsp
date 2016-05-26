<%@ taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<h2>View news</h2>
<h4>News ID</h4>
<div style="text-align: left;">
    <b:write name="newsForm" property="news.idString"/>
</div>
<h4>News Title</h4>
<div style="text-align: left;">
    <b:write name="newsForm" property="news.title"/>
</div>
<h4>News Date</h4>
<div style="text-align: left;">
    <b:write name="newsForm" property="news.dateFormat"/>
</div>
<h4>News brief</h4>
<div style="text-align: left;">
    <b:write name="newsForm" property="news.brief"/>
</div>
<h4>News content</h4>
<div style="text-align: left;">
    <b:write name="newsForm" property="news.content"/>
</div>
