package com.example.dict.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WordDtoRs {
    private String name;
    private String description;
}