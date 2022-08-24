package edu.com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.com.dao.VideoDAO;
import edu.com.model.Video;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String title=request.getParameter("title");
			VideoDAO vdao= new VideoDAO();
			List<Video> vlist = vdao.findUserIDByEmail(title);
			request.setAttribute("video", vlist);
		}catch(Exception e) {
			e.printStackTrace();
		}
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_HOME_PAGE);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
