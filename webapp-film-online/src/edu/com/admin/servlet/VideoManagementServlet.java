package edu.com.admin.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import edu.com.dao.UserDAO;
import edu.com.dao.VideoDAO;
import edu.com.model.User;
import edu.com.model.Video;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;

/**
 * Servlet implementation class VideoManagementServlet
 */
@WebServlet({ "/VideoManagementServlet", "/VideoManagementServlet/create", "/VideoManagementServlet/update",
		"/VideoManagementServlet/delete", "/VideoManagementServlet/edit", "/VideoManagementServlet/reset" })
@MultipartConfig
public class VideoManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("edit")) {
			edit(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {

		}
		FindAll(request, response);
		PageInfo.ForWardToLayoutAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String url = request.getRequestURL().toString();
		if (url.contains("create")) {
			insert(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {

		}
		FindAll(request, response);
		PageInfo.ForWardToLayoutAdmin(request, response, PageType.VIDEO_MANAGEMENT_PAGE);

	}

	protected void FindAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VideoDAO vdao = new VideoDAO();
			List<Video> list = vdao.findbyAll();
			request.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VideoDAO vdao = new VideoDAO();
			String videoID = request.getParameter("id");
			Video video = vdao.findByID(videoID);
			request.setAttribute("EditVideo", video);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isvalidate(request, response)) {
			try {
				VideoDAO dao = new VideoDAO();
				Video video = new Video();
				File dir = new File(request.getServletContext().getRealPath("/fileAnh"));
				if (!dir.exists()) {
					dir.mkdirs();
				}
				System.out.println("" + dir);
				Part photo = request.getPart("poster");
				File photofile = new File(dir, photo.getSubmittedFileName());
				photo.write(photofile.getAbsolutePath());
				video.setPoster(photofile.getName());
				BeanUtils.populate(video, request.getParameterMap());
				dao.insert(video);
				request.setAttribute("mess", "Them thanh cong!!!");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Error:" + e.getMessage());
			}
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VideoDAO dao = new VideoDAO();
			Video video = new Video();
			File dir = new File(request.getServletContext().getRealPath("/fileAnh"));
			if (!dir.exists()) {
				dir.mkdirs();
			}
			System.out.println("" + dir);
			Part photo = request.getPart("poster");
			File photofile = new File(dir, photo.getSubmittedFileName());
			photo.write(photofile.getAbsolutePath());
			video.setPoster(photofile.getName());
			BeanUtils.populate(video, request.getParameterMap());
			// khong duoc phep cap nhap id
			dao.findByID(video.getId());
			dao.update(video);
			request.setAttribute("mess", "Cap nhat thanh cong!!!");
			request.setAttribute("EditVideo", video);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Cap nhat that bai!!!");
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VideoDAO dao = new VideoDAO();
			String videoID = request.getParameter("id");
			dao.delete(videoID);
			request.setAttribute("mess", "Xoa thanh cong!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
	}
	boolean isvalidate(HttpServletRequest request, HttpServletResponse response) {
		String poster = request.getParameter("poster");
		String videoid = request.getParameter("id");
		String title = request.getParameter("title");
		String views = request.getParameter("views");
		String description = request.getParameter("description");
		if (videoid.length() == 0) {
			request.setAttribute("error", "VideoID Khong Duoc Trong!!!");
			return false;
		}
		if (title.length() == 0) {
			request.setAttribute("error", "Title Khong Duoc Trong!!!");
			return false;
		}
		if (views.length() == 0) {
			request.setAttribute("error", "views Khong Duoc Trong!!!");
			return false;
		}
		try {
			Integer.parseInt(views);
		} catch (Exception e) {
			request.setAttribute("error", "Views Phai La Nguyen!!!");
			return false;
		}
		if (description.length() == 0) {
			request.setAttribute("error", "Description Khong Duoc Trong!!!");
			return false;
		}
		return true;
	}
}
