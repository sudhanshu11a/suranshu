/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.blog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author sudhanshusharma
 *
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogPost, Long> {

	@Query("SELECT n FROM BlogPost n WHERE n.organization.id = ?1")
	List<BlogPost> findByOrganizationId(Long id);
	
	List<BlogPost> findByBlogCategoryNameAndOrganizationId(String categoryName, Long organizationId);
	
	List<BlogPost> findByAutherEmailAndOrganizationId(String autherEmail, Long organizationId);
	
	BlogPost findByTitleAndOrganizationId(String title, Long organizationId);
}
