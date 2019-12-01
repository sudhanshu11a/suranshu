/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sudhanshusharma
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String name);
}
