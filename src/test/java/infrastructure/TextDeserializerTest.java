package infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("TextDeserializer")
public class TextDeserializerTest {
    final List<String> words = Arrays.asList("bijt", "kwijl", "hijgen", "hipheid", "hinkelen", "hüttenkäse", "intuïtie", "bínnen", "blèren", "Hindoe", "hink-stap-sprong", "6-jarige");

    @Test
    @DisplayName("Deserialize")
    public void testDeserialize() throws FileNotFoundException {
        TextDeserializer textDeserializer = new TextDeserializer();
        List<String> deserializedText = textDeserializer.deserialize("src/test/java/resources/deserializetext.txt");
        assertEquals(words, deserializedText);
    }

    @Test
    @DisplayName("File not Found")
    public void testFileNotFoundException() {
        TextDeserializer textDeserializer = new TextDeserializer();
        assertThrows(FileNotFoundException.class, () -> textDeserializer.deserialize("text.txt"));
    }
}
