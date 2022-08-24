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
import edu.com.utils.CookieUtils;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;
import edu.com.utils.SessionUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = CookieUtils.get("id", request);
		String password = CookieUtils.get("password", request);
		request.setAttribute("id", username);
		request.setAttribute("password", password);
		SessionUtils.add("id", username, request);
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_LOGIN_PAGE);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(isvalidate(request, response)) {
			try {
				String id= request.getParameter("id");
				String password= request.getParameter("password");
				String remember= request.getParameter("remember");
				UserDAO userdao = new UserDAO();
				User user = userdao.chekckLogin(id,password);
				if (id.equalsIgnoreCase(user.getId())&& password.equals(user.getPassword())) {
					SessionUtils.add("id",id, request);
					if (remember != null) {
						CookieUtils.add("id", id, 24, response);
						CookieUtils.add("password", password, 24, response);
					} else {
						CookieUtils.add("id", id, 0, response);
						CookieUtils.add("password", password, 0, response);
					}
					request.setAttribute("isLogin", true);
					request.setAttribute("admin", user.getAdmin());
					request.getRequestDispatcher("HomeServlet").forward(request, response);
					return;
				}
				request.setAttribute("error", "Username or Password fail!!!");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
		}
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_LOGIN_PAGE);
	}
    boolean isvalidate(HttpServletRequest request, HttpServletResponse response) {
    	String id= request.getParameter("id");
		String password= request.getParameter("password");
		String remember= request.getParameter("remember");
    	if(id.length()==0) {
    		request.setAttribute("error", "UserName Khong Duoc Trong!!!");
    		return false;
    	}
    	if(password.length()==0) {
    		request.setAttribute("error", "Password Khong Duoc Trong!!!");
    		return false;
    	}
    	return true;
    }
}
