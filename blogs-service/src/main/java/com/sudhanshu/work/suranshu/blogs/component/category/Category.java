/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sudhanshu.work.suranshu.blogs.component.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "sys_category")
public class Category extends BaseEntity {

	@Column(name = "name")
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
