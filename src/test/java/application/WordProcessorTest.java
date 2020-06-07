package application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Wordprocessor")
public class WordProcessorTest {
    final static List<String> actualWords = Arrays.asList("kwijl", "hijgen", "hipheid");
    final static List<String> words = Arrays.asList("bijt", "kwijl", "hijgen", "hipheid", "hinkelen", "hüttenkäse", "intuïtie", "bínnen", "blèren", "Hindoe", "hink-stap-sprong", "6-jarige");
    final static List<String> actualWords2 = Arrays.asList("macho", "hitsig", "sporten");
    final static List<String> words2 = Arrays.asList("tand", "macho", "hitsig", "sporten", "extrusie", "machtsvacuüm", "absenteïsme", "bínnen", "blèt", "Christuskind", "citatie-index", "F-16");
    final String fileLocation = "src/test/java/resources/storewords.txt";

    public static Stream<Arguments> files(){
        return Stream.of(Arguments.of(words,actualWords),
            Arguments.of(words2,actualWords2));
    }
    @ParameterizedTest
    @MethodSource("files")
    @DisplayName("Filter")
    public void testFilterWords(List<String> words, List<String> correctWords) {
        WordProcessor wordProcessor = new WordProcessor();
        List<String> checkedWords = wordProcessor.filterWords(words);
        assertEquals(correctWords,checkedWords);
    }

    @Test
    @DisplayName("Store succeeds")
    public void testStoreWords() throws IOException {
        WordProcessor wordProcessor = new WordProcessor();
        wordProcessor.storeWords(actualWords,fileLocation);
        assertTrue(Files.exists(Paths.get(fileLocation)));
    }

    @Test
    @DisplayName("Store failed")
    public void testFailStoreWords() throws IOException {
        WordProcessor wordProcessor = new WordProcessor();
        wordProcessor.storeWords(actualWords,fileLocation);
        assertFalse(Files.exists(Paths.get(fileLocation+"2")));
    }
}