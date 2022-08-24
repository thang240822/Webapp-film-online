package edu.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import edu.com.model.Favorite;
import edu.com.model.repport.FavoriteByUserReport;
import edu.com.model.repport.FavoriteReport;
import edu.com.utils.JpaUtils;

public class ThongKeDAO {
	EntityManager em = JpaUtils.getEntityManager();
//	public List<FavoriteByUserReport> RreportUserByFvideo(String videoID) {
//		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("favorite.thongkeuserbyFV");
//		query.setParameter("videoID", videoID);
//		return query.getResultList();
//	}
//
//	public List<FavoriteReport> countFavorite() {
//		StoredProcedureQuery query = em.createNamedStoredProcedureQuery("favorite.thongke");
//		return query.getResultList();
//	}

	public List<FavoriteReport> FavoriteReport() {
		String jpql = "select new edu.com.model.repport.FavoriteReport(f.video.title,count(f),min(f.likeDate),max(f.likeDate)) from Favorite f group by f.video.title";
		TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
		return query.getResultList();
	}

	public List<FavoriteByUserReport> RreportUserByFvideo(String videoID) {
		String jpql = "select new edu.com.model.repport.FavoriteByUserReport(f.user.id,f.user.fullname,f.user.email,f.likeDate) from Favorite f where f.video.id =:videoID";
		TypedQuery<FavoriteByUserReport> query = em.createQuery(jpql, FavoriteByUserReport.class);
		query.setParameter("videoID", videoID);
		return query.getResultList();

	}

}
