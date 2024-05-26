package com.goit.service;

import com.goit.dto.NoteReadDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteService {
    List<NoteReadDto> findAll();
    Optional<NoteReadDto> findById(UUID id);
    NoteReadDto create(NoteReadDto noteReadDto);
    Optional<NoteReadDto> update(UUID id,NoteReadDto noteReadDto);
    boolean delete(UUID id);
}
