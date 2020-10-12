<%--
  Created by IntelliJ IDEA.
  User: 91145
  Date: 2020/8/27
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>进货记录列表</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; ">
        <li>进货管理</li>
        <li>进货记录</li>
        <li>记录列表</li>
    </ul>
</div>
<div class="row alert alert-info" style="margin:0px; padding:3px;">
    <form class="form-inline" action="/purchase.do?action=fuzzy" method="post">
        <div class="form-group">
            <label class="" for="activename">商品名称：</label>
            <input type="text" name="kw" class="form-control" id="activename" placeholder="请输入商品名称">
        </div>
        <input type="submit" class="btn btn-danger" value="查询"/>
    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
    <table class="table  table-condensed table-striped">
        <tr>
            <th>进货批号</th>
            <th>供应商</th>
            <th>商品条码</th>
            <th>品类</th>
            <th>商品名称</th>
            <th>进货单价(元)</th>
            <th>进货数量</th>
            <th>进货金额</th>
            <th>保质期限</th>
        </tr>
        <c:forEach items="${product}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.supplier_name}</td>
            <td>${p.bar_code}</td>
            <td>${p.category_name}</td>
            <td>${p.product_name}</td>
            <td>${p.purchase_price}</td>
            <td>${p.count}</td>
            <td>${p.amount}</td>
            <td>${p.exp_date}</td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
