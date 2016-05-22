<%@taglib prefix="t" uri="http://struts.apache.org/tags-tiles" %>
<%@taglib prefix="l" uri="http://struts.apache.org/tags-logic" %>
<%@taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<h2>News list</h2>
<h:form action="/news?method=delete">
    <table style="height:50px; border: 1px solid dimgray;border-collapse: collapse" border="1">
        <l:iterate id="news" property="newsList" name="newsForm">
            <tr>
                <td>
                    <%--<div style="text-align: left;">--%>
                        <%--<b:write name="news" property="id" ></b:write>--%>
                    <%--</div>    --%>
                     <div style="text-align: left;">${news.id}</div>
                    <div style="text-align: left;">
                        <b:write name="news" property="title"></b:write>
                    </div>
                    <div style="text-align: right;">
                        <b:write name="news" property="date"></b:write>
                    </div>
                    <div style="text-align: left;">
                        <b:write name="news" property="brief"></b:write>
                    </div>
                    <h:link action="/news?method=viewNews">
                        <h:param name="idNews" value="${news.id}"/>VIEW</h:link>
                    <h:link action="/news?method=editNews">
                        <h:param name="idNews" value="${news.id}"/>EDIT</h:link>
                    <h:multibox property="idList" value="${news.id}">SELECT</h:multibox>
                </td>
            </tr>
        </l:iterate>
    </table>
    <h:submit>
        DELETE
    </h:submit>
</h:form>


