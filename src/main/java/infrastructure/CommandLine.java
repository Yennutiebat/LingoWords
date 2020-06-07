package infrastructure;

import application.WordProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CommandLine implements CommandLineRunner, CommandLineInterface {
    private final TextDeserializer textDeserializer;
    private final WordProcessor wordProcessor;
    private String originalFileLocation = "src/main/resources/basiswoorden-gekeurd.txt";
    private String newFileLocation = "src/main/resources/basiswoorden-aangepast.txt";


    public CommandLine(TextDeserializer textDeserializer, WordProcessor wordProcessor){
        this.textDeserializer = textDeserializer;
        this.wordProcessor = wordProcessor;
    }
    @Override
    public void run(String[] args) throws IOException {
        List<String> deserializedWords = textDeserializer.deserialize(originalFileLocation);
        List<String> filterWords = wordProcessor.filterWords(deserializedWords);
        wordProcessor.storeWords(filterWords, newFileLocation);
    }
}
