/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sudhanshu.work.suranshu.blogs.component.blog.BlogPost;
import com.sudhanshu.work.suranshu.blogs.component.user.User;
import com.sudhanshu.work.suranshu.blogs.component.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

	@Column(name = "content")
	@Size(max = 10000, message = "The field must be at max {max} characters")
	private String content;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
	private User userId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "blog_id", referencedColumnName = "id", updatable = false)
	private BlogPost blogId;

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the userId
	 */
	public User getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}

	/**
	 * @return the blogId
	 */
	public BlogPost getBlogId() {
		return blogId;
	}

	/**
	 * @param blogId the blogId to set
	 */
	public void setBlogId(BlogPost blogId) {
		this.blogId = blogId;
	}

}
