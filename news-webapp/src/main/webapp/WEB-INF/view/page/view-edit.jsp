<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:page-components/>
<html>
<head>
    <title>Edit news</title>
</head>
<body>
<table border="0" width="100%">
    <tr>
        <td colspan="2" valign="top">
            <jsp:include page="#{comp_header}"/>
        </td>
    </tr>
    <tr valign="top">
        <td height="200" width="20%">
            <jsp:include page="#{comp_menu}"/>
        </td>
        <td width="80%">
            <jsp:include page="#{body_edit}"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" valign="top">
            <jsp:include page="#{comp_footer}"/>
        </td>
    </tr>
</table>
</body>
</html>