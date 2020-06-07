package application;

import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WordProcessor implements WordProcessorInterface {
    private Pattern pattern = Pattern.compile("(^[a-z]{5,7}$)");

    @Override
    public List<String> filterWords(List<String> content) {
        List<String> checkedWords = new ArrayList<>();
        for (int i = 0; i < content.size(); i++) {
            String data = content.get(i);
            Matcher matcher = pattern.matcher(data);
            if (matcher.matches()) {
                checkedWords.add(data);
            }
        }
        return checkedWords;
    }

    @Override
    public void storeWords(List<String> content, String fileLocation) throws IOException {
        java.io.File myObj = new java.io.File(fileLocation);
        myObj.createNewFile();
        FileWriter myWriter = new FileWriter(fileLocation);
        myWriter.write(String.valueOf(content));
        myWriter.close();
    }
}
