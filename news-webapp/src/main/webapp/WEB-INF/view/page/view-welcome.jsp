<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:page-components/>
<html>
<head>
    <title>Add news</title>
</head>
<body>
<table border="0" width="100%">
    <tr>
        <td colspan="2" valign="top">
            <c:import url="${comp_header}"/>
        </td>
    </tr>
    <tr valign="top">
        <td height="200" width="20%">
            <c:import url="${comp_menu}"/>
        </td>
        <td width="80%">
            <c:import url="${body_welcome}"/>
        </td>
    </tr>
    <tr>
        <td colspan="2" valign="top">
            <c:import url="${comp_footer}"/>
        </td>
    </tr>
</table>
</body>
</html>