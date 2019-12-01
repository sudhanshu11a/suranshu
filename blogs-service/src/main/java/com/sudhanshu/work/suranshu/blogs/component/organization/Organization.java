/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.organization;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author sudhanshusharma
 *
 */
@Entity
@Table(name = "sys_organization")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "organization_name", nullable = false)
	private String organizationName;

	/** The created date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	private Date createdDate;

	/** The created by. */
	@Column(name = "created_by", nullable = false)
	private Long createdBy;

	/** The modified date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", nullable = true)
	private Date modifiedDate;

	/** The modified by. */
	@Column(name = "modified_by", nullable = true)
	private Long modifiedBy;

	@Column(name = "is_active", nullable = false)
	private Boolean active;

	public Organization() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param organizationName
	 * @param createdDate
	 * @param createdBy
	 * @param modifiedDate
	 * @param modifiedBy
	 * @param active
	 */
	public Organization(Long id, String organizationName, Date createdDate, Long createdBy, Date modifiedDate,
			Long modifiedBy, Boolean active) {
		super();
		this.id = id;
		this.organizationName = organizationName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

}
