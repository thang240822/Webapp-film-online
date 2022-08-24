package edu.com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.com.utils.CookieUtils;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;
import edu.com.utils.SessionUtils;

/**
 * Servlet implementation class LogoffServlet
 */
@WebServlet("/LogoffServlet")
public class LogoffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	CookieUtils.add("id", null, 0, resp);
    	CookieUtils.add("password", null, 0, resp);
    	SessionUtils.removeSession(req);
    	req.setAttribute("isLogin", false);
    	PageInfo.ForWardToLayoutSite(req, resp, PageType.SITE_LOGIN_PAGE);
    }
}
