<%--
  Created by IntelliJ IDEA.
  User: imaiwis
  Date: 2021/6/17
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    session.invalidate();
    session.removeAttribute("mess");
    response.sendRedirect(request.getContextPath()+"/page/index1.jsp");
%>
</body>
</html>
