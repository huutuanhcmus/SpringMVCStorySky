<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- Navigation-->
<nav
	class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
	id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger"
			href="<c:url value="/trang-chu"/>">Story Sky</a>
		<button
			class="navbar-toggler navbar-toggler-right text-uppercase font-weight-bold bg-primary text-white rounded"
			type="button" data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fas fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<div class="form-inline d-flex justify-content-center md-form form-sm active-pink active-pink-2 mt-2">
					<i onclick="btnsearch()" class="fas fa-search" aria-hidden="true"></i> 
					<input id="searchform" class="form-control form-control-sm ml-3 w-75" type="text" placeholder="Tên truyện" aria-label="Search">
				</div>
				<c:if test="${not empty USERMODEL}">
					<li class="nav-item"><a class="nav-link"
						href='<c:url value="/ke-sach"/>'>Tủ sách của tôi</a></li>
					<li class="nav-item"><a class="nav-link" href='#'>Xin chào
							${USERMODEL.fullname}</a></li>
					<li class="nav-item"><a class="nav-link" type="post"
						href='<c:url value="/dang-xuat?action=logout"/>'>Thoát</a></li>
				</c:if>
				<c:if test="${empty USERMODEL}">
					<li class="nav-item"><a class="nav-link"
						href='<c:url value="/dang-nhap?action=login"/>'>Đăng nhập</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
