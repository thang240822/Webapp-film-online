package edu.com.utils;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	// pageRoute định nghĩa dánh sách địa chỉ cần include vào trang layout.jsp
	public static Map<PageType, PageInfo> pageRoute = new HashedMap();
	// thêm các thành phần vào cho pageroute
	static {
		// trang dành cho admin
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("/admin/users/users.jsp"));// nội dung cần include vào
																								// trang layout
		pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("/admin/reports/reports.jsp"));
		pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("/admin/videos/videos.jsp"));

		// trang danh cho user
		pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("/user/home/home.jsp"));
		pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("/user/users/login.jsp"));
		pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("/user/users/registration.jsp"));
		pageRoute.put(PageType.SITE_CHANGEPASSWORD_PAGE, new PageInfo("/user/users/changepassword.jsp"));
		pageRoute.put(PageType.SITE_FORGOTPASSWORD_PAGE, new PageInfo("/user/users/forgotpassword.jsp"));
		pageRoute.put(PageType.SITE_EDITPROFILE_PAGE, new PageInfo("/user/users/editprofile.jsp"));
		pageRoute.put(PageType.SITE_FAVORITE_PAGE, new PageInfo("/user/videos/favorite.jsp"));
		pageRoute.put(PageType.SITE_SHARE_PAGE, new PageInfo("/user/videos/share.jsp"));
		pageRoute.put(PageType.SITE_CONTACT_PAGE, new PageInfo("/user/users/contact.jsp"));
	}

	// chuyển nội dung đến cho trang layout.jsp (admin)
	public static void ForWardToLayoutAdmin(HttpServletRequest request, HttpServletResponse response, PageType pagetype)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pagetype);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
	}

	// chuyển nội dung đến cho trang layout.jsp (user)
	public static void ForWardToLayoutSite(HttpServletRequest request, HttpServletResponse response, PageType pagetype)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pagetype);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/user/layout.jsp").forward(request, response);
	}

	private String section;

	public PageInfo(String section) {
		this.section = section;
	}

	public PageInfo() {
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
