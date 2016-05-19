<%@taglib prefix="t" uri="http://struts.apache.org/tags-tiles" %>
<%@taglib prefix="l" uri="http://struts.apache.org/tags-logic" %>
<%@taglib prefix="b" uri="http://struts.apache.org/tags-bean" %>
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html" %>
<h2>Book List</h2>
<h:form action="/news" >
    <%--<h:text property="newsList"/>--%>
    <l:present name="newsList">
        <table style="height:50px; border: 1px solid dimgray;border-collapse: collapse" border="1">
            <l:iterate id="news" name="${}">
                <tr>
                    <td>
                        <label style="text-align: left;"><b:write name="news" property="title"/></label>
                        <label style="text-align: right;"><b:write name="news" property="date"/></label>
                        <label><b:write name="news" property="brief"/></label>
                    </td>
                </tr>
            </l:iterate>
        </table>
    </l:present>
</h:form>

