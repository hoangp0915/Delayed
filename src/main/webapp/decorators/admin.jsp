<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin</title>
<!-- Tell the browser to be responsive to screen width -->
<link rel="shortcut icon" type="image/png" href="<c:url value='/assets/web/images/logo.png' />"/>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="<c:url value='/assets/admin/bootstrap/css/bootstrap.min.css' />">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<c:url value='/assets/web/style/style.css' />">
<link rel="stylesheet"
	href="<c:url value='/assets/web/style/posts.css' />">
<link rel="stylesheet"
	href="<c:url value='/assets/web/style/common.css' />">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed&amp;subset=latin,latin-ext,vietnamese"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.js' />"></script>
<!--<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
	<script
		src="<c:url value='/assets/admin/plugins/jQuery/jquery-3.1.1.min.js' />"></script>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value='/assets/admin/dist/css/AdminLTE.min.css' />">

<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<c:url value='/assets/admin/dist/css/skins/_all-skins.min.css' />">
<!-- Pace style -->
<link rel="stylesheet"
	href="<c:url value='/assets/admin/plugins/pace/pace.min.css' />">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- header -->
		<%@ include file="/common/admin/header.jsp"%>
		<!-- header -->
		<!-- sidebar -->
		<%@ include file="/common/admin/sidebar.jsp"%>
		<!-- sidebar -->
		<div class="content-wrapper">
			<dec:body />
		</div>

		<!-- footer -->
		<%@ include file="/common/web/footer.jsp"%>
		<!-- footer -->

	</div>
	<!-- ./wrapper -->
	<!-- jQuery 3.1.1 -->
	<script
		src="<c:url value='/assets/admin/plugins/jQuery/jquery-3.1.1.min.js' />"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="<c:url value='/assets/admin/bootstrap/js/bootstrap.min.js' />"></script>
	<!-- PACE -->
	<script src="<c:url value='/assets/admin/plugins/pace/pace.min.js' />"></script>
	<!-- SlimScroll -->
	<script
		src="<c:url value='/assets/admin/plugins/slimScroll/jquery.slimscroll.min.js' />"></script>
	<!-- FastClick -->
	<script
		src="<c:url value='/assets/admin/plugins/fastclick/fastclick.js' />"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value='/assets/admin/dist/js/adminlte.min.js' />"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value='/assets/admin/dist/js/demo.js' />"></script>
	<!-- page script -->
	<script type="text/javascript">
		// To make Pace works on Ajax calls
		$(document).ajaxStart(function() {
			Pace.restart();
		});
		$('.ajax').click(function() {
			$.ajax({
				url : '#',
				success : function(result) {
					$('.ajax-content').html('<hr>Ajax Request Completed !');
				}
			});
		});
	</script>

</body>
</html>