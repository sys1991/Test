<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/13
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD PAGE</title>
</head>
<body>
<form action="/Supplier" method="post">
    <input type="hidden" name="action" value="add">
    <input type="text" name="name" placeholder="供应商"><br>
    <input type="text" name="address" placeholder="地址"><br>
    <input type="text" name="people" placeholder="联系人"><br>
    <input type="text" name="goods" placeholder="供应商名称"><br>
    <input type="text" name="tel" placeholder="联系电话"><br>
    <input type="submit" value="ADD">
</form>
</body>
</html>
