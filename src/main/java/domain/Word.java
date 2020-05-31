package domain;

import java.util.List;

public class Word {
    private String word;
    public List<Word> words;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
}
