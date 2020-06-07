package bep.lingowords;

import application.WordProcessor;
import infrastructure.CommandLine;
import infrastructure.TextDeserializer;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    @Bean
    public TextDeserializer textDeserializer() {
        return new TextDeserializer();
    }

    @Bean
    public WordProcessor wordProcessor() { return new WordProcessor(); }
    
    @Bean
    public CommandLine commandLine(){
         final TextDeserializer textDeserializer = new TextDeserializer();
         final WordProcessor wordProcessor =  new WordProcessor();
         return new CommandLine(textDeserializer,wordProcessor);
    }
}