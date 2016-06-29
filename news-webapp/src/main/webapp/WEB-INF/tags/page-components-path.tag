<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="css_path" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:set var="fragment" scope="request" value="/WEB-INF/view/fragment"/>
<c:set var="body_add" scope="request" value="${fragment}/body/add.jsp"/>
<c:set var="body_view" scope="request" value="${fragment}/body/view.jsp"/>
<c:set var="body_edit" scope="request" value="${fragment}/body/edit.jsp"/>
<c:set var="body_list" scope="request" value="${fragment}/body/news-list.jsp"/>
<c:set var="body_welcome" scope="request" value="${fragment}/body/welcome.jsp"/>
<c:set var="comp_footer" scope="request" value="${fragment}/footer/footer.jsp"/>
<c:set var="comp_header" scope="request" value="${fragment}/header/header.jsp"/>
<c:set var="comp_menu" scope="request" value="${fragment}/menu/menu.jsp"/>
