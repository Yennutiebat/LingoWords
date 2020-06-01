package application;

import infrastructure.TextDeserializer;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WordProcessor implements WordProcessorInterface {
    private final TextDeserializer textDeserializer;
    public List<String> words = new ArrayList<String>();


    public WordProcessor(TextDeserializer textDeserializer){
        this.textDeserializer= textDeserializer;
        storeWords(textDeserializer.deserialize("src/main/resources/basiswoorden-gekeurd.txt"));
    }

    public void storeWords(List<String> content) {
        try {
            java.io.File myObj = new java.io.File("src/main/resources/basiswoorden-aangepast.txt");
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
            FileWriter myWriter = new FileWriter("src/main/resources/basiswoorden-aangepast.txt", true);
            myWriter.write(String.valueOf(content));
            myWriter.close();
            System.out.println("Succesfully wrote to file");
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
    }
}
