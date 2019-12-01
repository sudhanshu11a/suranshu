/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.menu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sudhanshu.work.suranshu.blogs.exception.ServiceException;
import com.sudhanshu.work.suranshu.blogs.utils.ObjectMapperUtils;

/**
 * @author sudhanshusharma
 *
 */
@Service
public class MenuServiceImpl implements MenuService{
	
	private MenuRepository menuRepository;

	@Override
	public List<MenuDTO> getAdminMenu(long organizationId) throws ServiceException {
		List<MenuDTO> menuDTOs = null;
		List<Menu> menus = null;
		try {
			menus = menuRepository.findByOrganizationId(organizationId);
			menuDTOs = ObjectMapperUtils.mapAll(menus, MenuDTO.class);
		}catch(Exception e) {
			throw new ServiceException("Unable to get admin menu",e);
		}
		return menuDTOs;
	}

}
