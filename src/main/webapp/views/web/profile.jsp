<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="wrapper">
	<div class="mainx">
		<div class="box">
			<div class="box-title">
				<i class="fa fa-gamepad" aria-hidden="true"> Thông tin tài khoản</i>
			</div>
			<div class="box-body" id="profile">
				<div class="row mt-15">
					<label class="input-label">Tài khoản: </label>
					<div>
						<input type="text" disabled>
					</div>
				</div>
				<div class="row">
					<label class="input-label">Họ và tên: </label>
					<div>
						<input type="text">
					</div>
				</div>
				<div class="row">
					<label class="input-label">Email: </label>
					<div>
						<input type="text">
					</div>
				</div>
				<div class="row">
					<label class="input-label">Ngày tạo:</label>
					<div>
						<input type="text" disabled>
					</div>
				</div>
				<div class="row">
					<label class="input-label"></label>
					<div class="hasCheckBox">
						<input type="checkbox" v-model="show"> <span class="label">Thay
							đổi mật khẩu </span>
					</div>
				</div>
				<div class="row" v-if="show">
					<label class="input-label">Mật khẩu cũ: </label>
					<div>
						<input type="password">
					</div>
				</div>
				<div class="row" v-if="show">
					<label class="input-label">Mật khẩu mới: </label>
					<div>
						<input type="password">
					</div>
				</div>
				<div class="row" v-if="show">
					<label class="input-label">Nhập lại mật khẩu mới: </label>
					<div>
						<input type="password">
					</div>
				</div>
				<div class="row">
					<label class="input-label"></label>
					<div>
						<button>Cập nhật</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Sidebar -->
	<%@ include file="/common/web/sidebar.jsp"%>
	<!-- end Sidebar -->
</div>
<script>
	new Vue({
		el: "#profile",
		data:{
			show: false
		}
	});

</script>