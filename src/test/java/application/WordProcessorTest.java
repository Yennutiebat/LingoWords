package application;

import infrastructure.TextDeserializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Wordprocessor")
public class WordProcessorTest {
    final List<String> actualWords = Arrays.asList("kwijl", "hijgen", "hipheid");
    final List<String> words = Arrays.asList("bijt", "kwijl", "hijgen", "hipheid", "hinkelen", "hüttenkäse", "intuïtie", "bínnen", "blèren", "Hindoe", "hink-stap-sprong", "6-jarige");

    @Test
    @DisplayName("Filter")
    public void testFilterWords() throws IOException {
        TextDeserializer textDeserializer = new TextDeserializer();
        WordProcessor wordProcessor = new WordProcessor(textDeserializer);
        List<String> checkedwords = wordProcessor.filterWords(words);
        assertEquals(actualWords, checkedwords);
    }

    @Test
    @DisplayName("Store")
    public void testStoreWords() throws IOException {
        TextDeserializer textDeserializer = new TextDeserializer();
        WordProcessor wordProcessor = new WordProcessor(textDeserializer);
        List<String> checkedwords = wordProcessor.filterWords(words);
        wordProcessor.storeWords(actualWords);
        assertEquals(actualWords,checkedwords);
    }

    @Test
    @DisplayName("fileNotFound")
    public void testFileNotFoundException() throws IOException {
        TextDeserializer textDeserializer = new TextDeserializer();
        WordProcessor wordProcessor = new WordProcessor(textDeserializer);
        assertThrows(FileNotFoundException.class, () -> wordProcessor.filterWords(textDeserializer.deserialize("text.txt")));

    }
}