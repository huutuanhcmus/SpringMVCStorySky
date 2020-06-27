<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-updatecollectionstory" />
<c:url var="NewURL" value="/danh-sach-tap-truyen" />

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
				<span class="input-group-text" id="inputGroup-sizing-default">Tên tập
					truyện</span>
			</div>
			<input type="text" class="form-control" aria-label="Default"
				aria-describedby="inputGroup-sizing-default"
				value="${collectionstory.nameCollectionStory}" name="nameCollectionStory">
		</div>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text">Nội dung</span>
			</div>
			<textarea class="form-control" aria-label="With textarea" id="content"
				name="contentCollectionStory">${collectionstory.contentCollectionStory}</textarea>
		</div>
		<c:if test="${collectionstory.idCollectionStory != -1}">
			<input type="button" class="btn btn-white btn-warning btn-bold"
			value="Chỉnh sửa" id="btnUpdateStory" />
		</c:if>
		<c:if test="${collectionstory.idCollectionStory == -1}">
			<input type="button" class="btn btn-white btn-warning btn-bold"
			value="Thêm truyện mới" id="btnUpdateStory" />
		</c:if>
	</form>
	<script>
		var editor = '';
		$(document).ready(function(){
			editor = CKEDITOR.replace( 'content');
		});
		
		$('#btnUpdateStory').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				data["" + v.name + ""] = v.value;
			});
			data["idStory"] = ${collectionstory.idStory};
			if(${collectionstory.idCollectionStory} != -1){
				data["idCollectionStory"] = ${collectionstory.idCollectionStory};
			}
			data["contentCollectionStory"] = editor.getData();
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
					window.location.href = "${NewURL}?idStory="+result.idStory+"&alert="+result.alert+"&message="+result.message;
				},
				error : function(error) {
					window.location.href = "${NewURL}?idStory="+error.idStory+"&alert="+error.alert+"&message="+error.message;
				}
			});
		}
	</script>
</body>
</html>