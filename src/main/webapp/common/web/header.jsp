<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navbar -->
<div id="header">
	<div class="dex"></div>
	<div class="logo">
		<a href=""> <img
			src="<c:url value='/assets/web/images/logo.png' />" alt="">
		</a>
	</div>
	<div id="nav-menu" class="menu-nav">
		<div class="nav">
			<ul class="menu left">
				<li class="home"><a href="<c:url value='home' />">Home</a></li>
				<li><a href="">Game</a>
					<ul class="sub-menu">
						<li><a href="">PC</a></li>
						<li><a href="">Android</a></li>
					</ul></li>
				<li><a href="">Thủ thuật</a>
					<ul class="sub-menu">
						<li><a href="">PC</a></li>
						<li><a href="">Android</a></li>
					</ul></li>
				<li><a href="">Images</a></li>
			</ul>
			<ul class="menu right ml-2">
				<!-- <li class="mr-0">
                        <a class="bt-2-w" href="">Đăng nhập</a>
                    </li> -->
				<li class="mr-0">
					<div>
						<a class="bt-2-w d-flex d-align-items"> <img
							src="https://via.placeholder.com/150" class="mr-1" alt="">
							<div>Mai Văn Hoàng</div>
						</a>
					</div>
					<ul class="sub-menu">
						<li><a href="">Thông tin chi tiết</a></li>
						<li><a href="">ADMIN</a></li>
						<li><a href="">Đăng xuất</a></li>
					</ul>
				</li>
			</ul>
			<div class="dropdown">
				<button onclick="onclickbtn();" class="cursor-pointer">
					<i class="fa fa-search"></i>
				</button>
				<div class="search" id="search-modal">
					<form action="#">
						<div class="form-group">
							<input type="search" placeholder="Nhập nội dung...">
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
</script>
<!-- End Navbar -->