<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ AAAAAAA</title>
</head>
<body>
	<form action="<c:url value='/truyen'/>" id="formSubmit" method="get">
		<input type="hidden" value="" id="idstory" name="idStory" />
		<c:forEach var="item" items="${categoryList.listResult}">
			<h1>${item.nameCategory}</h1>
			<div id="${item.codeCategory}" class="carousel slide"
				data-ride="carousel">
				<%--<ul class="carousel-indicators">
				<li data-target="#demo" data-slide-to="0" class="active"></li>
				<li data-target="#demo" data-slide-to="1"></li>
			</ul>--%>
				<ul class="carousel-indicators">
					<c:forEach var="item1" items="${item.listStory}" varStatus="count1">
						<li data-target="#${item.codeCategory}"
							data-slide-to="${count1.count-1}" class="active"></li>
					</c:forEach>
				</ul>
				<div class="carousel-inner">
					<c:forEach var="item1" items="${item.listStory}" varStatus="count">
						<c:if test="${count.count <= 1}">
							<div class="carousel-item active" align="middle">
								<img class = "img" onclick="image(${item1.idStory})" src="${item1.imageStory}"
									alt="Los Angeles" width="auto" height="500" align="middle">
								<div class="carousel-caption">
									<h5>${item1.nameStory}</h5>
									<p>${item1.introduceStory}</p>
								</div>

							</div>
						</c:if>
						<c:if test="${count.count > 1}">
							<div class="carousel-item" align="middle">
								<img  class = "img" onclick="image(${item1.idStory})"
									src="${item1.imageStory}" alt="Los Angeles" width="auto"
									height="500" align="middle">
								<div class="carousel-caption">
									<h5>${item1.nameStory}</h5>
									<p>${item1.introduceStory}</p>
								</div>
							</div>
						</c:if>

					</c:forEach>
				</div>
				<a class="carousel-control-prev" href="#${item.codeCategory}"
					data-slide="prev"> <span class="carousel-control-prev-icon"></span>
				</a> <a class="carousel-control-next" href="#${item.codeCategory}"
					data-slide="next"> <span class="carousel-control-next-icon"></span>
				</a>
			</div>
		</c:forEach>
	</form>
	<script>
		function image(idStory) {
			$('#idstory').val(idStory);
			$('#formSubmit').submit();
		}
	</script>
</body>
</html>