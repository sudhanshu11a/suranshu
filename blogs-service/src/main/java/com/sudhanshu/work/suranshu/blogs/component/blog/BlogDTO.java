/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.blog;

import com.sudhanshu.work.suranshu.blogs.component.base.BaseDTO;
import com.sudhanshu.work.suranshu.blogs.component.user.UserDTO;

/**
 * @author sudhanshusharma
 *
 */
public class BlogDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;

	private String content;

	private Boolean allowComments;

	private UserDTO autherId;
	
	private String category;

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
	public UserDTO getAutherId() {
		return autherId;
	}

	/**
	 * @param autherId the autherId to set
	 */
	public void setAutherId(UserDTO autherId) {
		this.autherId = autherId;
	}
	

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BlogDTO [title=" + title + ", content=" + content + ", allowComments=" + allowComments + ", autherId="
				+ autherId + "]";
	}

	
}
