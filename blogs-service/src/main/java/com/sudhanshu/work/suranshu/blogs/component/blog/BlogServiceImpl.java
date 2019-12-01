/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.blog;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhanshu.work.suranshu.blogs.component.category.Category;
import com.sudhanshu.work.suranshu.blogs.component.category.CategoryRepository;
import com.sudhanshu.work.suranshu.blogs.component.user.User;
import com.sudhanshu.work.suranshu.blogs.component.user.UserRepository;
import com.sudhanshu.work.suranshu.blogs.exception.ServiceException;
import com.sudhanshu.work.suranshu.blogs.utils.ObjectMapperUtils;

/**
 * @author sudhanshusharma
 *
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;

	private static String serviceException = "Blog service Exception";

	@Override
	public List<BlogDTO> getAllBlogs(final Long organizationId) throws ServiceException {
		List<BlogPost> blogs = null;
		List<BlogDTO> blogDTOs = null;
		try {
			blogs = blogRepository.findByOrganizationId(organizationId);
			blogDTOs = ObjectMapperUtils.mapAll(blogs, BlogDTO.class);
		} catch (Exception e) {
			throw new ServiceException(serviceException, e);
		}
		return blogDTOs;
	}

	@Override
	public BlogDTO getBlogByTitle(final String blogTitle, final Long organizationId) throws ServiceException {
		BlogPost blog = null;
		BlogDTO blogDTO = null;
		try {
			blog = blogRepository.findByTitleAndOrganizationId(blogTitle, organizationId);
			blogDTO = ObjectMapperUtils.map(blog, BlogDTO.class);
		} catch (Exception e) {
			throw new ServiceException(serviceException, e);
		}
		return blogDTO;
	}

	@Override
	public Boolean saveBlog(BlogDTO blogDTO, Long organizationId) throws ServiceException {
		BlogPost blog = null;
		Boolean success = false;
		try {
			Category category = categoryRepository.findByName(blogDTO.getCategory());
			User user = userRepository.getOne(1l);
			blog = ObjectMapperUtils.map(blogDTO, BlogPost.class);
			blog.setBlogCategory(category);
			blog.setCreatedBy(1l);
			blog.setAuther(user);
			blog.setOrganizationId(organizationId);
			blog = blogRepository.saveAndFlush(blog);
			if (blog.getId() != null) {
				success = true;
			}
		} catch (Exception e) {
			throw new ServiceException(serviceException, e);
		}
		return success;
	}

	@Override
	public Boolean updateBlog(BlogDTO blogDTO, Long organizationId) throws ServiceException {
		BlogPost blog = null;
		Boolean success = false;
		try {
			blog = blogRepository.findByTitleAndOrganizationId(blogDTO.getTitle(), organizationId);
			if (blog != null) {
				blog = ObjectMapperUtils.map(blogDTO, BlogPost.class);
				blog = blogRepository.saveAndFlush(blog);
				if (blog.getId() != null) {
					success = true;
				}
			}
		} catch (Exception e) {
			throw new ServiceException(serviceException, e);
		}
		return success;
	}

	@Override
	public List<BlogDTO> getBlogByCategory(String blogCategory, Long organizationId) throws ServiceException {
		List<BlogPost> blogs = null;
		List<BlogDTO> blogDTOs = null;
		try {
			blogs = blogRepository.findByBlogCategoryNameAndOrganizationId(blogCategory, organizationId);
			blogDTOs = ObjectMapperUtils.mapAll(blogs, BlogDTO.class);
		} catch (Exception e) {
			throw new ServiceException(serviceException, e);
		}
		return blogDTOs;
	}

	@Override
	public List<BlogDTO> getBlogByAuther(String blogAuther, Long organizationId) throws ServiceException {
		List<BlogPost> blogs = null;
		List<BlogDTO> blogDTOs = null;
		try {
			blogs = blogRepository.findByAutherEmailAndOrganizationId(blogAuther, organizationId);
			blogDTOs = ObjectMapperUtils.mapAll(blogs, BlogDTO.class);
		} catch (Exception e) {
			throw new ServiceException(serviceException, e);
		}
		return blogDTOs;
	}

	@Override
	public Boolean deleteBlog(String blogTitle, Long organizationId) throws ServiceException {
		BlogPost blog = null;
		Boolean success = false;
		try {
			blog = blogRepository.findByTitleAndOrganizationId(blogTitle, organizationId);
			if (blog != null) {
				blog.setActive(false);
				blog = blogRepository.saveAndFlush(blog);
				if (blog.getId() != null) {
					success = true;
				}
			}
		} catch (Exception e) {
			throw new ServiceException(serviceException, e);
		}
		return success;
	}

}
