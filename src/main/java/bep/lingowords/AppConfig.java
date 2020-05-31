package bep.lingowords;

import application.WordProcessor;
import infrastructure.TextDeserializer;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig
{
    @Bean
    public TextDeserializer TextDeserializer(){
        return new TextDeserializer();
    }
    @Bean
    public WordProcessor WordProcessor(){
        return new WordProcessor();
    }
}