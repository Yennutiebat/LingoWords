package infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("TextDeserializer")
public class TextDeserializerTest {
    final static String textFileLocation = "src/test/java/resources/deserializetext.txt";
    final static String csvFileLocation = "src/test/java/resources/deserializetext.csv";

    final static List<String> correctWords = Arrays.asList("bijt", "kwijl", "hijgen", "hipheid", "hinkelen", "hüttenkäse", "intuïtie", "bínnen", "blèren", "Hindoe", "hink-stap-sprong", "6-jarige");

    public static Stream<Arguments> files(){
    return Stream.of(Arguments.of(correctWords,textFileLocation),
                    Arguments.of(correctWords,csvFileLocation));
    }
    @ParameterizedTest
    @MethodSource("files")
    @DisplayName("Deserialize")
    public void testDeserialize(List<String> words, String fileLocation) throws FileNotFoundException {
        TextDeserializer textDeserializer = new TextDeserializer();
        List<String> deserializedText = textDeserializer.deserialize(fileLocation);
        assertEquals(words, deserializedText);
    }

    @Test
    @DisplayName("File not Found")
    public void testFileNotFoundException() {
        TextDeserializer textDeserializer = new TextDeserializer();
        assertThrows(FileNotFoundException.class, () -> textDeserializer.deserialize("text.txt"));
    }
}
