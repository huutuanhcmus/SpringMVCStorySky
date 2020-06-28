<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value='/tap-truyen'/>" id="formSubmit" method="get">
		<input type="hidden" value="${story.id}" id="idstory"
			name="idStory" /> <input type="hidden" value=""
			id="idcollectionstory" name="idCollectionStory" />
		<div align="middle">
			<img class="img" align="middle" src="${story.image}"
				alt="Los Angeles" width="auto" height="500" align="middle">
		</div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">${story.name}</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${story.collectionStoryList}">
					<tr>
						<th onclick="CollectionStory(${item.id})"
							scope="col">${item.name}</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<script>
		function CollectionStory(idCollectionStory) {
			$('#idcollectionstory').val(idCollectionStory);
			$('#formSubmit').submit();
		}
	</script>
</body>
</html>