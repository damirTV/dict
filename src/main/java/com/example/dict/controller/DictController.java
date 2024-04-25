package com.example.dict.controller;

import com.example.dict.dto.WordDtoRq;
import com.example.dict.dto.WordDtoRs;
import com.example.dict.service.DictService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dict")
@CacheConfig(cacheNames = "getWords")
public class DictController {
    private final DictService dictService;

    // Получение всех слов
    @GetMapping
    @Cacheable
    public List<WordDtoRs> getWords(@RequestParam Integer startWord,
                                       @RequestParam Integer qtyWords) {
        return dictService.getWords(startWord, qtyWords);
    }

    // Добавление нового слова
    @PostMapping
    @CacheEvict(cacheNames = "getWords", allEntries = true)
    public ResponseEntity<WordDtoRs> addWord(@RequestBody WordDtoRq dtoRq) {
        return ResponseEntity.status(CREATED).body(dictService.createWord(dtoRq));
    }
}
