<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-updateStory" />
<c:url var="NewURL" value="/ke-sach" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="formSubmit">
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-default">Tên
					truyện</span>
			</div>
			<input type="text" class="form-control" aria-label="Default"
				aria-describedby="inputGroup-sizing-default"
				value="${story.nameStory}" name="nameStory">
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Thể
					loại</label>
			</div>
			<select class="custom-select" id="inputGroupSelect01"
				name="idCategory">
				<option selected>Lựa chọn</option>
				<c:forEach var="item" items="${category.listResult}">
					<option value="${item.idCategory}"
						<c:if test="${item.idCategory == story.idCategory}">selected</c:if>>${item.nameCategory}</option>
				</c:forEach>
			</select>
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-default">Hình
					ảnh</span>
			</div>
			<input type="text" class="form-control" aria-label="Default"
				aria-describedby="inputGroup-sizing-default"
				value="${story.imageStory}" name="imageStory">
		</div>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">Giới thiệu</span>
			</div>
			<textarea class="form-control" aria-label="With textarea"
				name="introduceStory">${story.introduceStory}</textarea>
		</div>
		<c:if test="${story.idStory != -1}">
			<input type="button" class="btn btn-white btn-warning btn-bold"
			value="Chỉnh sửa" id="btnUpdateStory" />
		</c:if>
		<c:if test="${story.idStory == -1}">
			<input type="button" class="btn btn-white btn-warning btn-bold"
			value="Thêm truyện mới" id="btnUpdateStory" />
		</c:if>
	</form>
	<script>
		$('#btnUpdateStory').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			if(${story.idStory} != -1)
				data["idStory"] = ${story.idStory};
			updateStory(data);
		});
		
		

		function updateStory(data) {
			$.ajax({
				url : '${APIurl}',
				type : '${action}',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${NewURL}?alert="+result.alert+"&message="+result.message;
				},
				error : function(error) {
					window.location.href = "${NewURL}?alert="+error.alert+"&message="+error.message;
				}
			});
		}
	</script>
</body>
</html>