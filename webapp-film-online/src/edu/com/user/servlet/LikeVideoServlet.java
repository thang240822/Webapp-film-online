package edu.com.user.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.com.dao.FavoriteDAO;
import edu.com.model.Favorite;
import edu.com.model.User;
import edu.com.model.Video;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;
import edu.com.utils.SessionUtils;

/**
 * Servlet implementation class FavoriteVideoServlet
 */
@WebServlet("/FavoriteVideoServlet")
public class LikeVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LikeVideoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!SessionUtils.isLogin(request)) {
			response.sendRedirect("LoginServlet");
			return;
		}
		String videoID = request.getParameter("videoID");
		try {
			FavoriteDAO fdao = new FavoriteDAO();

			Favorite favorite = new Favorite();
			Video video = new Video();
			video.setId(videoID);
			favorite.setVideo(video);

			String userID = SessionUtils.getLoginUsername(request);
			User user = new User();
			user.setId(userID);
			favorite.setUser(user);
			favorite.setLikeDate(new Date());
			if (fdao.isLike(userID, videoID)) {
				fdao.unLike(userID, videoID);
			} else {
				fdao.insertLike(favorite);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("HomeServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
