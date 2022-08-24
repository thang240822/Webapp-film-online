package edu.com.user.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

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

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(isvalidate(request, response)) {
			try {
				User user = new User();
				BeanUtils.populate(user,request.getParameterMap());
				UserDAO udao =new UserDAO();
				udao.signIn(user);
				request.setAttribute("mess","Dang Ky Thanh Cong");
			}catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("error","Dang Ky That Bai!!!");
				
			}
		}
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_REGISTRATION_PAGE);
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

















