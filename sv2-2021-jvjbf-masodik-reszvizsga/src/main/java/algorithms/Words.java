package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return List.copyOf(words);
    }

    public void addWord(String word) {
        if (!word.equals(word.toLowerCase())) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        if (!isWord(word)) {
            throw new IllegalArgumentException("It should be one word!");
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        List<String> unique = new ArrayList<>();
        for (String word : words) {
            if (unique.contains(word)) {
                return true;
            } else {
                unique.add(word);
            }
        }
        return false;
    }

    private boolean isWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isWhitespace(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
