package infrastructure;

import application.WordProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CommandLine implements CommandLineRunner {
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
        wordProcessor.storeWords(wordProcessor.filterWords(textDeserializer.deserialize(originalFileLocation)), newFileLocation);
    }
}
