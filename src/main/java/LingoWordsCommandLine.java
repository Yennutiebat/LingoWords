import application.WordProcessor;
import infrastructure.TextDeserializer;


public class LingoWordsCommandLine {
    public static void main(String[] args){
        TextDeserializer textconverter = new TextDeserializer();
        WordProcessor wordprocessor = new WordProcessor();
        textconverter.deserialize("src/main/resources/basiswoorden-gekeurd.txt");
        wordprocessor.storeWords(textconverter.deserialize("src/main/resources/basiswoorden-gekeurd.txt"));
    }
}
