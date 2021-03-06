<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%> --%>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="plugins" value="${ctx}/static/plugins"/>
<c:set var="admin" value="${ctx}/static/admin"/>
<c:set var="portal" value="${ctx}/static/portal"/>
<c:set var="portal_default" value="${ctx}/static/portal/default"/>