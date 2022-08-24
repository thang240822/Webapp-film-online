package edu.com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.com.dao.ShareDAO;
import edu.com.dao.UserDAO;
import edu.com.dao.VideoDAO;
import edu.com.model.Share;
import edu.com.model.User;
import edu.com.model.Video;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;
import edu.com.utils.SessionUtils;

/**
 * Servlet implementation class ShareVideoServlet
 */
@WebServlet("/ShareVideoServlet")
public class ShareVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ShareVideoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!SessionUtils.isLogin(request)) {
			response.sendRedirect("LoginServlet");
			return;
		}
		String videoID = request.getParameter("videoID");
		if (videoID == null) {
			response.sendRedirect("HomeServlet");
			return;
		}
		request.setAttribute("videoID", videoID);
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_SHARE_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String videoID = request.getParameter("videoID");
		String from = request.getParameter("email");
		String to = request.getParameter("email");
		Properties pro = new Properties();
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.starttls.enable", "true");
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.port", 587);
		Session session = Session.getDefaultInstance(pro, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "duyphuong205");
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			// to
			message.setRecipients(javax.mail.Message.RecipientType.TO, to);
			// tieu de
			VideoDAO vdao = new VideoDAO();
			Video video = vdao.findByID(videoID);
			User user = new User();
			message.setSubject("Gui Ban");
			// noi dung
			message.setText("Tieu De:" + video.getTitle() + "\nLuot Xem:" + video.getViews() + "\nThong Tin:"
					+ video.getDescription());
			// gui
			Transport.send(message);
			ShareDAO sdao = new ShareDAO();
			Share share = new Share();
			share.setEmail(to);
			share.setShareDate(new Date());
			String userID = SessionUtils.getLoginUsername(request);
			user.setId(userID);
			share.setUser(user);
			video.setId(videoID);
			share.setVideo(video);
			sdao.insert(share);
			request.setAttribute("mess", "Chia Se Video Thanh Cong!");
			PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_SHARE_PAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

}
