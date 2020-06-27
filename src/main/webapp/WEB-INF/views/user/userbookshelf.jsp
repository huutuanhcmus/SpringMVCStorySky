<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var ="NewURL" value="/chinh-sua"/>
<c:url var ="AddURL" value="/them-truyen"/>
<c:url var ="ThisURL" value="/ke-sach"/>
<c:url var ="DelURL" value="/xoa-truyen"/>
<c:url var ="CollectionStoryURL" value="/danh-sach-tap-truyen"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty message.message}">
		<div class="alert alert-${message.alert}">
  			${message.message}
		</div>
	</c:if>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Truyện của tôi</th>
				<th scope="col"><i onclick="add()" data-toggle="tooltip" title="Thêm truyện mới" class='fas fa-plus' style='font-size:24px'></i></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${story.listResult}">
				<tr>
					<th onclick="collectionstory(${item.idStory})" scope="col">${item.nameStory}</th>
					<th scope="col">
						<i onclick="change(${item.idStory})" data-toggle="tooltip"title="Chỉnh sửa" class="material-icons">system_update_alt</i>
						<i onclick="deleteStory(${item.idStory})" id="delete" data-toggle="tooltip" title="Xóa truyện" class="material-icons">delete</i> 
					</th>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		function collectionstory(idStory) {
			window.location.href = "${CollectionStoryURL}?idStory="+idStory;
		}
		function change(idStory) {
			window.location.href = "${NewURL}?idStory="+idStory;
		}
		function add(){
			window.location.href = "${AddURL}";
		}
		function deleteStory(idStory){
			var data = {};
			if(idStory != -1)
				data["idStory"] = idStory;
			deleteStoryItem(data);
		}
		
		function deleteStoryItem(data) {
			$.ajax({
				url : '${DelURL}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result) {
					window.location.href = "${ThisURL}?alert="+result.alert+"&message="+result.message;
				},
				error : function(error) {
					window.location.href = "${ThisURL}?alert="+error.alert+"&message="+error.message;
				}
			});
		}
	</script>
</body>
</html>