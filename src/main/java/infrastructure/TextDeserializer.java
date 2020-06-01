package infrastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextDeserializer implements FileDeserializerInterface {
    public List<String> deserialize(String file) {
        List<String> words = new ArrayList<String>();
        Pattern r = Pattern.compile("([a-z]{5,7})");
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Matcher matcher = r.matcher(data);

                if (data.length() >= 5 & data.length() <= 7 & matcher.matches() == true) {
                    words.add(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        return words;
    }
}