<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@include file="/common/taglib.jsp"%>
<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form action="#">
      <h1>Đăng ký</h1>
      <div class="social-container">
        <a href="#" class="social"
          ><i
            class="fa fa-google-plus"
            style="color: #d6492f;"
            aria-hidden="true"
          ></i
        ></a>
      </div>
      <span>or use your email for registration</span>
      <input type="text" placeholder="Name" />
      <input type="email" placeholder="Email" />
      <input type="password" placeholder="Password" />
      <button>Đăng ký</button>
    </form>
  </div>
  <div class="form-container sign-in-container">
    <form action="<c:url value='/login'/>" method="POST">
      <div class="logo">
        <a href="">
          <img src="<c:url value='/assets/web/images/logo.png' />" alt="" />
        </a>
      </div>
      <h1>Đăng nhập</h1>
      <div class="social-container">
        <a href="#" class="social"
          ><i
            class="fa fa-google-plus"
            style="color: #d6492f;"
            aria-hidden="true"
          ></i
        ></a>
      </div>
	  <span>or use your account</span>
	  <!-- <c:if test="${not empty message}">
					<div class="alert alert-${alert}">
							${message}
					</div>
				</c:if> -->
      <input type="text" placeholder="Username" name="username" />
      <input type="password" placeholder="Password" name="password" />
      <a href="#">Quên mật khẩu?</a>
      <button>Đăng nhập</button>
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>Welcome Back!</h1>
        <p>To keep connected with us please login with your personal info</p>
        <button class="ghost" id="signIn">Đăng nhập</button>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>Hello, Friend!</h1>
        <p>Enter your personal details and start journey with us</p>
        <button class="ghost" id="signUp">Đăng ký</button>
      </div>
    </div>
  </div>
</div>
<script>
  const signUpButton = document.getElementById("signUp");
  const signInButton = document.getElementById("signIn");
  const container = document.getElementById("container");
  signUpButton.addEventListener("click", () => {
    container.classList.add("right-panel-active");
  });
  signInButton.addEventListener("click", () => {
    container.classList.remove("right-panel-active");
  });
</script>
