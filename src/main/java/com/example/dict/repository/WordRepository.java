package com.example.dict.repository;

import com.example.dict.entity.Word;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class WordRepository {
    private final Map<String, Word> repository = new HashMap<>();

    @SneakyThrows
    public Word add(Word word) {
        Thread.sleep(3000);
        repository.put(word.getName(), word);
        return word;
    }

    @SneakyThrows
    public List<Word> getAll() {
        Thread.sleep(3000);
        return new ArrayList<>(repository.values()).stream()
                .sorted(Comparator.comparing(Word::getName)).toList();
    }
}
