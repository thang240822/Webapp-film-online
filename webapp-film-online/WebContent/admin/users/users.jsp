<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col">
	<!-- để thực hiện đổi tab để hiển thị nội dung thì cần đến script #mytab -->
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<!--hiển thị thông tin các video lên trên form-->
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true">User Editing</a></li>
		<!--hiển thị thông tin các video ở trên bảng-->
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">User List</a></li>

	</ul>
	<!--hiển thị nội dung của các tab-->
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="UserManagementServlet" method="post">
				<div class="card">
					<div class="card-body">
					<jsp:include page="/display/thongbao.jsp"></jsp:include>
					<c:if test="${isLogin}">
					
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="username">Username</label> <input type="text" style="background-color: #E6E6FA; color: #32CD32"
										class="form-control" name="id" id="username" value="${EditUsers.id}"
										aria-describedby="usernameId" placeholder="Username" >
									<small id="usernameId" class="form-text text-muted">Nhap
										Username!!!</small>
								</div>
								<div class="form-group">
									<label for="fullname">Fullname</label> <input type="text" style="background-color: #E6E6FA; color: #32CD32"
										class="form-control" name="fullname" id="fullname" value="${EditUsers.fullname}"
										aria-describedby="fullnameId" placeholder="Fullname" >
									<small id="fullnameId" class="form-text text-muted">Nhap
										Fullname!!!</small>
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for="password">Password</label> <input type="password" style="background-color: #E6E6FA; color: #32CD32"
										class="form-control" name="password" id="password" value="${EditUsers.password}"
										aria-describedby="passwordId" placeholder="Password" >
									<small id="passwordId" class="form-text text-muted">Nhap
										Password!!!</small>
								</div>
								<div class="form-group">
									<label for="email">Email</label> <input type="email" style="background-color: #E6E6FA; color: #32CD32"
										class="form-control" name="email" id="email" value="${EditUsers.email}"
										aria-describedby="emailId" placeholder="Email" > <small
										id="emailId" class="form-text text-muted">Nhap
										Email!!!</small>
								</div>
								<div class="form-check form-check-inline">
									<label class="ml-2"> <input type="radio" id="status"
										name="admin" value="true" class="form-check-input"
										${EditUsers.admin?'checked':''}>Admin
									</label> <label class="ml-2"> <input type="radio" id="status"
										name="admin" value="false" class="form-check-input"
										${!EditUsers.admin?'checked':''}>User
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button formaction="UserManagementServlet/create" class="btn btn-outline-primary">CREATE</button>
						<button formaction="UserManagementServlet/update" class="btn btn-outline-success">UPDATE</button>
						<button formaction="UserManagementServlet/delete" class="btn btn-outline-danger">DELETE</button>
						<button formaction="UserManagementServlet/reset" class="btn btn-outline-dark">RESET</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			
			<div class="row">
				<div class="col">
					<!-- table.table.table-stripe -->
					<table class="table table-stripe">
						<tr>
							<td>Username</td>
							<td>Password</td>
							<td>Email</td>
							<td>Fullname</td>
							<td>Role</td>
							<td>&nbsp;</td>
						</tr>
						<c:forEach var="item" items="${users}">
						<tr>
							<td>${item.id}</td>
							<td>${item.password}</td>
							<td>${item.email}</td>
							<td>${item.fullname}</td>		
							<td>${item.admin?'Admin':'User'}</td>
							<td><a href="UserManagementServlet/edit?id=${item.id}"><i class="fa fa-edit"></i>Edit</a> <a
								href="UserManagementServlet/delete?id=${item.id}"><i class="fa fa-trash"></i>Delete</a></td>
						</tr>
						</c:forEach>
					</table>
					
					</c:if>
				</div>
			</div>
		</div>

	</div>
</div>