package com.goit.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class NoteReadDto {
    UUID id;
    String title;
    String content;
}
