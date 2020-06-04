package bep.lingowords;

import application.WordProcessor;
import infrastructure.TextDeserializer;
import org.springframework.context.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean
    public TextDeserializer TextDeserializer() {
        return new TextDeserializer();
    }

    @Bean
    public WordProcessor WordProcessor() throws IOException {
        TextDeserializer textDeserializer = new TextDeserializer();
        return new WordProcessor(textDeserializer);
    }
}