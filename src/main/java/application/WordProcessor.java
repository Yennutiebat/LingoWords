package application;

import infrastructure.TextDeserializer;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WordProcessor implements WordProcessorInterface {
    private final TextDeserializer textDeserializer;
    private String originalFileLocation = "src/main/resources/basiswoorden-gekeurd.txt";
    private String newFileLocation = "src/main/resources/basiswoorden-aangepast.txt";
    private Pattern r = Pattern.compile("([a-z]{5,7})");

    public WordProcessor(TextDeserializer textDeserializer) {
        this.textDeserializer = textDeserializer;
        storeWords(filterWords(textDeserializer.deserialize(originalFileLocation)));
    }

    public List<String> filterWords(List<String> content) {
        List<String> checkedWords = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            String data = content.get(i);
            Matcher matcher = r.matcher(data);
            if (data.length() >= 5 & data.length() <= 7 & matcher.matches() == true) {
                checkedWords.add(data);
            }
        }
        return checkedWords;
    }

    public void storeWords(List<String> content) {
        try {
            java.io.File myObj = new java.io.File(newFileLocation);
            if (myObj.createNewFile()) {
                System.out.println("File created" + myObj.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Could not create file");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter(newFileLocation);
            myWriter.write(String.valueOf(content));
            myWriter.close();
            System.out.println("Succesfully wrote to file");
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
    }
}
