<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Anime Hay</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--Liên kết đến font-awesome-->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<!--Liên kết với fontawesome-->
<link rel="stylesheet" href="../fontawesome-free-5.15.4-web/css/all.css">

<style>
.carousel-inner {
	height: 400px;
}

.container {
	background-color: #888888;
	border-radius: 5px;
}

#chuchay {
	height: 35px;
}

#chuchay p {
	line-height: 35px;
	font-size: 20px;
	color: #98FB98;
	font-weight: bold;
}
</style>
<!-- đuờng dẫn cơ sở để mọi đường link trong trang wed có thể tham chiếu tới -->
<base href="/Assignment/" />

<link rel="icon" href="images/sha.png" type="image/x-icon">

</head>

<body>
	<main class="container"> <!--bìa--> <header class="row">
		<div class="col">
			<div class="corousel">
				<div id="carouselExampleFade" class="carousel slide carousel-fade"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="images/do.jpg" height="400px" class="d-block w-100"
								alt="...">
						</div>
						<div class="carousel-item">
							<img src="images/go.jpg" height="400px" class="d-block w-100"
								alt="...">
						</div>
						<div class="carousel-item">
							<img src="images/ki.jpg" height="400px" class="d-block w-100"
								alt="...">
						</div>
						<div class="carousel-item">
							<img src="images/kaneki.jpg" height="400px" class="d-block w-100"
								alt="...">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-target="#carouselExampleFade" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-target="#carouselExampleFade" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</button>
				</div>

			</div>
		</div>
		<!-- 		<div class="col-1 text-right"> -->
		<!-- 			<img src="images/logo.png" width="100%" height="130px" alt="" -->
		<!-- 				class="mr-2"> -->
		<!-- 		</div> -->
	</header> <!--menu--> <fmt:setLocale value="en" /> <c:if test="${lang=='vi'}">
		<fmt:setLocale value="vi" />
	</c:if> <fmt:setBundle basename="I18N.lang.glolol" />
	<nav class="row">
		<nav
			class=" col navbar navbar-expand-lg navbar-#FFFAFA bg-light smoke"
			style="border-radius: 5px">
			<a class="navbar-brand" href="#"><img src="images/akasuki.png"
				width="60px" height="30px"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class="nav-item "><a class="nav-link" href="HomeServlet">
							<i class="fa fa-home"></i> <fmt:message key="title.home" /> <span
							class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="ContactServlet">
							<i class="fa fa-info-circle"></i> <fmt:message
								key="title.contact" />
					</a></li>
