<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
	
	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="styles.css">
	
<div class="offset-2 col-8 mt-3">
	<form action="RegistrationServlet" method="post">
		<div class="card" style="background-color: #C0C0C0;color:white; box-shadow: 0 0 5px aqua;">
			<div class="card-header">
				<b>Registration</b>
			</div>
			<div class="card-body">
          <jsp:include page="/display/thongbao.jsp"></jsp:include>
				<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" name="id" placeholder="username">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" name="fullname" placeholder="Fullname">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" name="password" placeholder="password">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="email" class="form-control" name="email" placeholder="Email">
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-outline-primary">Sign Up</button>
				<button class="btn btn-outline-warning"><a href="LoginServlet">Login</a></button>
				
			</div>
		</div>
	</form>
</div>