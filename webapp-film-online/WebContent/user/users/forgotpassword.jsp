<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-4 col-4">
	<form action="ForgotpasswordServlet" method="post">
		<div class="card mt-3"
			style="background-color: #C0C0C0;color:white; box-shadow: 0 0 5px aqua	;">
			<div class="card-header">
				<b>Forgot PassWord</b>
			</div>
			<div class="card-body">
				<jsp:include page="/display/thongbao.jsp"></jsp:include>
				<div class="form-group">
					<label for="email">Email</label> <input type="email"
						class="form-control" name="email" id="email" placeholder="Email"
						required><small id="emailId" class="form-text text-light">Nhap
						Email!!!</small>
				</div>
				<div class="form-group">
					<label for="username">Password Email</label> <input type="password"
						class="form-control" name="password" id="password"
						aria-describedby="passwordId" placeholder="password" required>
					<small id="passwordId" class="form-text text-light">Nhap
						Password Email!!!</small>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-outline-danger">Retrieve</button>
			</div>
		</div>
	</form>
</div>