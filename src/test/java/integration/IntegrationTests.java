package integration;

import application.WordProcessor;
import infrastructure.TextDeserializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@Tag("integration")
@DisplayName("Integration tests")
public class IntegrationTests {
    final static String textFileLocation = "src/test/java/resources/deserializetext.txt";
    final List<String> actualWords = Arrays.asList("kwijl", "hijgen", "hipheid");
    final String storeLocation = "src/test/java/resources/storewords.txt";

    @Test
    @DisplayName("Deserialize")
    public void testApplication() throws IOException {
        TextDeserializer textDeserializer = new TextDeserializer();
        WordProcessor wordProcessor = new WordProcessor();

        List<String> deserializedText = textDeserializer.deserialize(textFileLocation);
        List<String> checkedWords = wordProcessor.filterWords(deserializedText);
        wordProcessor.storeWords(checkedWords, storeLocation);
        assertEquals(actualWords, checkedWords);
        assertTrue(Files.exists(Paths.get(storeLocation)));
    }
}

