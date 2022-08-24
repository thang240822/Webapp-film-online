package edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.com.model.User;
import edu.com.utils.JpaUtils;

public class UserDAO {

	EntityManager em = JpaUtils.getEntityManager();

	public boolean signIn(User user) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.dangky");
			query.setParameter("id", user.getId());
			query.setParameter("fullname", user.getFullname());
			query.setParameter("password", user.getPassword());
			query.setParameter("email", user.getEmail());
			query.setParameter("admin", false);
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	public User chekckLogin(String username, String password) {
		try {
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.checklogin");
			query.setParameter("id", username);
			query.setParameter("password", password);
			return (User) query.getSingleResult();// tráº£ vá»� 1 Ä‘á»‘i tÆ°á»£ng
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insert(User user) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.themUser");
			query.setParameter("id", user.getId());
			query.setParameter("password", user.getPassword());
			query.setParameter("email", user.getEmail());
			query.setParameter("fullname", user.getFullname());
			query.setParameter("admin", user.getAdmin());
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	public boolean update(User user) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.capnhatUser");
			query.setParameter("password", user.getPassword());
			query.setParameter("email", user.getEmail());
			query.setParameter("fullname", user.getFullname());
			query.setParameter("admin", user.getAdmin());
			query.setParameter("id", user.getId());
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	public boolean changepassword(User user) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.changepass");
			query.setParameter("password", user.getPassword());
			query.setParameter("id", user.getId());
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	public boolean editProfile(User user) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.editthongtincanhan");
			query.setParameter("password", user.getPassword());
			query.setParameter("email", user.getEmail());
			query.setParameter("fullname", user.getFullname());
			query.setParameter("id", user.getId());
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	public void delete(String id) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.xoaUser");
			query.setParameter("id", id);
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

	}

	public List<User> findbyAll() {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.selectUserAll");
		return query.getResultList();
	}

	public User findByID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.selectUserbyID");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	public User findemail(String email) {
		EntityManager em = JpaUtils.getEntityManager();
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("User.forgorpass");
		query.setParameter("email", email);
		return (User) query.getSingleResult();
	}

}
