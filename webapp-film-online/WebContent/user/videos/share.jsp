<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-3 col-6">
	<form action="ShareVideoServlet" method="post">
	<input type="hidden" name="videoID" value="${videoID}"/>
		<div class="card">
			<!--tieu de -->
			<div class="card-header">Send Video To Your Friends</div>
			<!--noi dung form nhap -->
			<div class="card-body">
			<jsp:include page="/display/thongbao.jsp"></jsp:include>
				<div class="form-group">
					<label for="email">Your Friends Email:</label> <input type="text"
						class="form-control" name="email" id="email"
						aria-describedby="emailhelpID" placeholder="emails"> <small
						id="emailhelpID" class="form-text text-muted">Nhap
						Email!!!</small>
				</div>
			</div>
			<!--nut gui -->
			<div class="card-footer">
				<button class="btn btn-success">Send</button>
			</div>
		</div>

	</form>
</div>