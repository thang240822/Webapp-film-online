package edu.com.user.servlet;

import java.io.IOException;
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

import edu.com.dao.UserDAO;
import edu.com.model.User;
import edu.com.utils.PageInfo;
import edu.com.utils.PageType;

/**
 * Servlet implementation class ForgotpasswordServlet
 */
@WebServlet("/ForgotpasswordServlet")
public class ForgotpasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_FORGOTPASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String from = request.getParameter("email");
		String to = request.getParameter("email");
		String password = request.getParameter("password");
		Properties pro = new Properties();
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.starttls.enable", "true");
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.port", 587);
		Session session = Session.getDefaultInstance(pro, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			// to
			message.setRecipients(javax.mail.Message.RecipientType.TO, to);
			UserDAO udao = new UserDAO();
			User user = udao.findemail(from);
			// tiêu đề
			message.setSubject("Your Pasword");
			// nội dung
			message.setText("Password:"+user.getPassword());
			// gửi đi
			Transport.send(message);
			request.setAttribute("mess", "Gui Thanh Cong.Vui Long Check Mail!!!");
			PageInfo.ForWardToLayoutSite(request, response, PageType.SITE_FORGOTPASSWORD_PAGE);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
