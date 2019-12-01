/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository
 * 
 * @author sudhanshusharma
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);
}
