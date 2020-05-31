package application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordProcessor implements WordProcessorInterface{
    public List<String> words = new ArrayList<String>();

    public void storeWords(List<String> content){
        try{
            java.io.File myObj = new java.io.File("src/main/resources/basiswoorden-aangepast.txt");
            if (myObj.createNewFile()){
                System.out.println("File created"+ myObj.getName());
            }else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Could not create file");
            e.printStackTrace();
        }
        try{
            FileWriter myWriter = new FileWriter("src/main/resources/basiswoorden-aangepast.txt",true);
            myWriter.write(content+";");
            myWriter.close();
            System.out.println("Succesfully wrote to file");
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
    }
    }
