<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="wrapper">
	<div class="mainx">
		<div class="posts">
			<div class="posts-title">
				<img src="${postDetail.thumbnail}" alt="">
				<div class="title">
					<p>
						<i class="fa fa-code" aria-hidden="true"></i> ${postDetail.title}
					</p>
				</div>
			</div>
			<div class="posts-breadcumb">
				<ul>
					<li><a href=""><i class="fa fa-home" aria-hidden="true"></i>
							Home</a></li>
					<li>›</li>
					<li><a href="">Game</a></li>
					<li>›</li>
					<li><a href="">Game Androd</a></li>
				</ul>
			</div>
			<span><i class="fa fa-user-circle-o" aria-hidden="true"></i>
				${postDetail.createdBy} | <i class="fa fa-calendar-minus-o"
				aria-hidden="true"></i> ${postDetail.created}</span>
			<div class="like-top"></div>
			<div class="posts-content">${postDetail.content}</div>
			<div class="posts-tag">
				<p>Tag:</p>
				<h3>
					<a href="">Game online</a>
				</h3>
				<h3>
					<a href="">Game online</a>
				</h3>
				<h3>
					<a href="">Game online</a>
				</h3>
				<h3>
					<a href="">Game online</a>
				</h3>
				<h3>
					<a href="">Game online</a>
				</h3>
				<h3>
					<a href="">Game online</a>
				</h3>
				<h3>
					<a href="">Game online</a>
				</h3>
				<h3>
					<a href="">Game online</a>
				</h3>
				<h3>
					<a href="">Game online</a>
				</h3>

			</div>
			<div class="fixed"></div>
		</div>
		<div class="box">
			<div class="box-title">Bình luận</div>
			<div class="box-comment">
				<!-- Bình luận Facebook -->
			</div>
		</div>
		<div class="box">
			<div class="box-title">Bài viêt ngẫu nhiên</div>
			<div class="box-cm">
			<c:forEach var="item" items="${views}">
				<div class="cm">
					<div class="cm-img">
						<a href="<c:url value='/post?id=${item.id}' />"><img
							src="${item.thumbnail}"
							alt=""></a>
					</div>
					<div class="cm-title">
						<a href="<c:url value='/post?id=${item.id}' />"> ${item.title}</a>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<!-- end main -->
	<!-- Sidebar -->
	<%@ include file="/common/web/sidebar.jsp"%>
	<!-- end Sidebar -->
</div>