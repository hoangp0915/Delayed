<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title><dec:title default="Trang chủ" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Demo</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<c:url value='/assets/web/style/style.css' />">
	<link rel="stylesheet"
	href="<c:url value='/assets/web/style/posts.css' />">
<link rel="stylesheet"
	href="<c:url value='/assets/web/style/common.css' />">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed&amp;subset=latin,latin-ext,vietnamese"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<c:url value='/assets/vuejs/vue.min.js' />"></script>
<script type="text/javascript"
	src="<c:url value='https://cdnjs.cloudflare.com/ajax/libs/axios/0.19.2/axios.js' />"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->

	<div>
		<dec:body />
	</div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- footer -->
<!--<script href="<c:url value='/assets/web/script/script.js' />"></script>-->
</body>
</html>