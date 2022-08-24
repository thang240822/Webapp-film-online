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
			aria-selected="true">Video Editing</a></li>
		<!--hiển thị thông tin các video ở trên bảng-->
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">Video List</a></li>

	</ul>
	<!--hiển thị nội dung của các tab-->
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="VideoManagementServlet" method="post"
				enctype="multipart/form-data">
				<div class="card">
					<div class="card-body">
						<jsp:include page="/display/thongbao.jsp"></jsp:include>
						<c:if test="${isLogin}">
						<div class="row">
							<div class="col-3">
								<div class="border p-3">
									<%--<img src="/DUAN1_QLPA//fileAnh/${EditVideo.poster}" alt="" class="img-fluid"> --%>
<!-- 									<video width="250px" height="400px" controls> -->
<%--                                         <source  src="/DuAn1_QLPA1//fileAnh/${EditVideo.poster}" type="video/mp4"  class="img-fluid"></video> --%>
                                     <!--chọn ảnh -->
                                    <img src="/Assignment/fileAnh/${EditVideo.poster}" width="100%" height="300px">
									<div class="custom-file">
										<label for="image" class="custom-file-label">Image/Video</label> <input
											type="file" class="custom-file-input" id="image"
											name="poster" />
									</div>
								</div>
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="youtube">Youtube Id</label> <input type="text" style="background-color: #E6E6FA; color: #32CD32"
										class="form-control" name="id" id="youtube"
										value="${EditVideo.id}" aria-describedby="youtubeId"
										placeholder="Youtube Id" > <small
										id="youtubeId" class="form-text text-muted">Nhap
										Youtube Id!!!</small>
								</div>
								<div class="form-group">
									<label for="videotitle">Video Title</label> <input type="text" style="background-color: #E6E6FA; color: #32CD32"
										class="form-control" name="title" id="videotitle"
										value="${EditVideo.title}" aria-describedby="videotitleId"
										placeholder="Video Title" > <small
										id="videotitleId" class="form-text text-muted">Nhap
										Video Title!!!</small>
								</div>
								<div class="form-group">
									<label for="viewcount">View Count</label> <input type="text" style="background-color: #E6E6FA; color: #32CD32"
										class="form-control" name="views" id="viewcount"
										value="${EditVideo.views}" aria-describedby="viewcountId"
										placeholder="View Count" > <small
										id="viewcountId" class="form-text text-muted">Nhap
										View Count!!!</small>
								</div>
								<div class="form-check form-check-inline">
									<label class="ml-2"> <input type="radio" id="status" style="background-color: #E6E6FA; color: #32CD32"
										name="active" value="true" class="form-check-input"
										${EditVideo.active?'checked':''}>Active
									</label> <label class="ml-2"> <input type="radio" id="status"
										name="active" value="false" class="form-check-input"
										${!EditVideo.active?'checked':''}>InActive
									</label>
								</div>
								<div class="form-group">
									<label for="description">Description</label> <input type="text" style="background-color: #E6E6FA; color: #32CD32"
										class="form-control" name="description" id="description"
										value="${EditVideo.description}"
										aria-describedby="descriptionId" placeholder="description"
										> <small id="descriptionId"
										class="form-text text-muted">Nhap Description!!!</small>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button formaction="VideoManagementServlet/create"
							class="btn btn-outline-primary">CREATE</button>
						<button formaction="VideoManagementServlet/update"
							class="btn btn-outline-success">UPDATE</button>
						<button formaction="VideoManagementServlet/delete"
							class="btn btn-outline-warning">DELETE</button>
						<button formaction="VideoManagementServlet/reset"
							class="btn btn-outline-danger">RESET</button>
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
							<td>Youtube Id</td>
							<td>Video Title</td>
							<td>View Count</td>
							<td>Status</td>
							<td>&nbsp;</td>
						</tr>
						<c:forEach var="item" items="${videos}">
							<tr>
								<td>${item.id}</td>
								<td>${item.title}</td>
								<td>${item.views}</td>
								<td>${item.active?'Active':'InActive'}</td>
								<td><a href="VideoManagementServlet/edit?id=${item.id}"><i
										class="fa fa-edit"></i>Edit</a> <a
									href="VideoManagementServlet/delete?id=${item.id}"><i
										class="fa fa-trash"></i>Delete</a></td>
							</tr>
						</c:forEach>
					</table>
					</c:if>
				</div>
			</div>
		</div>

	</div>
</div>