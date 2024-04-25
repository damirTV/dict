package com.example.dict.service;

import com.example.dict.dto.WordDtoRq;
import com.example.dict.dto.WordDtoRs;
import com.example.dict.entity.Word;
import com.example.dict.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DictService {
    private final WordRepository wordRepository;

    public WordDtoRs createWord(WordDtoRq dtoRq) {
        Word newWord = convertToEntity(dtoRq);
        Word createdWord = wordRepository.add(newWord);
        return convertToDtoRs(createdWord);
    }

    public List<WordDtoRs> getWords(Integer startWord, Integer qtyWords) {
        return wordRepository.getAll().stream()
                .skip(startWord)
                .limit(qtyWords)
                .map(this::convertToDtoRs).toList();
    }

    private WordDtoRs convertToDtoRs(Word createdWord) {
        return new WordDtoRs(createdWord.getName(), createdWord.getDescription());
    }

    private Word convertToEntity(WordDtoRq dtoRq) {
        return new Word(dtoRq.getName(), dtoRq.getDescription());
    }
}
