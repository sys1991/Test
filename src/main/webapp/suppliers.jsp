<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/13
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUPPLIERS PAGE</title>
</head>
<body>
<h1>SUPPLIERS</h1>
<a href="/add.jsp">新加供应商</a>
<table border="1">
    <tr>
        <th>序号</th>
        <th>名称</th>
        <th>地址</th>
        <th>联系人</th>
        <th>主要供应物资</th>
        <th>联系电话</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach var="supplier" items="${sessionScope.suppliers}" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${supplier.name}</td>
            <td>${supplier.address}</td>
            <td>${supplier.people}</td>
            <td>${supplier.goods}</td>
            <td>${supplier.tel}</td>
            <td><a href="/Supplier?action=remove&id=${supplier.id}">删除</a>
            <a href="/Supplier?action=update&id=${supplier.id}">修改</a>
            </td>
        </tr>

    </c:forEach>


</table>


</body>
</html>
