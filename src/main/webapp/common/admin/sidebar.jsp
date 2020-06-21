<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Left side column. contains the sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="<c:url value='assets/admin/dist/img/user2-160x160.jpg' />" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>Admin</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu" data-widget="tree">
			<li class="header">MAIN NAVIGATION</li>
			<li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
					<span>Dashboard</span>
			</a></li>
			<li class="header">MENU</li>
			<li class="treeview"><a href="#"> <i class="fa fa-share"></i>
					<span>Bài viết</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i> Thêm bài
							viết</a></li>
					<li><a href="<c:url value='admin' />"> <i class="fa fa-circle-o"></i> Danh sách bài viết
							
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-share"></i>
					<span> Danh mục</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"> <i class="fa fa-circle-o"></i> Thêm danh
							mục
					</a></li>
					<li><a href="<c:url value='adminViewCategory' />"> <i class="fa fa-circle-o"></i> Danh sách
							danh mục
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-share"></i><span>
						Quản lý User</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li><a href="#"> <i class="fa fa-circle-o"></i> Thêm user
					</a></li>
					<li><a href="<c:url value='adminUserView' />"> <i class="fa fa-circle-o"></i> Danh sách
							User
					</a></li>
				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>