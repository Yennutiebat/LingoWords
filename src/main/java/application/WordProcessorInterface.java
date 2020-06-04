package application;


import java.io.IOException;
import java.util.List;

public interface WordProcessorInterface {
    void storeWords(List<String> content) throws IOException;
    List<String> filterWords(List<String> content);
}