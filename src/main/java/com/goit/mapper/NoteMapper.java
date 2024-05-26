package com.goit.mapper;

import com.goit.data.entity.NoteEntity;
import com.goit.dto.NoteReadDto;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper implements Mapper<NoteReadDto, NoteEntity>{
    @Override
    public NoteEntity map(NoteReadDto object) {
        return NoteEntity
                .builder()
                .id(object.getId())
                .title(object.getTitle())
                .content(object.getContent())
                .build();
    }
}
