package edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.com.model.Favorite;
import edu.com.model.Share;
import edu.com.model.User;
import edu.com.utils.JpaUtils;

public class FavoriteDAO {

	EntityManager em = JpaUtils.getEntityManager();

	public void insertLike(Favorite fa) {
		try {
			em.getTransaction().begin();
			em.persist(fa);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void unLike(String userid,String videoid) {
		String jpql="select f from Favorite f where f.user.id=:uid and f.video.id=:vid";
		TypedQuery<Favorite>q=em.createQuery(jpql,Favorite.class);
		q.setParameter("uid", userid);
		q.setParameter("vid", videoid);
		if(q.getResultList().size()>0) {
			try {
				em.getTransaction().begin();
				em.remove(em.merge(q.getResultList().get(0)));
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				em.getTransaction().rollback();
			} finally {
				em.close();
			}
		}
	}
		public boolean isLike(String userid,String videoid) {
			String jpql="select f from Favorite f where f.user.id=:uid and f.video.id=:vid";
			TypedQuery<Favorite>q=em.createQuery(jpql,Favorite.class);
			q.setParameter("uid", userid);
			q.setParameter("vid", videoid);
			return q.getResultList().size()>0;
	}


}
