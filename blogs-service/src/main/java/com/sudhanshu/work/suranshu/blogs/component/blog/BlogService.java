/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.blog;

import java.util.List;

import com.sudhanshu.work.suranshu.blogs.exception.ServiceException;

/**
 * @author sudhanshusharma
 *
 */
public interface BlogService {

	List<BlogDTO> getAllBlogs(final Long organizationId) throws ServiceException;

	List<BlogDTO> getBlogByCategory(final String blogCategory, final Long organizationId) throws ServiceException;

	List<BlogDTO> getBlogByAuther(final String blogAuther, final Long organizationId) throws ServiceException;

	BlogDTO getBlogByTitle(final String blogTitle, final Long organizationId) throws ServiceException;

	Boolean saveBlog(final BlogDTO blogDTO, final Long organizationId) throws ServiceException;

	Boolean updateBlog(final BlogDTO blogDTO, final Long organizationId) throws ServiceException;

	Boolean deleteBlog(final String blogTitle, final Long organizationId) throws ServiceException;
}