<%-- 					<c:if test="${admin==true}"> --%>
<!-- 						<li class="nav-item"><a class="nav-link" -->
<%-- 							href="UserManagementServlet"> <i class="fa fa-id-card"></i> <fmt:message --%>
<%-- 									key="title.manage" /> --%>
<!-- 						</a></li> -->
<%-- 					</c:if> --%>
<%-- 					<c:if test="${admin==true}"> --%>
<!-- 						<li class="nav-item"><a class="nav-link" -->
<%-- 							href="VideoManagementServlet"> <i class="fas fa-film"></i> <fmt:message --%>
<%-- 									key="title.Video" /> --%>
<!-- 						</a></li> -->
<%-- 					</c:if> --%>
					<c:if test="${ isLogin}">
					<c:if test="${admin==true}">
						<li class="nav-item"><a class="nav-link"
							href="UserManagementServlet"> <i class="fa fa-id-card"></i> <fmt:message
									key="title.manage" />
						</a></li>
					</c:if>
					<c:if test="${admin==true}">
						<li class="nav-item"><a class="nav-link"
							href="VideoManagementServlet"> <i class="fas fa-film"></i> <fmt:message
									key="title.Video" />
						</a></li>
					</c:if>
						<li class="nav-item"><a class="nav-link"
							href="FavoriteVideoServlet"> <i class="fa fa-heart"></i> <fmt:message
									key="title.favorite" />
						</a></li>
					</c:if>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdownID"
						role="button" data-toggle="dropdown" aria-expanded="false"> <i
							class="fa fa-user-circle"></i> <fmt:message key="title.account" />
					</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<c:if test="${! isLogin}">
								<a class="dropdown-item" href="LoginServlet"> <fmt:message
										key="title.login" /></a>
								<a class="dropdown-item" href="ForgotpasswordServlet"> <fmt:message
										key="title.forgotpass" /></a>
								<a class="dropdown-item" href="RegistrationServlet"> <fmt:message
										key="title.register" /></a>
							</c:if>
							<c:if test="${ isLogin}">
								<a class="dropdown-item" href="LogoffServlet"> <fmt:message
										key="title.logoff" /></a>
								<a class="dropdown-item" href="EditprofileServet"> <fmt:message
										key="title.editprofile" /></a>
								<a class="dropdown-item" href="ChangepasswordSevlet"> <fmt:message
										key="title.changepassWord" /></a>
							</c:if>
						</div></li>
					
				</ul>
			</div>

			<c:if test="${ isLogin}">
				<form class="form-inline my-2 my-lg-0" action="SearchServlet"
					method="post">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Tìm kiếm tên phim" aria-label="Search" name="title">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</c:if>
		</nav>
	</nav>
	<c:if test="${isLogin}">
		<div class="row">
			<form>
				<div id="chuchay">
					<marquee>
						<p>CHÀO MỪNG BẠN ĐẾN VỚI WEBSITE PHIM CỦA TÔI CHÚC BẠN
							CÓ 1 BUỔI XEM PHIM VUI VẺ </p>
					</marquee>
				</div>
			</form>
		</div>
	</c:if> <!--nội dung-->
	<section class="row">
		<jsp:include page="${page.section}"></jsp:include>
	</section>
	<footer class="row">
		<div class="col">
			<footer class="bg-light text-center text-white">
				<!-- Grid container -->
				<div class="container p-4 pb-0">
					<!-- Section: Social media -->
					<section class="mb-4">
						<!-- Facebook -->
						<a class="btn btn-primary btn-floating m-1"
							style="background-color: #3b5998;"
							href="https://www.facebook.com/profile.php?id=100045956112834"
							role="button"><i class="fa fa-facebook-f"></i></a>

						<!-- Twitter -->
						<a class="btn btn-primary btn-floating m-1"
							style="background-color: #55acee;"
							href="https://www.youtube.com/channel/UCeOB496NpMemwaah47hmIag"
							role="button"><i class="fa fa-youtube"></i></a>

						<!-- Google -->
						<a class="btn btn-primary btn-floating m-1"
							style="background-color: #dd4b39;"
							href="https://www.google.com/intl/vi/gmail/about/" role="button"><i
							class="fa fa-google"></i></a>


					</section>

				</div>
				<!-- Grid container -->

				<!-- Copyright -->
				<div class="spinner-grow text-secondary" role="status">
					<span class="visually-hidden"></span>
				</div>
				<div class="spinner-grow text-success" role="status">
					<span class="visually-hidden"></span>
				</div>
				<div class="spinner-grow text-danger" role="status">
					<span class="visually-hidden"></span>
				</div>
				<div class="spinner-grow text-warning" role="status">
					<span class="visually-hidden"></span>
				</div>
				<div class="spinner-grow text-info" role="status">
					<span class="visually-hidden"></span>
				</div>
				<div class="spinner-grow text-light" role="status">
					<span class="visually-hidden"></span>
				</div>
				<div class="spinner-grow text-dark" role="status">
					<span class="visually-hidden"></span>
				</div>
				<div class="text-center p-3"
					style="background-color: rgba(0, 0, 0, 0.2);">
					© 2021 JAVA 4: <a class="text-white"
						href="https://mdbootstrap.com/">DHĐ</a>
				</div>
				<!-- Copyright -->
			</footer>
		</div>
	</footer> </main>
	<!-- Option 2: Separate Popper and Bootstrap JS -->

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.min.js"
		integrity="sha384-VHvPCCyXqtD5DqJeNxl2dtTyhF78xXNXdkwX1CZeRusQfRKp+tA7hAShOK/B/fQ2"
		crossorigin="anonymous">
		
	</script>
	<%--     <c:if test="${not empty page.scriptUrl}"> --%>
	<%--     <jsp:include page="${page.scriptUrl}"></jsp:include>     --%>
	<%--     </c:if> --%>
</body>

</html>