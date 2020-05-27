<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@include file="/common/taglib.jsp"%>
<div id="wrapper">
  <div class="mainx">
    <div class="box">
      <div class="box-big">
        <div class="big">
          <a href="">
            <img
              src="https://gamek.mediacdn.vn/zoom/399_262/133514250583805952/2020/5/16/dtcl-15896404965281210844039.jpg"
              alt=""
            />
          </a>
          <div class="bv">
            <span>
              <i class="fa fa-calendar-minus-o" aria-hidden="true"></i>
              15 phút trước
            </span>
            <br />
            <a href="">Top game online tuyệt hay cho ngày nghỉ cuối tuần nay</a>
            <p>
              Grand Theft Auto IV (hay GTA 4) là phần thứ 4 của series GTA nhập
              vai thế giới mở nổi tiếng, game được mô tả là...
            </p>
          </div>
        </div>
        <div class="big">
          <a href="">
            <img
              src="https://gamek.mediacdn.vn/zoom/278_262/133514250583805952/2020/5/16/photo-1-15896316878072119420394.jpg"
              alt=""
            />
          </a>
          <div class="bv">
            <span>
              <i class="fa fa-calendar-minus-o" aria-hidden="true"></i>
              15 phút trước
            </span>
            <br />
            <a href=""
              >Top game online tuyệt hay cho ngày nghỉ cuối tuần nay nay ne ne
              ne ne enn en en thứ 4 của series GTA nhập vai thế g</a
            >
            <p>
              Grand Theft Auto IV (hay GTA 4) là phần thứ 4 của series GTA nhập
              vai thế giới mở nổi tiếng, game được mô tả là...
            </p>
          </div>
        </div>
      </div>
      <div class="box-small">
        <div class="small">
          <a href="">
            <img
              src="https://gamek.mediacdn.vn/zoom/399_163/133514250583805952/2020/5/16/46-468129mafia-graves-by-aynoe-hd-wallpaper-fan-art-15896189733892115037536.jpg"
              alt=""
            />
          </a>
          <div class="bv">
            <span>
              <i class="fa fa-calendar-minus-o" aria-hidden="true"></i>
              15 phút trước
            </span>
            <br />
            <a href="">Top game online tuyệt hay cho ngày nghỉ cuối tuần nay</a>
          </div>
        </div>
        <div class="small">
          <a href="">
            <img
              src="https://gamek.mediacdn.vn/zoom/192_129/133514250583805952/2020/5/16/creepy-pokemon-creepy-wallpapers-1907035309-15896479710702013196583.jpg"
              alt=""
            />
          </a>
          <div class="bv">
            <span>
              <i class="fa fa-calendar-minus-o" aria-hidden="true"></i>
              15 phút trước
            </span>
            <br />
            <a href="">Top game online tuyệt hay cho ngày nghỉ cuối tuần nay</a>
          </div>
        </div>
        <div class="small">
          <a href="">
            <img
              src="https://gamek.mediacdn.vn/zoom/192_129/133514250583805952/2020/5/16/photo-1-15896444843111753436229.jpg"
              alt=""
            />
          </a>
          <div class="bv">
            <span>
              <i class="fa fa-calendar-minus-o" aria-hidden="true"></i>
              15 phút trước
            </span>
            <br />
            <a href="">Top game online tuyệt hay cho ngày nghỉ cuối tuần nay</a>
          </div>
        </div>
      </div>
    </div>
    <div class="box" id="section-components">
      <div class="box-title">
        <i class="fa fa-gamepad" aria-hidden="true"> Bài viết mới</i>
      </div>
      <div class="box-post" v-for="post in data">
        <div class="img">
          <a v-bind:href="post.url">
            <img
              v-bind:src="post.thumbnail"
              v-bind:alt="post.title"
              v-bind:title="post.title"
            />
          </a>
          <p>{{post.category}}</p>
        </div>
        <div class="bv">
          <div class="bv-title">
            <a v-bind:href="post.url" v-bind:title="post.title">{{
              post.title
            }}</a>
          </div>
          <div class="bv-dangboi">
            <p>
              <i class="fa fa-user-circle" aria-hidden="true"></i>
              {{ post.createdBy }}
            </p>
            <p>
              <i class="fa fa-calendar-minus-o" aria-hidden="true"></i>
              {{ post.created }}
            </p>
            <!-- <p><i class="fa fa-eye"></i>1000</p> -->
          </div>
          <div class="bv-gioithieu">{{ post.description }}</div>
        </div>
        <a v-bind:href="post.url">Xem chi tiết »</a>
      </div>
      <div class="phantrang" v-if="!hidden">
        <button
          v-if="!loading"
          class="d-flex d-align-items cursor-pointer"
          v-on:click="getPost"
        >
          <i class="fa fa-arrow-circle-o-down mr-2 icon" aria-hidden="true"></i>
          Xem thêm
        </button>
        <button v-if="loading" class="d-flex d-align-items" disabled>
          <span
            class="spinner-border spinner-border-sm mr-2"
            role="status"
            aria-hidden="true"
          ></span
          >Vui lòng chờ...
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
      this.loading = true;
      axios
        .get(
          "${pageContext.request.contextPath}/api/home?page=" +
            this.pageable.page +
            "&size=" +
            this.pageable.size
        )
        .then((response) => {
        	console.log(response);
          this.data = response.data.map((data) => {
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
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => (this.loading = false));
    },
    methods: {
      getPost: function () {
        this.loading = true;
        this.pageable.page++;
        axios
          .get(
            "${pageContext.request.contextPath}/api/home?page=" +
              this.pageable.page +
              "&size=" +
              this.pageable.size
          )
          .then((response) => {
            if (response && response.length) {
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
                  url: "${pageContext.request.contextPath}/post?id=" + data.id,
                };
              });
              this.data.push(...result);
            } else {
              this.hidden = true;
            }
          })
          .catch((error) => {
            console.log(error);
          })
          .finally(() => (this.loading = false));
      },
    },
  });
</script>
