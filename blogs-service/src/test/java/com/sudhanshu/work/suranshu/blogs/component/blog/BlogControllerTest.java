/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.blog;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author sudhanshusharma
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BlogController.class)
public class BlogControllerTest {

	@MockBean
	private BlogService blogService;

	@Autowired
	private MockMvc mockMvc;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.sudhanshu.work.suranshu.blogs.component.blog.BlogController#getAllBlogs()}.
	 */
	@Test
	public void testGetAllBlogs() {
		try {
			mockMvc.perform(get("api/v1/secure/blog")).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for
	 * {@link com.sudhanshu.work.suranshu.blogs.component.blog.BlogController#getBlog(java.lang.String)}.
	 */
	@Test
	public void testGetBlog() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.sudhanshu.work.suranshu.blogs.component.blog.BlogController#getBlogByCategory(java.lang.String)}.
	 */
	@Test
	public void testGetBlogByCategory() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.sudhanshu.work.suranshu.blogs.component.blog.BlogController#getBlogByAuther(java.lang.String)}.
	 */
	@Test
	public void testGetBlogByAuther() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.sudhanshu.work.suranshu.blogs.component.blog.BlogController#saveBlog(com.sudhanshu.work.suranshu.blogs.component.blog.BlogDTO)}.
	 */
	@Test
	public void testSaveBlog() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.sudhanshu.work.suranshu.blogs.component.blog.BlogController#updateBlog(com.sudhanshu.work.suranshu.blogs.component.blog.BlogDTO)}.
	 */
	@Test
	public void testUpdateBlog() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.sudhanshu.work.suranshu.blogs.component.blog.BlogController#deleteBlog(java.lang.String)}.
	 */
	@Test
	public void testDeleteBlog() {
		fail("Not yet implemented");
	}

}
