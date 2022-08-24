package edu.com.utils;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import edu.com.dao.UserDAO;
import edu.com.model.User;
import edu.com.utils.JpaUtils;

public class RegistrationServiceUnitTest {
EntityManager em = JpaUtils.getEntityManager();
	
	
	UserDAO udao = new UserDAO();
	static int count, index;
	@Rule
	public ErrorCollector ec = new ErrorCollector();

	@BeforeClass
	public static void OpenConnect() {

	}

	public int countUser() {
		int temp = 0;
		try {
			List<User> u = udao.findbyAll();
			temp = u.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Before
	public void beforeUser() {
		count = countUser();
		System.out.println(count);
	}

	@Test
	public void testSignup1() {
		try {
			User user = new User();
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testSignup2() {
		try {
			em.isOpen();
			User user = new User();
			user.setId("");
			user.setPassword("123456");
			user.setFullname("na");
			user.setEmail("vtk@fpt.edu.vn");
			user.setAdmin(false);
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null user: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}
	
	@Test
	public void testSignup3() {
		try {
			User user = new User();
			user.setId("dang01");
			user.setFullname("Na Van el");
			user.setPassword("090");
			user.setEmail("vtk@fpt.edu.vn");
			user.setAdmin(false);
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null pass: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void testSignup4() {
		try {
			User user = new User();
			user.setId("now");
			user.setPassword("now01");
			user.setFullname("");
			user.setEmail("vtk@fpt.edu.vn");
			user.setAdmin(false);
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null FullName: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}
	
	@Test
	public void testSignup5() {
		try {
			User user = new User();
			user.setId("no1");
			user.setPassword("123456");
			user.setFullname("nall");
			user.setEmail("");
			user.setAdmin(false);
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null Email: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}
	
	@Test
	public void testSignup6() {
		try {
			User user = new User();
			user.setId("");
			user.setPassword("123456");
			user.setFullname("nall");
			user.setEmail("vtk");
			user.setAdmin(false);;
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check sai định dạng Email: " + e));
		}
		index = countUser();
		assertEquals(index, count);
	}
	
	@Test
	public void testSignup7() {
		try {
			User user = new User();
			user.setId("no1");
			user.setPassword("123456");
			user.setFullname("nkj");
			user.setEmail("vtk@fpt.edu.vn");
			user.setAdmin(true);
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Check đầy đủ thông tin: " + e));
		}
		index = countUser();
		
	}
	
	@After
	public void afterUser() {
		System.out.println(count);
	}

	@AfterClass
	public static void CloseConnect() {
		
	}
}
