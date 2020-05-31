package bep.lingowords;

import application.WordProcessor;
import infrastructure.TextDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LingoWordsCommandLine {
    public static void main(String[] args) {
        SpringApplication.run(LingoWordsCommandLine.class,args);
        TextDeserializer textconverter = new TextDeserializer();
        WordProcessor wordprocessor = new WordProcessor();
        textconverter.deserialize("src/main/resources/basiswoorden-gekeurd.txt");
        wordprocessor.storeWords(textconverter.deserialize("src/main/resources/basiswoorden-gekeurd.txt"));
    }
}
