<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Sidebar -->
<div class="sideBar" id="sidebar">
	<div class="box">
		<div class="box-title">
			<i class="fa fa-bar-chart" aria-hidden="true"></i> Xem nhiều nhất
		</div>
		<div class="box-body" v-for="post in dataSidebar">
			<div class="img">
				<a v-bind:href="post.url"> <img v-bind:src="post.thumbnail"
					v-bind:alt="post.title" v-bind:title="post.title" />
				</a>
			</div>
			<div class="title">
				<a v-bind:href="post.url">{{post.title}}</a>
				<div class="time">
					<i class="fa fa-calendar-minus-o"></i> {{post.createdBy}}
				</div>
			</div>
		</div>

	</div>
	<div class="box">
		<div class="box-title">
			<i class="fa fa-check" aria-hidden="true"></i> Bài viết yêu thích
		</div>
		<div v-if="dataFavorite.length" class="box-body" v-for="post in dataFavorite">
			<div class="img">
				<a v-bind:href="post.url"> <img v-bind:src="post.thumbnail"
					v-bind:alt="post.title" v-bind:title="post.title" />
				</a>
			</div>
			<div class="title">
				<a v-bind:href="post.url">{{post.title}}</a>
				<div class="time">
					<i class="fa fa-calendar-minus-o"></i> {{post.createdBy}}
				</div>
			</div>
		</div>
		<div v-if="dataFavorite.length === 0" class="box-body-not-found">Không có dữ liệu</div>
	</div>
	<!-- <div class="box">
    <div class="box-title">TAG</div>
    <div class="box-tag">
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
  </div> -->
</div>
<script>
  new Vue({
    el: "#sidebar",
    data: {
      dataSidebar: [],
      dataFavorite: []
    },
    mounted: function () {
    	this.getData('dataFavorite', 'favorite');
    	this.getData('dataSidebar', 'sidebar');
    },
    methods: {
    	getData: function(name, action){
    		axios
            .get("${pageContext.request.contextPath}/api/home?action=" + action)
            .then((response) => {
              if(response.data !== null){
                this[name] = response.data.map((data) => {
                return {
                  created: data.created,
                  createdBy: data.createdBy,
                  description: data.description,
                  id: data.id,
                  thumbnail: data.thumbnail,
                  title: data.title,
                  url: "${pageContext.request.contextPath}/post?id=" + data.id,
                };
              });
              }
            });
    	}
    }
  });
</script>
