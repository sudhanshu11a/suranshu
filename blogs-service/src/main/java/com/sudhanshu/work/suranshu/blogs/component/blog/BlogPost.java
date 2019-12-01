/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.blog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sudhanshu.work.suranshu.blogs.component.category.Category;
import com.sudhanshu.work.suranshu.blogs.component.user.User;
import com.sudhanshu.work.suranshu.blogs.component.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 **/
@Entity
@Table(name = "blog_post")
public class BlogPost extends BaseEntity {

	@Column(name = "title", nullable = false)
	//@Size(min = 8, message = "The field must be at least {min} characters")
	private String title;

	@Column(name = "content")
	//@Size(max = 10000, message = "The field must be at max {max} characters")
	private String content;

	@Column(name = "is_allow_comments", nullable = false)
	private Boolean allowComments;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "auther_id", referencedColumnName = "id", updatable = false)
	private User auther;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category blogCategory;

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
	 * @return the allowComments
	 */
	public Boolean getAllowComments() {
		return allowComments;
	}

	/**
	 * @param allowComments the allowComments to set
	 */
	public void setAllowComments(Boolean allowComments) {
		this.allowComments = allowComments;
	}

	/**
	 * @return the autherId
	 */
	public User getAuther() {
		return auther;
	}

	/**
	 * @param autherId the autherId to set
	 */
	public void setAuther(User auther) {
		this.auther = auther;
	}

	/**
	 * @return the blogCategory
	 */
	public Category getBlogCategory() {
		return blogCategory;
	}

	/**
	 * @param blogCategory the blogCategory to set
	 */
	public void setBlogCategory(Category blogCategory) {
		this.blogCategory = blogCategory;
	}

}
