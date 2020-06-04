package infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextDeserializer implements FileDeserializerInterface {


    @Override
    public List<String> deserialize(String files) throws FileNotFoundException {
        List<String> words = new ArrayList<String>();
        File myObj = new File(files);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            words.add(data);
        }
        myReader.close();
        return words;
    }
}