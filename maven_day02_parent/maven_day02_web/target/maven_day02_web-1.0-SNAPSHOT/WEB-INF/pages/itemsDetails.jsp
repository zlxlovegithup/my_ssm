<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/11/13
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><!-- 转换日期格式 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>商品信息展示</title>
</head>
<body>
    <form>
        <table width="100%" border="1">
            <tr>
                <td>商品名称</td>
                <td>${item.name}</td>
            </tr>
            <tr>
                <td>商品价格</td>
                <td>${item.price}</td>
            </tr>
            <tr>
                <td>商品生产日期</td>
                <%--<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>--%>
                <td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            </tr>
            <tr>
                <td>商品简介</td>
                <td>${item.detail}</td>
            </tr>
        </table>
    </form>
</body>
</html>
