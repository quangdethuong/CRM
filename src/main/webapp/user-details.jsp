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
    <!-- Navigation -->
    <%@ include file="navbar.jsp" %>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Chi tiết thành viên</h4>
                </div>
            </div>
            <!-- /.row -->
            <!-- .row -->
            <div class="row">
                <div class="col-md-4 col-xs-12">
                    <div class="white-box">
                        <div class="user-bg"><img width="100%" alt="user" src="plugins/images/large/img1.jpg">
                            <div class="overlay-box">
                                <div class="user-content">
                                    <a href="javascript:void(0)"><img
                                            src="<c:url value="/plugins/images/users/${userDetail.userAvatar}"/>"
                                            class="thumb-lg img-circle" alt="img"></a>
                                    <h4 class="text-white">${userDetail.userName}</h4>
                                    <h5 class="text-white">${userDetail.userEmail}</h5>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-md-8 col-xs-12">
                    <!-- BEGIN THỐNG KÊ -->
                    <%--	<div class="row">--%>
                    <%--		<!--col -->--%>
                    <%--		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">--%>
                    <%--			<div class="white-box">--%>
                    <%--				<div class="col-in row">--%>
                    <%--					<div class="col-xs-12">--%>
                    <%--						<h3 class="counter text-right m-t-15 text-danger">20%</h3>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-xs-12">--%>
                    <%--						<i data-icon="E" class="linea-icon linea-basic"></i>--%>
                    <%--						<h5 class="text-muted vb text-center">CHƯA BẮT ĐẦU</h5>--%>
                    <%--					</div>--%>
                    <%--					<div class="col-md-12 col-sm-12 col-xs-12">--%>
                    <%--						<div class="progress">--%>
                    <%--							<div class="progress-bar progress-bar-danger" role="progressbar"--%>
                    <%--								aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"--%>
                    <%--								style="width: 20%"></div>--%>
                    <%--						</div>--%>
                    <%--					</div>--%>
                    <%--				</div>--%>
                    <%--			</div>--%>
                    <%--		</div>--%>
                    <%--		<!-- /.col -->--%>
                    <%--		<!--col -->--%>
                    <%--		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">--%>
                    <%--			<div class="white-box">--%>
                    <%--				<div class="col-in row">--%>
                    <%--					<div class="col-xs-12">--%>
                    <%--						<h3 class="counter text-right m-t-15 text-megna">50%</h3>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-xs-12">--%>
                    <%--						<i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>--%>
                    <%--						<h5 class="text-muted vb text-center">ĐANG THỰC HIỆN</h5>--%>
                    <%--					</div>--%>
                    <%--					<div class="col-md-12 col-sm-12 col-xs-12">--%>
                    <%--						<div class="progress">--%>
                    <%--							<div class="progress-bar progress-bar-megna" role="progressbar"--%>
                    <%--								aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"--%>
                    <%--								style="width: 50%"></div>--%>
                    <%--						</div>--%>
                    <%--					</div>--%>
                    <%--				</div>--%>
                    <%--			</div>--%>
                    <%--		</div>--%>
                    <%--		<!-- /.col -->--%>
                    <%--		<!--col -->--%>
                    <%--		<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">--%>
                    <%--			<div class="white-box">--%>
                    <%--				<div class="col-in row">--%>
                    <%--					<div class="col-xs-12">--%>
                    <%--						<h3 class="counter text-right m-t-15 text-primary">30%</h3>--%>
                    <%--                    </div>--%>
                    <%--                    <div class="col-xs-12">--%>
                    <%--						<i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>--%>
                    <%--						<h5 class="text-muted vb text-center">HOÀN THÀNH</h5>--%>
                    <%--					</div>--%>
                    <%--					<div class="col-md-12 col-sm-12 col-xs-12">--%>
                    <%--						<div class="progress">--%>
                    <%--							<div class="progress-bar progress-bar-primary" role="progressbar"--%>
                    <%--								aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"--%>
                    <%--								style="width: 30%"></div>--%>
                    <%--						</div>--%>
                    <%--					</div>--%>
                    <%--				</div>--%>
                    <%--			</div>--%>
                    <%--		</div>--%>
                    <%--		<!-- /.col -->--%>
                    <%--	</div>--%>

                    <div class="row">
                        <!--col -->
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="white-box">
                                <div class="col-in row">
                                    <div class="col-xs-12">
                                        <c:set var="countWithStatusOne" value="0"/>
                                        <c:forEach var="item" items="${userDetail.taskDtoList}">
                                            <c:if test="${item.statusId == 1}">
                                                <c:set var="countWithStatusOne" value="${countWithStatusOne + 1}"/>
                                            </c:if>
                                        </c:forEach>
                                        <c:set var="percent1"
                                               value="${Math.round(countWithStatusOne * 100 / userDetail.taskDtoList.size())}"/>
                                        <h3 class="counter text-right m-t-15 text-danger">${percent1}%</h3>
                                    </div>
                                    <div class="col-xs-12">
                                        <i data-icon="E" class="linea-icon linea-basic"></i>
                                        <h5 class="text-muted vb text-center">CHƯA BẮT ĐẦU</h5>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-danger" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: ${percent1}%"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                        <!--col -->
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="white-box">
                                <div class="col-in row">
                                    <div class="col-xs-12">
                                        <c:set var="countWithStatusTwo" value="0"/>
                                        <c:forEach var="item" items="${userDetail.taskDtoList}">
                                            <c:if test="${item.statusId == 2}">
                                                <c:set var="countWithStatusTwo" value="${countWithStatusTwo + 1}"/>
                                            </c:if>
                                        </c:forEach>
                                        <c:set var="percent2"
                                               value="${Math.round(countWithStatusTwo * 100 / userDetail.taskDtoList.size())}"/>
                                        <h3 class="counter text-right m-t-15 text-megna">${percent2}%</h3>
                                    </div>
                                    <div class="col-xs-12">
                                        <i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
                                        <h5 class="text-muted vb text-center">ĐANG THỰC HIỆN</h5>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-megna" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: ${percent2}%"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                        <!--col -->
                        <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                            <div class="white-box">
                                <div class="col-in row">
                                    <div class="col-xs-12">
                                        <c:choose>
                                            <c:when test="${userDetail.taskDtoList.size() == 0}">
                                                <c:set var="percent3" value="0"/>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="percent3" value="${100 - percent1 - percent2}"/>
                                            </c:otherwise>
                                        </c:choose>

                                        <h3 class="counter text-right m-t-15 text-primary">${percent3}%</h3>
                                    </div>
                                    <div class="col-xs-12">
                                        <i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
                                        <h5 class="text-muted vb text-center">HOÀN THÀNH</h5>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-primary" role="progressbar"
                                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                                 style="width: ${percent3}%"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- END THỐNG KÊ -->

                </div>
            </div>
            <br/>
            <!-- /.row -->
            <!-- BEGIN DANH SÁCH CÔNG VIỆC -->
            <h4>DANH SÁCH CÔNG VIỆC</h4>
            <div class="row">
                <div class="col-md-4">
                    <div class="white-box">
                        <h3 class="box-title">Chưa thực hiện</h3>
                        <div class="message-center">


                            <c:choose>
                                <c:when test="${userDetail.taskDtoList.size() != 0}">
                                    <c:forEach var="task" items="${userDetail.taskDtoList}">
                                        <c:if test="${task.statusId == 1}">
                                            <a href="#">
                                                <div class="mail-contnet">
                                                    <h5>${task.name}</h5>
                                                    <span class="mail-desc"></span>
                                                    <span class="time">Bắt đầu: ${task.startDay}</span>
                                                    <span class="time">Kết thúc: ${task.endDay}</span>
                                                </div>
                                            </a>
                                        </c:if>
                                    </c:forEach>
                                </c:when>
                                <c:when test="${userDetail.taskDtoList.size() == 0}">
                                    <a href="#">
                                        <div class="mail-contnet">
                                            <h5>NOT FOUND</h5>

                                        </div>
                                    </a>
                                </c:when>
                            </c:choose>

                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="white-box">
                        <h3 class="box-title">Đang thực hiện</h3>
                        <div class="message-center">
                            <c:choose>
                                <c:when test="${userDetail.taskDtoList.size() != 0}">
                                    <c:forEach var="task" items="${userDetail.taskDtoList}">
                                        <c:if test="${task.statusId == 2}">
                                            <a href="#">
                                                <div class="mail-contnet">
                                                    <h5>${task.name}</h5>
                                                    <span class="mail-desc"></span>
                                                    <span class="time">Bắt đầu: ${task.startDay}</span>
                                                    <span class="time">Kết thúc: ${task.endDay}</span>
                                                </div>
                                            </a>
                                        </c:if>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <a href="#">
                                        <div class="mail-contnet">
                                            <h5>NOT FOUND</h5>
                                                <%--                                                <span class="mail-desc"></span>--%>
                                                <%--                                                <span class="time">Bắt đầu: ${task.startDay}</span>--%>
                                                <%--                                                <span class="time">Kết thúc: ${task.endDay}</span>--%>
                                        </div>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="white-box">
                        <h3 class="box-title">Đã hoàn thành</h3>
                        <div class="message-center">
                            <c:choose>
                                <c:when test="${userDetail.taskDtoList.size() != 0}">
                                    <c:forEach var="task" items="${userDetail.taskDtoList}">
                                        <c:if test="${task.statusId == 3}">
                                            <a href="#">
                                                <div class="mail-contnet">
                                                    <h5>${task.name}</h5>
                                                    <span class="mail-desc"></span>
                                                    <span class="time">Bắt đầu: ${task.startDay}</span>
                                                    <span class="time">Kết thúc: ${task.endDay}</span>
                                                </div>
                                            </a>
                                        </c:if>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <a href="#">
                                        <div class="mail-contnet">
                                            <h5>NOT FOUND</h5>
                                                <%--                                                <span class="mail-desc"></span>--%>
                                                <%--                                                <span class="time">Bắt đầu: ${task.startDay}</span>--%>
                                                <%--                                                <span class="time">Kết thúc: ${task.endDay}</span>--%>
                                        </div>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END DANH SÁCH CÔNG VIỆC -->
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