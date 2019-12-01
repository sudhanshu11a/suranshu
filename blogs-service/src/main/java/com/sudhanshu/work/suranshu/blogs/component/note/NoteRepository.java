/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Note Repository
 * 
 * @author sudhanshusharma
 *
 */
@Repository
public interface NoteRepository extends JpaRepository<UserNote, Long> {

	//@Query("SELECT n FROM UserNote n WHERE n.user.email = ?1")
	//List<UserNote> findByUserName(String username);

	//@Query("SELECT n FROM UserNote n WHERE n.id = ?1 AND n.user.email = ?2")
	//UserNote findByIdAndUsername(long id, String username);

}
