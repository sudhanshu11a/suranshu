/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.menu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sudhanshusharma
 *
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	List<Menu> findByOrganizationId(Long organizationId);

}
