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
 * Servlet implementation class ChangepasswordSevlet
 */
@WebServlet("/ChangepasswordSevlet")
public class ChangepasswordSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isvalidate(request, response)) {
			try {

				String username = request.getParameter("id");
				String currenpassword = request.getParameter("currenpassword");
				String newpass = request.getParameter("newPassWord");
				String confirmpass = request.getParameter("confirmPassWord");
				UserDAO udao = new UserDAO();
				User user = udao.findByID(username);
				if (!user.getPassword().equals(currenpassword)) {
					request.setAttribute("error", "Mat Khau Hien Tai Khong Dung!!!");
				} else if (!confirmpass.equals(newpass)) {
					request.setAttribute("error", "2 Mat Khau khong Khop Nhau!!!");
				} else {
					user.setPassword(newpass);
					udao.changepassword(user);
					request.setAttribute("mess", "Doi Thanh Cong!!!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);
	}

	boolean isvalidate(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("id");
		String currenpassword = request.getParameter("currenpassword");
		String newpass = request.getParameter("newPassWord");
		String confirmpass = request.getParameter("confirmPassWord");
		if (username.length() == 0) {
			request.setAttribute("error", "UserName Khong Duoc Trong!!!");
			return false;
		}
		if (currenpassword.length() == 0) {
			request.setAttribute("error", "Password Hien Tai Khong Duoc Trong!!!");
			return false;
		}
		if (newpass.length() == 0) {
			request.setAttribute("error", "Password Moi Khong Duoc Trong!!!");
			return false;
		}
		if (confirmpass.length() == 0) {
			request.setAttribute("error", "Nhap Lai Password Khong Duoc Trong!!!");
			return false;
		}
		return true;
	}
}
