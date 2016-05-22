<%@taglib prefix="t" uri="http://struts.apache.org/tags-tiles" %>
<%@taglib prefix="l" uri="http://struts.apache.org/tags-logic" %>
<%@taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<h2>News list</h2>
<br>
<h:form action="/news?method=delete">
    <table style="height:50px; border: 1px solid dimgray;border-collapse: collapse" border="1">
        <l:iterate id="news" property="newsList" name="newsForm">
            <tr>
                <td>
                    <h:text readonly="true" property="title" name="news" style="text-align: left;"/>
                    <h:text readonly="true" property="date" name="news" style="text-align: right;"/>
                    <h:textarea readonly="true" property="brief" name="news" style="text-align: right;"/>
                    <h:link action="/news?method=viewNews">
                        <h:param name="newForm.idNews" value="news.id"/>
                        <h3>VIEW</h3>
                    </h:link>
                    <h:link action="/news?method=editNews">
                        <h:param name="newForm.idNews" value="news.id"/>
                        <h3>EDIT</h3>
                    </h:link>
                    <h:multibox property="idList">
                        <h3>SELECT</h3>
                    </h:multibox>
                </td>
            </tr>
        </l:iterate>
    </table>
    <h:submit>
        <h3>DELETE</h3>
    </h:submit>
</h:form>


