<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<div style="background-color: lightgray">
    <div style="background-color: darkgray; font-size: large;">
        <h4>Navigation</h4>
    </div>
    <br/>
    <html:link action="news?method=showNewsList">News list</html:link>
    <br/>
    <html:link action="news?method=addNews">Add News</html:link>
    <br/>
</div>