package edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.com.model.User;
import edu.com.model.Video;
import edu.com.utils.JpaUtils;

public class VideoDAO {

	EntityManager em = JpaUtils.getEntityManager();

	public boolean insert(Video video) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Video.themVideo");
			query.setParameter("id", video.getId());
			query.setParameter("title", video.getTitle());
			query.setParameter("poster", video.getPoster());
			query.setParameter("view", video.getViews());
			query.setParameter("description", video.getDescription());
			query.setParameter("active", video.getActive());
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
	public boolean update(Video video) {
		try {
			em.getTransaction().begin();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Video.capnhapVideo");
			
			query.setParameter("title", video.getTitle());
			query.setParameter("poster", video.getPoster());
			query.setParameter("view", video.getViews());
			query.setParameter("description", video.getDescription());
			query.setParameter("active", video.getActive());
			query.setParameter("id", video.getId());
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
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Video.xoaVideo");
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
	public List<Video> findbyAll() {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Video.selectVideoAll");
		return query.getResultList();
	}

	public Video findByID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Video.selectVideobyID");
		query.setParameter("id", id);
		return (Video) query.getSingleResult();
	}
	public List findUserIDByEmail(String title) {
		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Video.timkiembytitle");
		query.setParameter("title", "%" + title + "%");
		return query.getResultList();
	}
}
