<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="wrapper">
	<div class="mainx" id="postDetail">
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
				<span style="width: 50%"><i class="fa fa-user-circle-o"
					aria-hidden="true"></i> ${postDetail.createdBy} | <i
					class="fa fa-calendar-minus-o" aria-hidden="true"></i>
					${postDetail.created}
				</span> 
				<span style="width: 32%; float: right;" v-if="!isFavorite">
					<button type="submit" v-on:click="setFavorite">
						<i class="fa fa-thumbs-up" aria-hidden="true"></i> Thêm vào bài
						viết ưa thích
					</button>
				</span> 
				<span style="width: 25%; float: right;" v-if="isFavorite">
					<button type="submit"  v-on:click="deleteFavorite">
						<i class="fa fa-check" aria-hidden="true"></i> Bài viết ưa thích
					</button>
				</span>
			</div>

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
				<div class="box-input d-flex">
					<input type="text" class="flex-grow-1 mr-2"
						style="height: 32px; padding: 5px;" placeholder="Viết bình luận" v-model="comment"/>
					<button class="buttom-comment" v-on:click="commentPost">Bình luận</button>
				</div>
				<ul class="comments-list">
					<li class="comment" v-for="comment in comments">
						<a class="pull-left" href="#"> 
							<img
								class="avatar" src="http://bootdey.com/img/Content/user_1.jpg"
								alt="avatar" />
						</a>
						<div class="comment-body">
								<div class="comment-heading">
									<h4 class="user">{{comment.user.fullName}}</h4>
									<h5 class="time">{{comment.created}}</h5>
								</div>
								<p>{{comment.comment}}</p>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<div class="box">
			<div class="box-title">Bài viêt ngẫu nhiên</div>
			<div class="box-cm">
				<c:forEach var="item" items="${views}">
					<div class="cm">
						<div class="cm-img">
							<a href="<c:url value='/post?id=${item.id}' />"><img
								src="${item.thumbnail}" alt=""></a>
						</div>
						<div class="cm-title">
							<a href="<c:url value='/post?id=${item.id}' />">
								${item.title}</a>
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
<script>
	new Vue({
		el: "#postDetail",
		data: {
			isFavorite : true,
			comments: [],
			comment: '',
			username : '${USERMODEL.username}',
		},
		mounted: function () {
			this.getFavorite();
			this.getComments();
		},
		methods: {
			getFavorite(){
				
					axios
					.get("${pageContext.request.contextPath}/api/favorite?postId=${postDetail.id}")
					.then((res) => {
						this.isFavorite = (res.data === 0) ? false : true;
					})
					.catch((error) => {
					console.log(error);
					});
				
			},
			setFavorite(){
				if(!!this.username){
					axios
					.post("${pageContext.request.contextPath}/api/favorite?postId=${postDetail.id}")
					.then((res) => {
						console.log(res);
					})
					.catch((error) => {
					console.log(error);
					}).finally(() => {this.getFavorite()});
				}else{
					window.location.href = "${pageContext.request.contextPath}/login";
				}
			},
			deleteFavorite(){
				axios
				.delete("${pageContext.request.contextPath}/api/favorite?postId=${postDetail.id}")
				.then((res) => {
					console.log(res);
				})
				.catch((error) => {
				console.log(error);
				}).finally(() => {this.getFavorite()});
			},
			getComments(){
				axios
				.get("${pageContext.request.contextPath}/api/comment?postId=${postDetail.id}")
				.then((res) => {
					this.comments = res.data.length === 0 ? [] : res.data; 
					console.log('Comments', res);
				})
				.catch((error) => {
				console.log(error);
				});
			},
			commentPost(){
				if(!!this.username){
					if(this.comment.length === 0) return;
					const url = "${pageContext.request.contextPath}/api/comment?postId=${postDetail.id}";
					axios
					.post(url, {comment: this.comment})
					.then((res) => {
						console.log(res);
					})
					.catch((error) => {
					console.log(error);
					}).finally(() => {this.getComments()});
				}else{
					window.location.href = "${pageContext.request.contextPath}/login";
				}
			}
			
		}
	});
</script>