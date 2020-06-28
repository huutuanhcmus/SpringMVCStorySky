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
	<div align="middle">
		<img class="img" align="middle" src="${story.image}"
			alt="Los Angeles" width="auto" height="500" align="middle">
	</div>
	<h3>${collectionStory.name}</h3>
	<p>${collectionStory.content}</p>
</body>
</html>