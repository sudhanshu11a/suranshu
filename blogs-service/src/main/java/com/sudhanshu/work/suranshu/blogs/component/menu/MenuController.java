/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhanshusharma
 *
 */
@RestController
@RequestMapping("api/v1/secure/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping
	public List<MenuDTO> getMenu() {
		List<MenuDTO> menuDTOList = menuService.getAdminMenu(1l);
		return menuDTOList;
	}
}
