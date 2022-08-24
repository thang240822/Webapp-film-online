package edu.com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import edu.com.dao.UserDAO;
import edu.com.model.User;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;
import edu.com.utils.SessionUtils;

/**
 * Servlet implementation class EditprofileServet
 */
@WebServlet("/EditprofileServet")
public class EditprofileServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_EDITPROFILE_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(isvalidate(request, response)) {
			try {
				User user = new User();
				BeanUtils.populate(user, request.getParameterMap());
				UserDAO userdao = new UserDAO();
				User userOld = userdao.findByID(user.getId());
				userdao.editProfile(user);
				request.setAttribute("user", user);
				request.setAttribute("mess", "CHỈNH SỬA THÀNH CÔNG!!!");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "CHỈNH SỬA THẤT BẠI!!!");
			}
		}
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_EDITPROFILE_PAGE);
	}
	boolean isvalidate(HttpServletRequest request, HttpServletResponse response) {
        String username=request.getParameter("id");
        String password=request.getParameter("password");
        String fullname=request.getParameter("fullname");
        String email=request.getParameter("email");
   	if(username.length()==0) {
   		request.setAttribute("error", "UserName Khong Duoc Trong!!!");
   		return false;
   	}
   	if(password.length()==0) {
   		request.setAttribute("error", "Password Khong Duoc Trong!!!");
   		return false;
   	}
   	if(fullname.length()==0) {
   		request.setAttribute("error", "Fullname Khong Duoc Trong!!!");
   		return false;
   	}
   	if(email.length()==0) {
   		request.setAttribute("error", "Email Khong Duoc Trong!!!");
   		return false;
   	}
   	return true;
   }
}
