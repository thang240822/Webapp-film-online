<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-2 col-8 mt-2">
	<form action="EditprofileServet" method="post">
		<div class="card" style="background-color: #C0C0C0;color:white; box-shadow: 0 0 5px aqua	;">
			<div class="card-header">
				<b>Edit Profile</b>
			</div>
			<div class="card-body">
			<jsp:include page="/display/thongbao.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" name="id" id="username" value="${user.id}"
								aria-describedby="usernameId" placeholder="Username" > <small
								id="usernameId" class="form-text text-light">Nhap
								Username!!!</small>
						</div>
						<div class="form-group">
							<label for="fullname">Fullname</label> <input type="text"
								class="form-control" name="fullname" id="fullname" value="${user.fullname}"
								aria-describedby="fullnameId" placeholder="Fullname" > <small
								id="fullnameId" class="form-text text-light">Nhap
								Fullname!!!</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="password">PassWord</label> <input type="password"
								class="form-control" name="password" id="password" value="${user.password}"
								placeholder="Password" >
								<small class="form-text text-light">Nhap
								PassWord!!!</small>
						</div>
						<div class="form-group">
							<label for="email">Email Address</label> <input type="email"
								class="form-control" name="email" id="email" value="${user.email}"
								aria-describedby="emailId" placeholder="Email" > <small
								id="emailId" class="form-text text-light">Nhap Email!!!</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-warning">UPDATE</button>
			</div>
		</div>
	</form>
</div>
