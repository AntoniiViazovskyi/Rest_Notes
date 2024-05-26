package com.goit.controller;

import com.goit.dto.NoteReadDto;
import com.goit.service.NoteService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<NoteReadDto>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(noteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteReadDto> findbyId(@PathVariable UUID id) {
        return noteService.findById(id)
                .map(note -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(note))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @PostMapping
    public ResponseEntity<NoteReadDto> create(@RequestBody NoteReadDto noteReadDto){
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(noteService.create(noteReadDto));
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void update(@PathVariable UUID id,
                       @RequestBody @NotNull NoteReadDto noteReadDto){
        noteService.update(id,noteReadDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public  void delete(@PathVariable @NotNull UUID id){
        noteService.delete(id);
    }
}
