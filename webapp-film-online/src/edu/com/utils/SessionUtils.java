package edu.com.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.com.model.User;

public class SessionUtils {

	// lưu thông tin thuộc tính vào session
   public static void add(String name,String value,HttpServletRequest request) {
	   HttpSession session = request.getSession();
	   session.setAttribute(name, value);
   }
   //lấy giá trị của thuộc tính được truyền vào đối tượng sesion
   public static Object get(String name,HttpServletRequest request) {
	   HttpSession session = request.getSession();
	   return session.getAttribute(name);
	  
   }
   //xóa bỏ session
   public static void removeSession(HttpServletRequest request) {
	   HttpSession session = request.getSession();
	   session.removeAttribute("id");
	   session.invalidate();
   }
   // kiểm tra đã login chưa 
   public static boolean isLogin(HttpServletRequest request) {
	   //lấy giá trị userID ở trong session
	  return get("id", request) != null;
   }
   //trả về giá trị userID đã đăng nhập vào trong hệ thống
   public static String getLoginUsername(HttpServletRequest request) {
		  Object username=get("id", request);
		  if(username == null) {
			  return null;
		  }else {
			 return username.toString();
		  }
		  
	   }
}














