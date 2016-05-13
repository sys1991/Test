<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/13
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <form action="/user" method="post">
  用户名：<input type="text" name="username" placeholder="用户名">
  密码：<input type="password" name="password" placeholder="密码">
    <input type="submit" value="登陆">
  </form>
  </body>
</html>
