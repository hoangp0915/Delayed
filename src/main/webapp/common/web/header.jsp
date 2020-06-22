<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Navbar -->
<div id="header">
	<div class="dex"></div>
	<div class="logo">
		<a href="<c:url value='/home' />"> <img
			src="<c:url value='/assets/web/images/logo.png' />" alt="">
		</a>
	</div>
	<div id="nav-menu" class="menu-nav">
		<div class="nav">
			<ul class="menu left">
				<li class="home"><a href="<c:url value='home' />">Home</a></li>
				<li v-for="category in data" v-if="category.parent === 0" v-html="getMenu(category)">
				</li>
			</ul>
			<ul class="menu right ml-2">
				<c:if test="${empty USERMODEL}">
					<li class="mr-0"><a class="bt-2-w"
						href="<c:url value='login' />">Đăng nhập</a></li>
				</c:if>
				<c:if test="${not empty USERMODEL}">
					<li class="mr-0">
						<div>
							<a class="bt-2-w d-flex d-align-items"> <img
								src="http://bootdey.com/img/Content/user_1.jpg" class="mr-1" alt="">
								<div>${USERMODEL.fullName == null ? USERMODEL.username : USERMODEL.fullName}</div>
							</a>
						</div>
						<ul class="sub-menu">
							<li><a href="">Thông tin chi tiết</a></li>
							<c:if test="${USERMODEL.role.code == 'ADMIN'}">
							<li><a href="<c:url value='admin' />">ADMIN</a></li>
							</c:if>
							<li><a href="<c:url value='home?action=logout' />">Đăng
									xuất</a></li>
						</ul>
					</li>
				</c:if>
			</ul>
			<div class="dropdown">
				<button onclick="onclickbtn();" class="cursor-pointer">
					<i class="fa fa-search"></i>
				</button>
				<div class="search" id="search-modal">
				
					<form action="<c:url value='/search' />">
						<div class="form-group">
							<input type="search" name="searchKey" placeholder="Nhập nội dung...">
							<button type="submit" class="cursor-pointer">
								<i class='fa fa-search'></i>
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</div>
<script>
	function onclickbtn() {
		document.getElementById("search-modal").classList.toggle("show");
	}
	window.onscroll = function() {
		scrollFunction()
	}
	function scrollFunction() {
		if (document.body.scrollTop > 100
				|| document.documentElement.scrollTop > 100) {
			document.getElementById("nav-menu").style.position = "fixed";
			document.getElementById("nav-menu").style.top = "0";
			document.getElementById("wrapper").style.marginTop = "70px";

		} else {
			document.getElementById("nav-menu").style.position = "";
			document.getElementById("wrapper").style.marginTop = "15px";

		}
	}
	new Vue({
		el: "#header",
		data:{
			data: [],
			bindHtml: ''
		},
		mounted: function (){
			axios.get("${pageContext.request.contextPath}/api/category?action=all").then((response) => {
				this.data = response.data.map((data) => {
					return {
						name: data.name,
						parent: data.parent,
						id: data.id,
						url: "${pageContext.request.contextPath}/category?cat=" + data.id
					}
				});
			});
			
		},
		methods:{
			getMenu: function(category){
				const string = "<a href='" + category.url +"'>"+ category.name + "</a>";
				const child = this.data.find(item => item.parent === category.id);
				const ul = "<ul class='sub-menu'>";
				const li = [];
				if(child !== undefined){
					this.data.forEach(element => {
						if(element.parent === category.id){
							li.push("<li><a href='" + element.url +"'>"+ element.name + "</a></li>")
						}
					});
				}
				const submenu = ul.concat(...li, "</ul>");	
				return string.concat(submenu);
			}
		}
	});
	
						// <li><a href="">PC</a></li>
						// <li><a href="">Android</a></li>
</script>
<!-- End Navbar -->