/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sudhanshu.work.suranshu.blogs.component.base.BaseEntity;

/**
 * 
 * User is an entity class represents the user table in the db. It Extends the
 * baseEntity class for getting the default remaining columns.
 * 
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity {

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	@Size(min = 4, message = "The password field must be at least {min} characters")
	private String password;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
