package com.example.dict.entity;

import lombok.Data;
import lombok.NonNull;

@Data
public class Word {
    @NonNull
    private String name;
    @NonNull
    private String description;
}
