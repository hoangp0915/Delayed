<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div id="wrapper">
	<div class="mainx" id="category">
		<div class="box">
			<div class="box-title">
				<i class="fa fa-gamepad" aria-hidden="true"> ${category}</i>
			</div>
			<div class="box-post" v-for="post in data">
				<div class="img">
					<a v-bind:href="post.url"> <img v-bind:src="post.thumbnail"
						v-bind:alt="post.title" v-bind:title="post.title" />
					</a>
					<p>Thủ thuật</p>
				</div>
				<div class="bv">
					<div class="bv-title">
						<a v-bind:href="post.url">{{ post.title }}</a>
					</div>
					<div class="bv-dangboi">
						<p>
							<i class="fa fa-user-circle" aria-hidden="true"></i> {{
							post.created }}
						</p>
						<p>
							<i class="fa fa-calendar-minus-o" aria-hidden="true"></i> {{
							post.createdBy }}
						</p>
						<!-- <p><i class="fa fa-eye"></i>1000</p> -->
					</div>
					<div class="bv-gioithieu">{{ post.description }}</div>
				</div>
				<a v-bind:href="post.url">Xem chi tiết »</a>
			</div>
			<div class="box-post-notfound" v-if="data.length === 0">
				<h3>Không có dữ liệu</h3>
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
	<!-- end main -->
	<!-- Sidebar -->
	<%@ include file="/common/web/sidebar.jsp"%>
	<!-- end sidebar -->
</div>

<script type="text/javascript">
  new Vue({
    el: "#category",
    data: {
      data: [],
      loading: false,
      hidden: false,
      pageable: {
        page: 1,
        size: 5,
      },
      paramCategory: "${param.cat}",
      url: null,
    },
    mounted: function () {
      if (!!this.paramCategory) {
        this.url =
          "${pageContext.request.contextPath}/api/category?cat=${param.cat}&page=" +
          this.pageable.page +
          "&size=" +
          this.pageable.size;
      } else {
        this.url =
          "${pageContext.request.contextPath}/api/search?searchKey=${param.searchKey}&page=" +
          this.pageable.page +
          "&size=" +
          this.pageable.size;
      }
      this.getPostMounted(this.url);
    },
    methods: {
      getPostMounted(url) {
        this.loading = true;
        axios
          .get(url)
          .then((response) => {
            console.log(response);
            if (response.data.length < this.pageable.size) {
            	this.hidden = true;
            }
            const result = response.data.map((data) => {
                return {
                  categoryId: data.categoryId,
                  content: data.content,
                  created: data.created,
                  createdBy: data.createdBy,
                  description: data.description,
                  id: data.id,
                  thumbnail: data.thumbnail,
                  title: data.title,
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
      getPost: function () {
        this.pageable.page++;
        if (!!this.paramCategory) {
          this.url =
            "${pageContext.request.contextPath}/api/category?cat=${param.cat}&page=" +
            this.pageable.page +
            "&size=" +
            this.pageable.size;
        } else {
          this.url =
            "${pageContext.request.contextPath}/api/search?searchKey=${param.searchKey}&page=" +
            this.pageable.page +
            "&size=" +
            this.pageable.size;
        }
        this.getPostMounted(this.url);
      },
    },
  });
</script>
