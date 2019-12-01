/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhanshu.work.suranshu.blogs.exception.ServiceException;
import com.sudhanshu.work.suranshu.blogs.utils.ObjectMapperUtils;

/**
 * @author sudhanshusharma
 *
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryDTO> getAllCategory(long organizationId) throws ServiceException {
		List<Category> categories = null;
		List<CategoryDTO> categoryDTOs = null;
		try {
			categories = categoryRepository.findAll();
			categoryDTOs = ObjectMapperUtils.mapAll(categories, CategoryDTO.class);
		} catch (Exception e) {
			throw new ServiceException("Unable to get all categories", e);
		}
		return categoryDTOs;
	}

	@Override
	public CategoryDTO saveCategory(CategoryDTO categoryDTO, Long organizationId) throws ServiceException {
		Category category = null;
		try {
			category = categoryRepository.findByName(categoryDTO.getName().trim());
			if(category==null) {
				category = new Category();
				category.setOrganizationId(organizationId);
				category.setName(categoryDTO.getName().trim());
				category.setCreatedBy(1l);
				category = categoryRepository.save(category);
				categoryDTO = ObjectMapperUtils.map(category, CategoryDTO.class);
			}else {
				throw new Exception("Resource Already Exists");
			}
		}catch(Exception e) {
			throw new ServiceException("Unable to save category", e);
		}
		return categoryDTO;
	}

}
