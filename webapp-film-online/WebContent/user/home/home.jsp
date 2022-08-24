<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-9">
	<div class="row p-2">
		<c:if test="${isLogin}">
		
			<c:forEach var="item" items="${video}">
				<div class="col-3 mt-2">
					<div class="card text-center" style="background-color: #F5F5F5;">
						
							 <img src="/Assignment/fileAnh/${item.poster}" width="100%" height="200px">

							</img>
							<div class="row" style="color: #7FFFD4; justify-content: center;">
								<b>${item.title}</b>
							</div>
						
						<div class="card-footer">
							<a href="FavoriteVideoServlet?videoID=${item.id}"
								class="btn btn-outline-info"> <c:if
									test="${item.favorites == null || item.favorites.size() ==0}">
							Like</a>
		</c:if>
		<c:if test="${item.favorites != null && item.favorites.size() >0}">
									UnLike</a>
		</c:if>
		<a href="ShareVideoServlet?videoID=${item.id}"
			class="btn btn-outline-success">Share</a>
	</div>
</div>
</div>
</c:forEach>
</div>
</div>
<div class="col-3">
	<div class="row mt-3 mb-3">
		<div class="col">
			<div class="card" data-toggle="collapse" href="#listphim">
				<div class="card-header bg-green "
					style="color: green; cursor: pointer">
					<i class="fa fa-list-alt"></i> Phim Mới Cập Nhật
				</div>
				<c:forEach var="item" items="${video}">
					<ul
						class="list-group-item list-group-item-action list-group-item-success"
						id="listphim">
						<li class="list-group-item">${item.title}</li>
					</ul>
				</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
</div>