package edu.com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "Videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "Video.themVideo", procedureName = "sp_insertVideo", resultClasses = {
			Video.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class),
					@StoredProcedureParameter(name = "title", type = String.class),
					@StoredProcedureParameter(name = "poster", type = String.class),
					@StoredProcedureParameter(name = "view", type = Integer.class),
					@StoredProcedureParameter(name = "description", type = String.class),
					@StoredProcedureParameter(name = "active", type = Boolean.class) }),

	@NamedStoredProcedureQuery(name = "Video.capnhapVideo", procedureName = "sp_update_video", resultClasses = {
			Video.class }, parameters = { @StoredProcedureParameter(name = "title", type = String.class),
					@StoredProcedureParameter(name = "poster", type = String.class),
					@StoredProcedureParameter(name = "view", type = Integer.class),
					@StoredProcedureParameter(name = "description", type = String.class),
					@StoredProcedureParameter(name = "active", type = Boolean.class),
					@StoredProcedureParameter(name = "id", type = String.class) }),
		

	@NamedStoredProcedureQuery(name = "Video.xoaVideo", procedureName = "sp_xoaVideos", resultClasses = {
			Video.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class) }),

	@NamedStoredProcedureQuery(name = "Video.selectVideobyID", procedureName = "SP_videoID", resultClasses = {
			Video.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class) }),

	@NamedStoredProcedureQuery(name = "Video.selectVideoAll", procedureName = "SP_selectAllVideo", resultClasses = {
			Video.class }),
	
	@NamedStoredProcedureQuery(name="Video.timkiembytitle",procedureName ="sp_timvideobytitle" ,
	resultClasses = Video.class, parameters = @StoredProcedureParameter(type =String.class,name="title")
	),

})
public class Video {
	@Id
	String id;
	String title;
	String poster;
	String description;
	Integer views = 0;
	Boolean active = true;
	@OneToMany(mappedBy = "video")
	List<Favorite> favorites;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

}
