package com.goit.data.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "note")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NoteEntity implements BaseEntity<UUID>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotBlank
    @NotEmpty
    @Size(max = 128)
    private String title;

    @NotBlank
    @NotEmpty
    @Size(max = 1000)
    private String content;

}
