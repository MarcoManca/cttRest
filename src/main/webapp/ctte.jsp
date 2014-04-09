<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>		
	<h1>Hi, <sec:authentication property="principal.username"/>!</h1>
	<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
</body>
</html>