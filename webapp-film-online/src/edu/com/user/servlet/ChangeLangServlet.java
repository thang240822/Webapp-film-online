package edu.com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.com.utils.PageInfo;
import edu.com.utils.PageType;

/**
 * Servlet implementation class ChangeLangServlet
 */
@WebServlet(name = "/ChangeLangServlet", urlPatterns = { "/changelang" })
public class ChangeLangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lang = request.getParameter("lang");
		HttpSession session = request.getSession();
		// gán giá trị
		session.setAttribute("lang", lang);
		//chuyển hướng đến trang home
		response.sendRedirect("HomeServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
