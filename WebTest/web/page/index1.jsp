<%@ page pageEncoding="utf-8" language="java" import="java.util.*" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.io.ObjectOutputStream" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
<%
    //session和application的区别，session是对于浏览器而言，浏览器关闭，session(对话)结束
    //application是对于整个服务而言，服务端关闭，则application 销毁
    //Session属性和application的异同
    //    1、 session和application、request 在配置属性，代码一样的
    //    2、 session对每一个用户（浏览器）是单独的，而application的所有用户（浏览器）是共享的一个的。从使用角度来讲，共享同1个变量会出现资源争夺的冲突。（绝大部分时候都不用application的）
    //    3、 session服务器默认只保存20分钟（可以修改），而application会一直存在，直到tomcat关闭。
%>
<%--<%=request.getParameter("info")%>--%>
<%
    String info = request.getParameter("info");
//    info = URLDecoder.decode(info,"utf-8");
    session.getId();
%>
<%
    String username = "1";
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("username")) {
                username = cookies[i].getValue();
            }
        }
    }
%>
<%
    Object count = application.getAttribute("count");
    if (count == null) {
        //第一次访问该页面，需要创建一个储存访问次数的变量，并放进application
        application.setAttribute("count", 1);
    } else {
        //非第一次访问该页面，取出储存访问次数的变量，+1，并放进application
        Integer i = (Integer) count;
        application.setAttribute("count", i + 1);
    }
    Integer newCount = (Integer) application.getAttribute("count");
    out.print(newCount);
%>
<%=username%>
<a href="loginOut.jsp">注销</a>
<%=info%>
hello world!
</body>
</html>
