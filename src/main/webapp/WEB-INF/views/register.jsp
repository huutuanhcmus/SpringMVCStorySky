<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/newaccount" />
<c:url var="NewURL" value="/dang-nhap" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<c:if test="${not empty message}">
							<div class="alert alert-${alert}">${message}</div>
						</c:if>
						<h5 class="card-title text-center">Đăng ký</h5>
						<form id="formSubmit">
							<div class="form-label-group">
								<input type="text" value="" name="fullname" class="form-control"
									placeholder="Họ và tên" required autofocus> <label>Họ
									và tên</label>
							</div>
							<div class="form-label-group">
								<input type="text" value="" name="username" id="inputEmail"
									class="form-control" placeholder="Tên tài khoảng" required
									autofocus> <label for="inputEmail">Tên tài
									khoảng</label>
							</div>
							<div class="form-label-group">
								<input type="password" value="" name="password"
									id="inputPassword" class="form-control" placeholder="Mật khẩu"
									required> <label for="inputPassword">Mật khẩu</label>
							</div>
							<div class="btn btn-lg btn-primary btn-block text-uppercase"
								id="btnUpdateStory">Đăng ký</div>
							<hr class="my-4">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
	$('#btnUpdateStory').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			updateStory(data);
	});
		
		function updateStory(data) {
			$.ajax({
				url : '${APIurl}',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${NewURL}?message=" + "Tạo tài khoảng thành công";
				},
				error : function(error) {
					window.location.href = "${NewURL}?message=" + "Tạo tài khoảng thất bại";
				}
			});
		}
	</script>
</body>
</html>