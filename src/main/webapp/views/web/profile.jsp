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
				<div v-if="errors.length" class="mt-15">
					<div class="row" v-for="error in errors">
						<label class="input-label"></label>
						<div class="alert alert-error">
							<!-- <i class="alert-icon fa fa-check-circle" aria-hidden="true"></i> -->
							<i class="alert-icon fa fa-times-circle" aria-hidden="true"></i>
							<span class="alert-message">{{error}}</span>
						</div>
					</div>
				</div>
				<div class="row mt-15" v-if="success">
					<label class="input-label"></label>
					<div class="alert alert-success">
						<i class="alert-icon fa fa-check-circle" aria-hidden="true"></i> <span
							class="alert-message">Cập nhật tài khoản thành công! Vui lòng đăng xuất!</span>
					</div>
				</div>
				<div class="row mt-15">
					<label class="input-label">Tài khoản: </label>
					<div>
						<input type="text" v-model="username" disabled>
					</div>
				</div>
				<div class="row">
					<label class="input-label">Họ và tên: </label>
					<div>
						<input type="text" v-model="fullname">
					</div>
				</div>
				<div class="row">
					<label class="input-label">Email: </label>
					<div>
						<input type="email" v-model="email">
					</div>
				</div>
				<div class="row">
					<label class="input-label">Ngày tạo:</label>
					<div>
						<input type="text" v-model="created" disabled>
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
						<input type="password" v-model="oldPassword">
					</div>
				</div>
				<div class="row" v-if="show">
					<label class="input-label">Mật khẩu mới: </label>
					<div>
						<input type="password" v-model="password">
					</div>
				</div>
				<div class="row" v-if="show">
					<label class="input-label">Nhập lại mật khẩu mới: </label>
					<div>
						<input type="password" v-model="rePassword">
					</div>
				</div>
				<div class="row">
					<label class="input-label"></label>
					<div>
						<button v-on:click="checkForm">Cập nhật</button>
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
	new Vue(
			{
				el : "#profile",
				data : {
					show : false,
					username : '${USERMODEL.username}',
					fullname : '${USERMODEL.fullName}',
					email : '${USERMODEL.email}',
					created : '${USERMODEL.created}',
					oldPassword : '',
					password : '',
					rePassword : '',
					errors : [],
					success : false
				},
				methods : {
					checkForm : function() {
						this.errors = [];
						if (!this.fullname) {
							this.errors.push('Họ và tên không được để trống.');
						}
						if (!this.email) {
							this.errors.push('Email không được để trống.');
						}
						if (this.show) {
							if (!this.password)
								this.errors
										.push('Mật khẩu mới không được để trống.');
							if (!this.rePassword)
								this.errors.push('Vui lòng không để trống nó.');
							if (!this.oldPassword)
								this.errors
										.push('Mật khẩu cũ không để trống nó.');
							if (this.password !== this.rePassword)
								this.errors
										.push('Mật khẩu mới và nhập lại mật khẩu không trùng khớp.');
						}
						console.log('Errors', this.errors);
						if (this.errors.length)
							return;
						if(this.show){
							var bodyPost = {
									username: this.username,
									password: this.oldPassword
							}
							this.checkPassword(bodyPost);
						}else{
							this.changeProfile();
						}
						
						
					},
					checkPassword: function(body){
						axios
						.post("${pageContext.request.contextPath}/api/change-profile", body)
						.then((res) => {
							if(res.data === "INVALID"){
								this.errors.push("Mật khẩu cũ không khớp với mật khẩu trong cơ sở dữ liệu!")
							}else{
								this.changeProfile();
							}
						})
						.catch((error) => {
						console.log(error);
						});
					},
					changeProfile: function(){
						var body = {
							username: this.username,
							fullName: this.fullname,
							email: this.email,
							password : !this.password ? '${USERMODEL.password}' : this.password
						};
						axios
						.put("${pageContext.request.contextPath}/api/change-profile", body)
						.then((res) => {
							if(res.data === "SUCCESS") this.success = true;
						})
						.catch((error) => {
						console.log(error);
						});
					}
				}

			});
</script>