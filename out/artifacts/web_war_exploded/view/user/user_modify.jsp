<%--
  Created by IntelliJ IDEA.
  User: 91145
  Date: 2020/8/27
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>模拟销售</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="../../js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding:0px; margin:0px;">
    <ul class="breadcrumb" style="  margin:0px; " >
        <li><a href="#">系统管理</a></li>
        <li>用户管理</li>
        <li>用户详情</li>
    </ul>
</div>
<form action="/user.do?action=modify" class="form-horizontal" method="post">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户编号</label>
                <div class="col-sm-9">
                    <input type="text" name="id" value="${user.id}" class="form-control input-sm"  />

                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">用户姓名</label>
                <div class="col-sm-9">
                    <input type="text" name="userName" value="${user.user_name}" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">登陆账号</label>
                <div class="col-sm-9">
                    <input type="text" name="loginAccount" value="${user.login_account}" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">登陆密码</label>
                <div class="col-sm-9">
                    <input type="text" name="password"  value="${user.password}" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">电话</label>
                <div class="col-sm-9">
                    <input type="text" name="tel"  value="${user.tel}" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">微信号</label>
                <div class="col-sm-9">
                    <input type="text" name="wxAccount"  value="${user.wx_account}" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">身份证号</label>
                <div class="col-sm-9">
                    <input type="text" name="idNo"  value="${user.id_no}" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">地址</label>
                <div class="col-sm-9">
                    <input type="text" name="address" value="${user.address}" class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <!--开始 -->
    <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
                <label class="col-sm-3 control-label">角色</label>
                <div class="col-sm-9">
                    <select name="roleId" class="form-control input-sm">
                        <c:forEach items="${role}" var="r">
                        <option value="${r.id}">${r.role_name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
    </div>
    <!--结束 -->
    <div class="row">
        <div class="col-sm-3 col-sm-offset-4">
            <input  type="submit" class="btn btn-success" value="提交"/>
            <a class="btn btn-warning" href="user_list.jsp">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>

