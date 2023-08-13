<%--
  Created by IntelliJ IDEA.
  User: 84944
  Date: 2023-08-09
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="<c:url value="/plugins/images/favicon.png"/>">
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value = "/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="<c:url value ="/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <!-- animation CSS -->
    <link href="<c:url value ="/css/animate.css"/>" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<c:url value ="/css/style.css"/>" rel="stylesheet">
    <!-- color CSS -->
    <link href="<c:url value ="/css/colors/blue-dark.css"/>" id="theme" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/css/custom.css"/>">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!-- Preloader -->
<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>
<div id="wrapper">
    <%@ include file="navbar.jsp" %>
    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Thêm mới thành viên</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-2 col-12"></div>
                <div class="col-md-8 col-xs-12">
                    <div class="white-box">
                        <form class="form-horizontal form-material"  method="post">
                            <div class="form-group">

                                <input value="${userUpdate.id}" name="oldId" type="hidden"
                                       class="form-control form-control-line">
                            </div>
                            <div class="form-group">
                                <label class="col-md-12">Full Name</label>
                                <div class="col-md-12">
                                    <input name="newFullName" type="text" value="${userUpdate.fullname}" placeholder=""
                                           class="form-control form-control-line"></div>
                            </div>
                            <div class="form-group">
                                <label for="example-email" class="col-md-12">Email</label>
                                <div class="col-md-12">
                                    <input type="email" value="${userUpdate.email}" placeholder=""
                                           class="form-control form-control-line" name="emailupdate"
                                           id="example-email"></div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-12">Avatar</label>
                                <div class="col-md-12">
                                    <input name="newAvatar" type="text" value="${userUpdate.avatar}"
                                           class="form-control form-control-line">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-12">Select Role</label>
                                <div class="col-sm-12">

                                    <select name="newRole" class="form-control form-control-line">
                                        <c:if test="${listRole!=null}">
                                            <c:forEach var="item" items="${listRole}">
                                                <option value="${item.getId()}" ${userUpdate != null && userUpdate.getRoleId() == item.getId() ? 'selected' : ''}>${item.getDescription()}</option>
                                            </c:forEach>
                                        </c:if>

                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <button type="submit" class="btn btn-success">Save</button>

                                    <a href="<%=contextPath%>/user" class="btn btn-primary">Quay lại</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-2 col-12"></div>


            </div>
            <!-- /.row -->
            <c:if test="${msg-fail != 0}">
                <h5 style="color: red;">${msg-fail}</h5>

            </c:if>
            <c:if test="${msg-valid != 0}">
                <h5 style="color: red;">${msg-valid}</h5>

            </c:if>
            <c:if test="${msg-done != 0}">
                <h5 style="color: green;">${msg-done}</h5>
            </c:if>

        </div>
        <!-- /.container-fluid -->
        <footer class="footer text-center"> 2018 &copy; myclass.com</footer>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<!-- jQuery -->
<script src="<c:url value="/plugins/bower_components/jquery/dist/jquery.min.js"/>"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<!-- Menu Plugin JavaScript -->
<script src="<c:url value="/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"/>"></script>
<!--slimscroll JavaScript -->
<script src="<c:url value="/js/jquery.slimscroll.js" />"></script>
<!--Wave Effects -->
<script src="<c:url value="/js/waves.js" />"></script>
<!-- Custom Theme JavaScript -->
<script src="<c:url value="/js/custom.min.js" />"></script>
</body>

</html>
