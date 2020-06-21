<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>Dashboard</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Bài viết</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">

	<div class="row">

		<div class="col-lg-4 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-aqua">
				<div class="inner">
					<h3 id="count-post"></h3>

					<p>Bài viết</p>
				</div>
				<div class="icon">
					<i class="ion ion-bag"></i>
				</div>
				<a href="#" class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>


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
		//Data chưa có field creatdate và id
		axios.get('http://localhost:8080/Delayed/api/crawl-data').then((rs)=>{
			data = rs.data;
			let count = 0;
			for (var key in data) {
				count = data.length;
				let date = new Date(data[key].created);
				let day = date.getDate();
				let month = date.getMonth();
				$('#myTable').append('<tr><td>' + data[key].title + '</td>'+
									'<td>' + data[key].description.slice(0, 25) + (data[key].description.length > 25 ? "..." : "") + '</td>'+
									'<td>' + day +'/' +month + '</td>'+
								
									'<td>'
									+ '<a  class="btn btn-success mr-1"'+'data-code="'+data[key].id+'"'+'>Sửa</a>'
									+ '<a  onclick=onClickDelete(this) class="btn btn-danger"'
									+ 'id="' + data[key].id + '"'
									+ '>Xóa</a>' + '</td>'
									+'</tr>'
				);	
			   
			}	
			$('#count-post').text(count)
			 console.log(rs)
		});
		
	
	
	});
		
	
	function onClickDelete(e) {		
		$(e).parents('tr').remove();//remove tren form, chua remove trong database
		console.log(e.id);
		//e.id la id cua row dang click
		//xu ly vs database
		//axios.post('http://localhost:8080/Delayed/api/category/delete',{id:e.id});
	}

		
</script>