package application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Wordprocessor")
public class WordProcessorTest {
    final List<String> actualWords = Arrays.asList("kwijl", "hijgen", "hipheid");
    final List<String> words = Arrays.asList("bijt", "kwijl", "hijgen", "hipheid", "hinkelen", "hüttenkäse", "intuïtie", "bínnen", "blèren", "Hindoe", "hink-stap-sprong", "6-jarige");
    final String fileLocation = "src/test/java/resources/storewords.txt";

    @Test
    @DisplayName("Filter")
    public void testFilterWords() {
        WordProcessor wordProcessor = new WordProcessor();
        List<String> checkedWords = wordProcessor.filterWords(words);
        assertEquals(actualWords, checkedWords);
    }

    @Test
    @DisplayName("Store")
    public void testStoreWords() throws IOException {
        WordProcessor wordProcessor = new WordProcessor();
        List<String> checkedWords = wordProcessor.filterWords(words);
        wordProcessor.storeWords(actualWords,fileLocation);
        assertEquals(actualWords,checkedWords);
    }
}