package com.goit.mapper;

import com.goit.data.entity.NoteEntity;
import com.goit.dto.NoteReadDto;
import org.springframework.stereotype.Component;

@Component
public class NoteDtoMapper implements Mapper<NoteEntity, NoteReadDto>{
    @Override
    public NoteReadDto map(NoteEntity object) {
        return NoteReadDto.builder()
                .id(object.getId())
                .title(object.getTitle())
                .content(object.getContent())
                .build();
    }
}
