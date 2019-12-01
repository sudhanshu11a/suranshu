/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.menu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sudhanshu.work.suranshu.blogs.component.base.BaseEntity;

/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name="manu")
public class Menu extends BaseEntity {

	private String text;
	private String url;

	@ManyToOne
	@JoinColumn(name = "parent_menu_id")
	private Menu parent;

	@OneToMany(mappedBy = "parent")
	private List<Menu> submenus;

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the parent
	 */
	public Menu getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(Menu parent) {
		this.parent = parent;
	}

	/**
	 * @return the submenus
	 */
	public List<Menu> getSubmenus() {
		return submenus;
	}

	/**
	 * @param submenus the submenus to set
	 */
	public void setSubmenus(List<Menu> submenus) {
		this.submenus = submenus;
	}
	
	
	
}
