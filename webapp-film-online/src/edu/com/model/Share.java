package edu.com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Shares database table.
 * 
 */
@Entity
@Table(name="Shares")
@NamedQuery(name="Share.findAll", query="SELECT s FROM Share s")
@NamedStoredProcedureQuery(name = "Share.Video" , procedureName = "sp_share",resultClasses = {Share.class},
parameters = {@StoredProcedureParameter(name="userid",type = String.class),
		@StoredProcedureParameter(name="videoid",type = String.class),
		@StoredProcedureParameter(name="email",type = String.class),
		@StoredProcedureParameter(name="shareDate",type = Date.class)

})
public class Share implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private Date shareDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="videoID")
	private Video video;

	public Share() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getShareDate() {
		return this.shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Share(int id, String email, Date shareDate, User user, Video video) {
		super();
		this.id = id;
		this.email = email;
		this.shareDate = shareDate;
		this.user = user;
		this.video = video;
	}

}