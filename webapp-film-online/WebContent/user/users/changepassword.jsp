<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-6 offset-3 mt-1">
	<form action="ChangepasswordSevlet" method="post">
		<div class="card" style="background-color: #708090;color:white;">
			<div class="card-header">
				<b>Change Pass</b>
			</div>
			<div class="card-body">
			<jsp:include page="/display/thongbao.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" name="id" id="username"
								aria-describedby="usernameId" placeholder="Username" >
							<small id="usernameId" class="form-text text-light">Nhap
								Username!!!</small>
						</div>
						<div class="form-group">
							<label for="password">New Password</label> <input type="password"
								class="form-control" name="newPassWord" id="password"
								placeholder="Password" > <small
								class="form-text text-light">Nhap Mat Khau Moi!!!</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="currentpassword">Current Password</label> <input
								type="password" class="form-control" name="currenpassword"
								id="currentpassword" placeholder="Currentpassword" ><small
								class="form-text text-light">Nhap Mat Hien Tai!!!</small>
						</div>
						<div class="form-group">
							<label for="confirmpassword">Confirm Password</label> <input
								type="password" class="form-control" name="confirmPassWord"
								id="confirmpassword" placeholder="Confirmpassword" ><small
								class="form-text text-light">Nhap Lai Mat Khau Moi!!!</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-warning">Change Password</button>
			</div>
		</div>
	</form>
</div>