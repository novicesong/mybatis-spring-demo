<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>测试</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel='shortcut icon' href="<%= request.getContextPath() + "/images/favicon.png" %>" />
	<link rel="stylesheet" href="<%= request.getContextPath() + "/css/login.css" %>" type="text/css">
	<script src="<%= request.getContextPath() + "/js/jquery-1.7.2.min.js" %>" type="text/javascript"></script>
	<script src="<%=request.getContextPath() + "/js/jquery/jquery.json-2.2.min.js"%>" type="text/javascript"></script>
	<script src="../js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="../js/jquery/jquery.json-2.2.min.js" type="text/javascript"></script>
  </head>
  <body>
   <jsp:include page="common/header.jsp" ></jsp:include>
    ${user.userName}
   <jsp:include page="common/footer.jsp" ></jsp:include>
  </body>
</html>
