<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<section class="content-header">
	<h1>
		Pace page <small>Loading example</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"> <i class="fa fa-dashboard"></i> Home
		</a></li>
		<li><a href="#">Bài viết</a></li>
		<li class="active">Cập nhật bài viết</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">


	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title"></h3>
		</div>
		<form class="form-horizontal">
			<div class="box-body">
				<div class="form-group">
					<label for="namechapter" class="col-sm-2 control-label">Tiêu
						đề bài viết: </label>

					<div class="col-sm-9">
						<input type="text" class="form-control" name="title" id="title"
							placeholder="Nhập tiêu đề">
					</div>
				</div>

				<div class="form-group">
					<label for="chapter" class="col-sm-2 control-label">Danh
						mục</label>
					<div class="col-sm-9">
						<select class="form-control" id="category">

						</select>
						<p>
							<code>Super Admin</code>
							có quyền cao nhất
						</p>
					</div>
				</div>
				<div class="form-group">
					<label for="namechapter" class="col-sm-2 control-label">Giới thiệu: </label>

					<div class="col-sm-9">
						<input type="text" class="form-control" name="description" id="description" 
							placeholder="Nhập giới thiệu">
					</div>
				</div>
				
				<div class="form-group">
					<label for="namechapter" class="col-sm-2 control-label">Nội
						dung: </label>

					<div class="col-sm-9">
						<input type="text" class="form-control" name="description" id="content" 
							placeholder="Nhập nội dung">
					</div>
				</div>

			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<a href="" class="btn btn-info"> <i class="fa fa-share"></i>
					Back
				</a>
				
			</div>
			<!-- /.box-footer -->
		</form>


		<!-- /.box-body -->
	</div>


</section>


<script type="text/javascript">
	$(document).ready(function() {
		
		var tech = getUrlParameter('action');
		if(tech.toString() === 'edit' ){
			console.log('form edit');
			$('.box-title').html('Chỉnh sửa bài viết');
			getDataForm();
			$('.box-footer').append('<button type="button" id="updatePost" class="btn btn-info pull-right">Lưu</button>')
			
		}else{
			$('.box-title').html('Thêm bài viết');
			console.log('form create');
			 $('.box-footer').append('<button type="button" id="addPost" class="btn btn-info pull-right">Thêm</button>');			 			
			makeGetRequest();
		}
	});

	function getUrlParameter(sParam) {
	    var sPageURL = window.location.search.substring(1),
	        sURLVariables = sPageURL.split('&'),
	        sParameterName,
	        i;

	    for (i = 0; i < sURLVariables.length; i++) {
	        sParameterName = sURLVariables[i].split('=');

	        if (sParameterName[0] === sParam) {
	            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
	        }
	    }
	};
	
	async function makeGetRequest() {

		let res = await	axios.get('${pageContext.request.contextPath}/api/category?action=all');

		let data = res.data;
		let count = data.length;
		for ( var key in data) {

			$('#category').append('<option'+' value="'+data[key].id+'"'+'>'+ data[key].name+ '</option>'
				
			);

		}
		

		$('#count-category').text(count);

		$('#addPost').click(function(){
			console.log("update")
			let Post = {
					title:$('#title').val(),
					categoryId :$("#category option:selected").val(),
					description:$('#description').val(),
					content:$('#content').val(),
			}
			
			axios.post('${pageContext.request.contextPath}/api/home',Post).then((rs,err)=>{
				if(err){
					console.log(err)
				}else{
					alert("Tạo mới thành công thành công");
					$(location).attr('href', '${pageContext.request.contextPath}/admin')
				}
			})
									
				
		})
		
		
	}
	
	 function getDataForm () {
		var id = getUrlParameter('id');		
		
		makeGetRequest();
		 		
		return axios.get('${pageContext.request.contextPath}/api/post-edit?id='+id).then((res)=>{
			$('#title').val(res.data.title);
			$('#category').val(res.data.categoryId);
			$('#description').val(res.data.description);
			$('#content').val(res.data.content);
			console.log(res.data.categoryId)
		//let categoryId = '"'+res.data.categoryId +'"';
		
		//$('select option[value="7"]').attr("selected",true);
			 
		$('#updatePost').click(function(){
			let Post = {
					title:$('#title').val(),
					categoryId :$("#category option:selected").val(),
					description:$('#description').val(),
					content:$('#content').val(),
					id:id
			}
		
			axios.put('${pageContext.request.contextPath}/api/post-edit?id',Post).then((rs,err)=>{
				if(err){
					console.log(err)
				}else{
					alert("Cập nhật thành công");
					$(location).attr('href', '${pageContext.request.contextPath}/admin')
				}
			})
				
		});
		 });
		
		
		//$("#category").val(categoryId);
				//console.log($("#category").val(categoryId))
		
	}
	
	
	

</script>
