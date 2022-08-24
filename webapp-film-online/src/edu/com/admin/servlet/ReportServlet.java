package edu.com.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.com.dao.ThongKeDAO;
import edu.com.dao.VideoDAO;
import edu.com.model.Favorite;
import edu.com.model.Video;
import edu.com.model.repport.FavoriteReport;
import edu.com.model.repport.FavoriteByUserReport;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReportServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReportFavorite(request, response);
		ReportUserByFavoriteVideo(request, response);
		PageInfo.ForWardToLayoutAdmin(request, response, PageType.REPORT_MANAGEMENT_PAGE);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void ReportFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ThongKeDAO tdao =new ThongKeDAO();
			List<FavoriteReport>list= tdao.FavoriteReport();
			request.setAttribute("favorite", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void ReportUserByFavoriteVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String videoID = request.getParameter("videoID");
			VideoDAO vdao= new VideoDAO();
			List<Video>videoList= vdao.findbyAll();
			ThongKeDAO tdao = new ThongKeDAO();
			List<FavoriteByUserReport>list= tdao.RreportUserByFvideo(videoID);
			request.setAttribute("videoID", videoID);
			request.setAttribute("videoList", videoList);
			request.setAttribute("favoriteUsers", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}



































