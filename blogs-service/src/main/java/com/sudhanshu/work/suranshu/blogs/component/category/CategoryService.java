/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.category;

import java.util.List;

import com.sudhanshu.work.suranshu.blogs.exception.ServiceException;

/**
 * @author sudhanshusharma
 *
 */
public interface CategoryService {

	List<CategoryDTO> getAllCategory(long organizationId) throws ServiceException;

	CategoryDTO saveCategory(CategoryDTO categoryDTO, Long organizationId) throws ServiceException;

}
