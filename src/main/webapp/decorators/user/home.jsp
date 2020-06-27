<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="SearchURL" value="/tim-kiem" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="<c:url value='/template/user/assets/img/favicon.ico' />" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value='/template/user/css/styles.css' />"
	rel="stylesheet" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="<c:url value='/template/ckeditor/ckeditor.js' />"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/19.1.1/classic/ckeditor.js"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/common/user/header.jsp"%>
	<!-- header -->
	<!-- Masthead-->
	<header class="masthead bg-primary text-white text-center">
		<div class="container d-flex align-items-center flex-column">
			<!-- Masthead Avatar Image-->
			<img class="masthead-avatar mb-5" src="assets/img/avataaars.svg"
				alt="" />
			<!-- Masthead Heading-->
			<h1 class="masthead-heading text-uppercase mb-0">Chào mừng quý
				độc giả đến với thư viện truyện miễn phí</h1>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Masthead Subheading-->
			<p class="masthead-subheading font-weight-light mb-0">Chúc quý
				độc giả đọc truyện vui vẻ</p>
		</div>
	</header>
	<!-- body -->
	<section class="page-section portfolio" id="portfolio">
		<div class="container">
			<dec:body />
		</div>
	</section>

	<!-- body -->

	<!-- footer -->
	<%@ include file="/common/user/footer.jsp"%>
	<!-- footer -->

	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Contact form JS-->
	<script
		src="<c:url value='/template/user/assets/mail/jqBootstrapValidation.js' />"></script>
	<script
		src="<c:url value='/template/user/assets/mail/contact_me.js' />"></script>
	<!-- Core theme JS-->
	<script src="<c:url value='/template/user/js/scripts.js' />"></script>
	<script>
	function btnsearch(idStory) {
		var data = {};
		window.location.href = "${SearchURL}?search="+$('#searchform').val();
	}
	</script>
</body>
</html>