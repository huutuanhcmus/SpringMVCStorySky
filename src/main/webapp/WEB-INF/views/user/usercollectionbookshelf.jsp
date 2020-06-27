<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var ="NewURL" value="/chinh-sua-tap-truyen"/>
<c:url var ="AddURL" value="/them-tap-truyen"/>
<c:url var ="ThisURL" value="/danh-sach-tap-truyen"/>
<c:url var ="DelURL" value="/xoa-tap-truyen"/>
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
					<th scope="col">${story.nameStory}</th>
					<th scope="col"><i onclick="add()" data-toggle="tooltip" title="Thêm tập truyện mới" class='fas fa-plus' style='font-size:24px'></i></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${collectionStory.listResult}">
					<tr>
						<th onclick="CollectionStory(${item.idCollectionStory})"
							scope="col">${item.nameCollectionStory}</th>
						<th scope="col">
							<i onclick="change(${item.idStory},${item.idCollectionStory})" data-toggle="tooltip"title="Chỉnh sửa" class="material-icons">system_update_alt</i>
							<i onclick="deleteStory(${item.idStory},${item.idCollectionStory})" id="delete" data-toggle="tooltip" title="Xóa tập truyện" class="material-icons">delete</i> 
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<script>
		function add(){
			window.location.href = "${AddURL}?idStory=${story.idStory}";
		}
		function change(idStory, idCollectionStory) {
			window.location.href = "${NewURL}?idStory="+idStory+"&idCollectionStory="+idCollectionStory;
		}
		function deleteStory(idStory, idCollectionStory){
			var data = {};
			if(idStory != -1){
				data["idStory"] = idStory;
				data["idCollectionStory"] = idCollectionStory;
			}
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
					window.location.href = "${ThisURL}?idStory="+result.idStory+"&alert="+result.alert+"&message="+result.message;
				},
				error : function(error) {
					window.location.href = "${ThisURL}?idStory="+error.idStory+"&alert="+error.alert+"&message="+error.message;
				}
			});
		}
	</script>
</body>
</html>