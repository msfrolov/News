<%@ page language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title" ignore="true"/></title>
</head>
<body>
<table border="0" width="100%">
    <tr>
        <td colspan="2" valign="top">
            <tiles:insert attribute="header"/>
        </td>
    </tr>
    <tr valign="top">
        <td height="200" width="20%">
            <tiles:insert attribute="menu"/>
        </td>
        <td width="80%">
            <tiles:insert attribute="body"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" valign="top">
            <tiles:insert attribute="bottom"/>
        </td>
    </tr>
</table>
</body>
</html>