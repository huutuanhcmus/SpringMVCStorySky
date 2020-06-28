<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/updateStory" />
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
				value="${story.name}" name="name">
		</div>
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<label class="input-group-text" for="inputGroupSelect01">Thể
					loại</label>
			</div>
			<select class="custom-select" id="inputGroupSelect01"
				name="category_id">
				<option selected>Lựa chọn</option>
				<c:forEach var="item" items="${category.listResult}">
					<option value="${item.id}"
						<c:if test="${item.id == story.id}">selected</c:if>>${item.name}</option>
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
				value="${story.image}" name="image">
		</div>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">Giới thiệu</span>
			</div>
			<textarea class="form-control" aria-label="With textarea"
				name="introduce">${story.introduce}</textarea>
		</div>
		<c:if test="${story.id != -1}">
			<input type="button" class="btn btn-white btn-warning btn-bold"
			value="Chỉnh sửa" id="btnUpdateStory" />
		</c:if>
		<c:if test="${story.id == -1}">
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
			if(${story.id} != -1)
				data["id"] = ${story.id};
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
					window.location.href = "${NewURL}?alert="+result.message.alert+"&message="+result.message.message;
				},
				error : function(error) {
					window.location.href = "${NewURL}?alert="+error.message.alert+"&message="+error.message.message;
				}
			});
		}
	</script>
</body>
</html>