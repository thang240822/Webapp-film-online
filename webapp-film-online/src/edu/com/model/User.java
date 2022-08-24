package edu.com.model;


import javax.persistence.Entity;


import java.util.List;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;


@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "User.dangky", procedureName = "sp_register", resultClasses = {
			User.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class),
					@StoredProcedureParameter(name = "fullname", type = String.class),
					@StoredProcedureParameter(name = "password", type = String.class),
					@StoredProcedureParameter(name = "email", type = String.class),
					@StoredProcedureParameter(name = "admin", type = Boolean.class) }),

	@NamedStoredProcedureQuery(name = "User.checklogin", procedureName = "sp_login", resultClasses = User.class, parameters = {
			@StoredProcedureParameter(name = "id", type = String.class),
			@StoredProcedureParameter(name = "password", type = String.class) }),

	@NamedStoredProcedureQuery(name = "User.themUser", procedureName = "sp_insertUser", resultClasses = {
			User.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class),
					@StoredProcedureParameter(name = "password", type = String.class),
					@StoredProcedureParameter(name = "email", type = String.class),
					@StoredProcedureParameter(name = "fullname", type = String.class),
					@StoredProcedureParameter(name = "admin", type = Boolean.class) }),

	@NamedStoredProcedureQuery(name = "User.capnhatUser", procedureName = "sp_UpdateUser", resultClasses = {
			User.class }, parameters = { @StoredProcedureParameter(name = "password", type = String.class),
					@StoredProcedureParameter(name = "email", type = String.class),
					@StoredProcedureParameter(name = "fullname", type = String.class),
					@StoredProcedureParameter(name = "admin", type = Boolean.class),
					@StoredProcedureParameter(name = "id", type = String.class) }),

	@NamedStoredProcedureQuery(name = "User.editthongtincanhan", procedureName = "sp_editprofile", resultClasses = {
			User.class }, parameters = { @StoredProcedureParameter(name = "password", type = String.class),
					@StoredProcedureParameter(name = "email", type = String.class),
					@StoredProcedureParameter(name = "fullname", type = String.class),
					@StoredProcedureParameter(name = "id", type = String.class) }),

	@NamedStoredProcedureQuery(name = "User.xoaUser", procedureName = "sp_DeleteUser", resultClasses = {
			User.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class) }),

	@NamedStoredProcedureQuery(name = "User.selectUserbyID", procedureName = "sp_selectUserbyID", resultClasses = {
			User.class }, parameters = { @StoredProcedureParameter(name = "id", type = String.class) }),

	@NamedStoredProcedureQuery(name = "User.selectUserAll", procedureName = "sp_selectallUser", resultClasses = {
			User.class }),

	@NamedStoredProcedureQuery(name = "User.forgotpass", procedureName = "sp_forgotpass", resultClasses = User.class, parameters = {
			@StoredProcedureParameter(name = "id", type = String.class),
			@StoredProcedureParameter(name = "email", type = String.class) }),
	
	@NamedStoredProcedureQuery(name = "User.changepass", procedureName = "sp_doimk", resultClasses = User.class, parameters = {
			@StoredProcedureParameter(name = "password", type = String.class),
			@StoredProcedureParameter(name = "id", type = String.class) }),
	
	@NamedStoredProcedureQuery(name = "User.forgorpass", procedureName = "sp_forgorpass", resultClasses = {
			User.class }, parameters = { @StoredProcedureParameter(name = "email", type = String.class) }),

})
public class User {
	@Id
	String id;
	String password;
	String fullname;
	String email;
	Boolean admin = false;
	@OneToMany(mappedBy = "user")
	List<Favorite> favorites;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public List<Favorite> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
	
	
}
