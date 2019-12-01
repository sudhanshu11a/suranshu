/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.note;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sudhanshu.work.suranshu.blogs.component.base.BaseEntity;
import com.sudhanshu.work.suranshu.blogs.component.user.User;

/**
 * Note is an entity class represents
 * the note table in the db. It Extends the baseEntity class for getting the
 * default remaining columns.
 * 
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "user_note")
public class UserNote extends BaseEntity {

	@Column(name = "title", nullable = false)
	@Size(min = 8, message = "The field must be at least {min} characters")
	private String title;

	@Column(name = "note")
	@Size(max = 1000, message = "The field must be at max {max} characters")
	private String note;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
	private User user;


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
