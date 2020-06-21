<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<header class="main-header">
	<!-- Logo -->
	<a href="<c:url value='admin' />" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
		<span class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>Admin</b>LTE</span>
	</a>
	<!-- Header Navbar: style can be found in header.less -->
	<nav class="navbar navbar-static-top">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="push-menu"
			role="button"> <span class="sr-only">Toggle navigation</span> <span
			class="icon-bar"></span> <span class="icon-bar"></span> <span
			class="icon-bar"></span>
		</a>

		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="notifications-menu"><a href="<c:url value='/' />"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-bell-o"></i> Website
				</a></li>
				<!-- Notifications: style can be found in dropdown.less -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Admin <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Đổi mật khẩu</a></li>
						<li><a href="#">Chỉnh sửa thông tin</a></li>
						<li><a href="#">Đăng xuất</a></li>
					</ul></li>

			</ul>
		</div>
	</nav>
</header>