/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.component.note;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Note converter for converting the entity to dto and vice-versa
 * 
 * @author sudhanshusharma
 *
 */
@Component
public class NoteConverter implements BaseConverter<NoteDTO, UserNote> {

	private ModelMapper modelMapper;

	public NoteConverter() {
		this.modelMapper = new ModelMapper();
	}
	@Override
	public NoteDTO convertToDTO(UserNote entity) {
		return entity!=null?modelMapper.map(entity, NoteDTO.class):null;
	}

	@Override
	public UserNote convertToEntity(NoteDTO dto) {
		return dto!=null?modelMapper.map(dto, UserNote.class):null;
	}
}
