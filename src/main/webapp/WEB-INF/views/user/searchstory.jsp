<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="SearchURL" value="/tim-kiem" />
<c:url var="CollectionStoryURL" value="/truyen" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ AAAAAAA</title>
</head>
<body>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Tên truyện</th>
					<th scope="col">Giới thiệu</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${story.listResult}">
					<tr>
						<th onclick="collectionstory(${item.idStory})" scope="col">${item.nameStory}</th>
						<th onclick="collectionstory(${item.idStory})" scope="col">${item.introduceStory}</th>

					</tr>
				</c:forEach>
			</tbody>
		</table>


	<script>
		function image(idStory) {
			$('#idstory').val(idStory);
			$('#formSubmit').submit();
		}
		function collectionstory(idStory) {
			window.location.href = "${CollectionStoryURL}?idStory="+idStory;
		}
	</script>
</body>
</html>