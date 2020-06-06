package integration;

import application.WordProcessor;
import infrastructure.TextDeserializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


@Tag("integration")
@DisplayName("Integration tests")
public class integrationTests {
    final static String textFileLocation = "src/test/java/resources/deserializetext.txt";
    final static String csvFileLocation = "src/test/java/resources/deserializetext.csv";
    final List<String> actualWords = Arrays.asList("kwijl", "hijgen", "hipheid");
    final String storeLocation = "src/test/java/resources/storewords.txt";

    public static Stream<Arguments> files() {
        return Stream.of(Arguments.of(textFileLocation),
                Arguments.of(csvFileLocation));
    }

    @ParameterizedTest
    @MethodSource("files")
    @DisplayName("Deserialize")
    public void testApplication(String fileLocation) throws IOException {
        TextDeserializer textDeserializer = new TextDeserializer();
        WordProcessor wordProcessor =new WordProcessor();

        List<String> deserializedText = textDeserializer.deserialize(fileLocation);
        List<String> checkedWords = wordProcessor.filterWords(deserializedText);
        wordProcessor.storeWords(checkedWords, storeLocation);
        assertEquals(actualWords, checkedWords);
    }
}

