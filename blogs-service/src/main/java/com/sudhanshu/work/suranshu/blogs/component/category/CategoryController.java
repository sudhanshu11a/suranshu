/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.category;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sudhanshusharma
 *
 */
@RestController
@RequestMapping("api/v1/secure/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<String> getAllCatogory() {
		List<CategoryDTO> categories = categoryService.getAllCategory(1l);
		List<String> categoryList = new ArrayList<>();
		categories.forEach(category -> categoryList.add(category.getName()));
		return categoryList;
	}
	
	@PostMapping()
	public String saveCategory(@RequestBody @Valid String categoryName) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setName(categoryName);
		categoryDTO = categoryService.saveCategory(categoryDTO, 1l);
		return categoryDTO.getName();
	}
	


}
