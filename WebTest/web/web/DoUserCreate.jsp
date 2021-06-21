<%--
  Created by IntelliJ IDEA.
  User: imaiwis
  Date: 2021/6/16
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLEncoder" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! int i = 10;%>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String password = request.getParameter("pwd");
%>
用户名：<% if (name != null && !name.equals("")) {
    if (name.equals("admin")) {
        request.setAttribute("mess", "已存在用户名！");
        request.getRequestDispatcher("UserCreate.jsp").forward(request, response);
    } else {
            //重定向无法传回信息，因为不是同一次请求了
//                request.setAttribute("mess","注册成功！");
                 //换作用域保存，或者如下写法
//                response.sendRedirect("index1.jsp?info=success");
               /* //使用session（会话），扩大作用域到整个浏览器与服务器之间的通话
                session.setAttribute("mess","注册成功！");
                response.sendRedirect("index1.jsp");*/
        //如果传递中文提示
        String info = "啊大大";
        info = URLEncoder.encode(info, "utf-8");
        response.sendRedirect(request.getContextPath()+"/page/index1.jsp?info=" + info);


        Cookie cookie = new Cookie("username",name);
        //设置路径(整个项目所有功能都可以访问到这个cookie)
        cookie.setPath("/");
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }
%>
<%=name%>
<%
    } else {
        out.print("请输入用户名！");
    }
%>


密码：<%=password %><br/>

</body>
</html>
