<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tags:page-components-path/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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