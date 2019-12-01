/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.menu;

import java.util.List;

import com.sudhanshu.work.suranshu.blogs.exception.ServiceException;

/**
 * @author sudhanshusharma
 *
 */
public interface MenuService {
 
	List<MenuDTO> getAdminMenu(long organizationId) throws ServiceException;
}
