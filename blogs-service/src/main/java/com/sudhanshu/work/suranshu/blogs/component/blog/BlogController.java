/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.blog;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhanshu.work.suranshu.blogs.exception.ResourceNotFoundException;

/**
 * Note controller for handling rest requests for the Not resource
 * 
 * TODO: This is a secure resource, so we need to implement the authentication.
 * 
 * @author sudhanshusharma
 *
 */
@RestController
@RequestMapping("api/v1/secure/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@GetMapping
	public List<BlogDTO> getAllBlogs() {
		List<BlogDTO> blogDTOs = null;
		blogDTOs = blogService.getAllBlogs(1l);
		if (blogDTOs == null || blogDTOs.isEmpty()) {
			throw new ResourceNotFoundException("No blogs found for current user!");
		}
		return blogDTOs;
	}

	@GetMapping("/{blogTitle}")
	public BlogDTO getBlog(@PathVariable String blogTitle) {
		BlogDTO blogDTO = null;
		blogDTO = blogService.getBlogByTitle(blogTitle, 1l);
		if (blogDTO == null) {
			throw new ResourceNotFoundException("No blog found with title " + blogTitle);
		}
		return blogDTO;
	}

	@GetMapping("/category/{blogCategory}")
	public List<BlogDTO> getBlogByCategory(@PathVariable String blogCategory) {
		List<BlogDTO> blogDTOs = null;
		blogDTOs = blogService.getBlogByCategory(blogCategory, 1l);
		if (blogDTOs == null || blogDTOs.isEmpty()) {
			throw new ResourceNotFoundException("No blogs found for Category " + blogCategory);
		}
		return blogDTOs;
	}

	@GetMapping("/auther/{blogAuther}")
	public List<BlogDTO> getBlogByAuther(@PathVariable String blogAuther) {
		List<BlogDTO> blogDTOs = null;
		blogDTOs = blogService.getBlogByAuther(blogAuther, 1l);
		if (blogDTOs == null || blogDTOs.isEmpty()) {
			throw new ResourceNotFoundException("No blogs found for current user!");
		}
		return blogDTOs;
	}

	@PostMapping()
	public BlogDTO saveBlog(@RequestBody @Valid BlogDTO blogDTO) {
		Boolean success = blogService.saveBlog(blogDTO, 1l);
		if (success == null) {
			throw new ResourceNotFoundException("Service is only for new Notes");
		}
		return blogDTO;
	}

	@PutMapping("/{blogTitle}")
	public BlogDTO updateBlog(@RequestBody @Valid BlogDTO blogDTO) {
		Boolean success = blogService.saveBlog(blogDTO, 1l);
		if (success == null) {
			throw new ResourceNotFoundException("Service is only for new Notes");
		}
		return blogDTO;
	}

	@DeleteMapping("/{blogTitle}")
	public boolean deleteBlog(@PathVariable final String blogTitle) {
		Boolean success = blogService.deleteBlog(blogTitle, 1l);
		if (success == null) {
			throw new ResourceNotFoundException("Service is only for new Notes");
		}
		return success;
	}

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
//		binder.registerCustomEditor(Date.class, editor);
//	}
//
//	@GetMapping()
//	public List<NoteDTO> getUserNotes() {
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		List<NoteDTO> noteDTOs = noteService.getUserAllNotes(username);
//		if (noteDTOs == null || noteDTOs.isEmpty()) {
//			throw new ResourceNotFoundException("No notes not found for current user!");
//		}
//		return noteDTOs;
//	}
//
//	@PostMapping()
//	public NoteDTO saveUserNote(@Valid NoteDTO noteDTO) {
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		noteDTO = noteService.createUserNote(noteDTO, username);
//		if (noteDTO == null) {
//			throw new ResourceNotFoundException("Service is only for new Notes");
//		}
//		return noteDTO;
//	}
//
//	@GetMapping("/{id}")
//	public NoteDTO getUserNotedetails(@PathVariable("id") long noteId) {
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		NoteDTO noteDTO = noteService.getUserNoteDetail(noteId, username);
//		if (noteDTO == null) {
//			throw new ResourceNotFoundException("Note not found!");
//		}
//		return noteDTO;
//	}
//
//	@PutMapping("/{id}")
//	public NoteDTO updateUserNote(@Valid NoteDTO noteDTO, @PathVariable("id") long noteId) {
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		noteDTO = noteService.updateUserNote(noteDTO, username);
//		if (noteDTO == null) {
//			throw new ResourceNotFoundException("Note not found!");
//		}
//		return noteDTO;
//	}
//
//	@DeleteMapping("{id}")
//	public ResponseEntity<Void> deleteUserNote(@PathVariable("id") long noteId) {
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		boolean success = noteService.deleteUserNote(noteId, username);
//		if(!success) {
//			throw new ResourceNotFoundException("Note not found!");
//		}
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}

}
