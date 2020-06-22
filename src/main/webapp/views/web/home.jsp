<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="wrapper">
	<div class="mainx">
		<div class="box">
			<div class="box-big">
				<c:forEach var="post" items="${views}" varStatus="loop">
					<c:if test="${loop.index < 2}">
						<div class="big">
							<a href="<c:url value='post?id=${post.id}'/>"> <img
								src="${post.thumbnail}" alt="" />
							</a>
							<div class="bv">
								<span> <i class="fa fa-calendar-minus-o"
									aria-hidden="true"></i> ${post.created}
								</span> <br /> <a href="<c:url value='post?id=${post.id}'/>">${post.title}</a>
								<p>${post.description}</p>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div class="box-small">
				<c:forEach var="post" items="${views}" varStatus="loop">
					<c:if test="${loop.index >= 2}">
						<div class="small">
							<a href="<c:url value='post?id=${post.id}'/>"> <img
								src="${post.thumbnail}" alt="" />
							</a>
							<div class="bv">
								<span> <i class="fa fa-calendar-minus-o"
									aria-hidden="true"></i> ${post.created}
								</span> <br /> <a href="<c:url value='post?id=${post.id}'/>">${post.title}</a>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="box" id="section-components">
			<div class="box-title">
				<i class="fa fa-gamepad" aria-hidden="true"> Bài viết mới</i>
			</div>
			<div class="box-post" v-for="post in data">
				<div class="img">
					<a v-bind:href="post.url"> <img v-bind:src="post.thumbnail"
						v-bind:alt="post.title" v-bind:title="post.title" />
					</a>
					<p>{{ post.category }}</p>
				</div>
				<div class="bv">
					<div class="bv-title">
						<a v-bind:href="post.url" v-bind:title="post.title">{{
							post.title }}</a>
					</div>
					<div class="bv-dangboi">
						<p>
							<i class="fa fa-user-circle" aria-hidden="true"></i> {{
							post.createdBy }}
						</p>
						<p>
							<i class="fa fa-calendar-minus-o" aria-hidden="true"></i> {{
							post.created }}
						</p>
						<!-- <p><i class="fa fa-eye"></i>1000</p> -->
					</div>
					<div class="bv-gioithieu">{{ post.description }}</div>
				</div>
				<a v-bind:href="post.url">Xem chi tiết »</a>
			</div>
			<div class="phantrang" v-if="!hidden">
				<button v-if="!loading" class="d-flex d-align-items cursor-pointer"
					v-on:click="getPost">
					<i class="fa fa-arrow-circle-o-down mr-2 icon" aria-hidden="true"></i>
					Xem thêm
				</button>
				<button v-if="loading" class="d-flex d-align-items" disabled>
					<span class="spinner-border spinner-border-sm mr-2" role="status"
						aria-hidden="true"></span>Vui lòng chờ...
				</button>
			</div>
		</div>
		<!-- end box -->
	</div>
	<!-- Sidebar -->
	<%@ include file="/common/web/sidebar.jsp"%>
	<!-- end Sidebar -->
</div>
<script type="text/javascript">
  new Vue({
    el: "#section-components",
    data: {
      loading: false,
      hidden: false,
      data: [],
      pageable: {
        page: 1,
        size: 5,
      },
    },
    mounted: function () {
    	const url = "${pageContext.request.contextPath}/api/home?page=" + this.pageable.page + "&size=" + this.pageable.size
        this.getPostCommon(url);
    },
    methods: {
      getPost: function () {
        this.pageable.page++;
        const url = "${pageContext.request.contextPath}/api/home?page=" + this.pageable.page + "&size=" + this.pageable.size
        this.getPostCommon(url);
      },
      getPostCommon: function (url) {
          this.loading = true;
          axios
            .get(url)
            .then((response) => {
              if (response.data.length < this.pageable.size) {
            	  this.hidden = true;
              }
              var result = response.data.map((data) => {
                  return {
                    categoryId: data.categoryId,
                    content: data.content,
                    created: data.created,
                    createdBy: data.createdBy,
                    description: data.description,
                    id: data.id,
                    thumbnail: data.thumbnail,
                    title: data.title,
                    category: data.category.name,
                    url: "${pageContext.request.contextPath}/post?id=" + data.id,
                  };
                });
                this.data = [...this.data, ...result];
            })
            .catch((error) => {
              console.log(error);
            })
            .finally(() => (this.loading = false));
        },
    },
  });
</script>
