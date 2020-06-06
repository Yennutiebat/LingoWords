package application;


import java.io.IOException;
import java.util.List;

public interface WordProcessorInterface {
    void storeWords(List<String> content, String fileLocation) throws IOException;
    List<String> filterWords(List<String> content);
}