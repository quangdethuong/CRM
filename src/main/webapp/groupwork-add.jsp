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
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="<c:url value="/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css"/>" rel="stylesheet">
    <!-- animation CSS -->
    <link href="<c:url value="/css/animate.css"/>" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<c:url value="/css/style.css"/>" rel="stylesheet">
    <!-- color CSS -->
    <link href="<c:url value="/css/colors/blue-dark.css"/>" id="theme" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
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
        <!-- Navigation -->
        <%@ include file="navbar.jsp" %>
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">${isEdit==true ? "Cập Nhật dự án" : "Thêm mới dự án"}</h4>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->

                <div class="row">
                    <div class="col-md-2 col-12"></div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            <c:set var="actionUrl" value="${isEdit == true ? '/job/update' : '/job/add'}" />
                            <c:if test="${isEdit == true}">
                                <c:set var="actionUrl" value="${actionUrl}?id=${job.id}" />
                            </c:if>
                            <form action="<c:url value="${actionUrl}"/>" method="post" class="form-horizontal form-material">
                                <div class="form-group">
                                    <label class="col-md-12">Tên dự án</label>
                                    <div class="col-md-12">
                                        <input name="name" type="text" placeholder="Tên công việc"
                                               class="form-control form-control-line" value="${job != null ? job.name : ''}"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">Ngày bắt đầu</label>
                                    <div class="col-md-12">
                                        <input name="start_day" type="text" placeholder="dd/MM/yyyy"
                                               class="form-control form-control-line date-custom" autocomplete="off" value="${job != null ? job.start_date : ''}"> </div>
                                </div>
                                <h3 class="mt-5 text-center" style="color: red;">${errorMessage}</h3>

                                <div class="form-group">
                                    <label class="col-md-12">Ngày kết thúc</label>
                                    <div class="col-md-12">
                                        <input name="end_day" type="text" placeholder="dd/MM/yyyy"
                                               class="form-control form-control-line date-custom" autocomplete="off" value="${job != null ? job.end_date : ''}"> </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <button type="submit" class="btn btn-success">${isEdit == true ? "Cập nhật" : "Thêm mới"}</button>
                                        <a href="<c:url value="/job"/>" class="btn btn-primary">Quay lại</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-2 col-12"></div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2018 &copy; myclass.com </footer>
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
    <script src="<c:url value="/js/jquery.slimscroll.js"/>"></script>
    <!--Wave Effects -->
    <script src="<c:url value="/js/waves.js"/>"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="/js/custom.min.js"/>"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <script src="<c:url value="/js/dateFormat.js"/>"></script>


</body>

</html>