package com.goit.service;

import com.goit.mapper.NoteDtoMapper;
import com.goit.mapper.NoteMapper;
import com.goit.dto.NoteReadDto;
import com.goit.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final NoteDtoMapper noteDtoMapper;
    private final NoteMapper noteMapper;

    public List<NoteReadDto> findAll(){
        return noteRepository
                .findAll()
                .stream()
                .map(noteDtoMapper::map)
                .toList();
    }

    public Optional<NoteReadDto> findById(UUID id) {
        return noteRepository
                .findById(id)
                .map(noteDtoMapper::map);
    }

    @Transactional
    public NoteReadDto create(NoteReadDto noteReadDto) {
        return  Optional
                .of(noteReadDto)
                .map(noteMapper::map)
                .map(noteRepository::save)
                .map(noteDtoMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<NoteReadDto> update(UUID id,NoteReadDto noteReadDto) {
        return noteRepository.findById(id)
                .map(entity -> {
                    entity.setTitle(noteReadDto.getTitle());
                    entity.setContent(noteReadDto.getContent());
                    return entity;
                })
                .map(noteRepository::saveAndFlush)
                .map(noteDtoMapper::map);
    }

    @Transactional
    public boolean delete(UUID id) {
        return noteRepository.findById(id)
                .map(entity -> {
                    noteRepository.delete(entity);
                    noteRepository.flush();
                    return true;
                })
                .orElse(false);
    }

}
