<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>Dashboard</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Tài khoản</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">

	<div class="row">

		

		<!-- ./col -->
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-yellow">
				<div class="inner">
					<h3>4</h3>

					<p>User</p>
				</div>
				<div class="icon">
					<i class="ion ion-person-add"></i>
				</div>
				<a href="#" class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>
		<!-- ./col -->
	
		<!-- ./col -->
		<div>
			<table class="table table-bordered" id="myTable">
				<thead>
					<tr>
						<th>Tiêu đề</th>
						<th>Nội dung</th>
						<th>Ngày tạo</th>
						<th>Thao tác</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>

</section>
<!-- /.content -->
<script type="text/javascript">
	$(document).ready(function(){
		let data = [];
		axios.get('http://localhost:8080/Delayed/api/crawl-data').then((rs)=>{
			data = rs.data;
			let count = 0;
			for (var key in data) {
				count = data.length;
				$('#myTable').append('<tr><td>' + data[key].title + '</td>'+
									'<td>' + data[key].description + '</td>'+
									'<td>' + data[key].created + '</td>'+
									'<td><a id="add">Thêm</a><a id="update">Sửa</a><a id="delete">Xóa</a></td>'
									+'</tr>'
				);	
			   
			}	
			$('#count-post').text(count)
			 console.log(rs)
		});
		
	
	
	});
		

		
</script>