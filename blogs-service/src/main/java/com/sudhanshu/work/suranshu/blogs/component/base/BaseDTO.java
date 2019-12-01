/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.base;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * This is a Base Data transfer object.   
 * @author sudhanshusharma
 *
 */
public abstract class BaseDTO implements Serializable{

	private static final long serialVersionUID = 8002080636214707471L;

	/** The created date. */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;

	/** The modified date. */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifiedDate;

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
