<%@ page language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="t" %>
<html>
<head>
    <title><t:getAsString name="title" ignore="true"/></title>
</head>
<body>
<table border="0" width="100%">
    <tr>
        <td colspan="2" valign="top">
            <t:insert attribute="header"/>
        </td>
    </tr>
    <tr valign="top">
        <td height="200" width="20%">
            <t:insert attribute="menu"/>
        </td>
        <td width="80%">
            <t:insert attribute="body"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" valign="top">
            <t:insert attribute="bottom"/>
        </td>
    </tr>
</table>
</body>
</html>