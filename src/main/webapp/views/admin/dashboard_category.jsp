<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1 id="dm">Danh mục</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Danh mục</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">

	<div class="row">


		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-red">
				<div class="inner">
					<h3 id="count-category"></h3>

					<p>Danh mục</p>
				</div>
				<div class="icon">
					<i class="ion ion-pie-graph"></i>
				</div>
				<a href="#" class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>
		<!-- ./col -->
		<div class="col-lg-12">
			<a id="add" class="btn btn-primary mr-1 mb-1">Thêm</a>'
			<table class="table table-bordered" id="myTable">
				<thead>
					<tr>
						<th style="min-witdh: 500px">Tên danh mục</th>
						<th style="min-witdh: 200px">Thao tác</th>
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
	$(document).ready(function() {
		makeGetRequest();
	});

	
	async function makeGetRequest() {

		let res = await	axios.get('${pageContext.request.contextPath}/api/category?action=all');

		let data = res.data;
		let count = data.length;
		for ( var key in data) {

			$('#myTable')
					.append(
							'<tr id="nanana"><td>'
									+ data[key].name
									+ '</td>'
									+

									'<td>'
									+ '<a  class="btn btn-success mr-1"'+'data-code="'+data[key].id+'"'+'>Sửa</a>'
									+ '<a  onclick=onClickDelete(this) class="btn btn-danger"'
									+ 'id="' + data[key].id + '"'
									+ '>Xóa</a>' + '</td>' + '</tr>');

		}
		

		$('#count-category').text(count);

	}
	
	
	
	function onClickDelete(e) {		
		$(e).parents('tr').remove();//remove tren form, chua remove trong database
		console.log(e.id);
		//e.id la id cua row dang click
		//xu ly vs database
		//axios.post('${pageContext.request.contextPath}/api/category/delete',{id:e.id});
	}
</script>
