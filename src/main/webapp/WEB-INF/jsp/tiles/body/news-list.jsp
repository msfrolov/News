<%@taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="l" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="t" uri="http://struts.apache.org/tags-tiles" %>
<%@ taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<h2>News list</h2>
<h:form action="/news?method=delete">
    <table style="height:50px; border: 1px solid dimgray;border-collapse: collapse" border="1">
        <l:iterate id="news" property="newsList" name="newsForm">
            <tr>
                <td>
                    <div style="text-align: left;">
                        <b:write name="news" property="title"/>
                    </div>
                    <div style="text-align: right;">
                        <b:write name="news" property="dateFormat"/>
                    </div>
                    <div style="text-align: left;">
                        <b:write name="news" property="brief"/>
                    </div>
                    <h:link action="/news?method=viewNews">
                        <h:param name="idNews" value="${news.id}"/>VIEW</h:link>
                    <h:link action="/news?method=editNews">
                        <h:param name="idNews" value="${news.id}"/>EDIT</h:link>
                    <h:multibox property="idArray" value="${news.id}">SELECT</h:multibox>
                </td>
            </tr>
        </l:iterate>
    </table>
    <h:submit>
        DELETE
    </h:submit>
</h:form>


