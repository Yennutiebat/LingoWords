package bep.lingowords;

import application.WordProcessor;
import infrastructure.TextDeserializer;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    @Bean
    public TextDeserializer TextDeserializer() {
        return new TextDeserializer();
    }

    @Bean
    public WordProcessor WordProcessor() {
        TextDeserializer textDeserializer = new TextDeserializer();
        return new WordProcessor(textDeserializer);
    }

}