package edu.com.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.com.model.Share;
import edu.com.model.User;
import edu.com.model.Video;
import edu.com.utils.JpaUtils;

public class ShareDAO  {
	EntityManager em = JpaUtils.getEntityManager();
	public void insert(Share share) {
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.persist(share);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			em.close();
		}
		
	}

}


























