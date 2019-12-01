/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sudhanshu.work.suranshu.blogs.component.blog.BlogPost;

/**
 * @author sudhanshusharma
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query("SELECT n FROM Comment n WHERE n.organization.id = ?1")
	List<BlogPost> findByOrganizationId(Long id);
}
