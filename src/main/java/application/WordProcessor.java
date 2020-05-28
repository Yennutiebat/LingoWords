package application;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordProcessor {
    private static int minimumWordLength = 5;
    private static int maximumWordLength;
    public static List<String> words = new ArrayList<String>();

    public static void emptyFile(){
        try{
            FileWriter myWriter = new FileWriter("src/main/resources/basiswoorden-aangepast.txt");
            myWriter.write("");
            myWriter.close();
            System.out.println("Succesfully emptied to file");
        } catch (IOException e) {
            System.out.println("Could not empty the file");
            e.printStackTrace();
        }
    }
    public static void wriToFile(String content){
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

    public static void createFile(){
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
    }
    public static void readFile(String fileLocation){
        Pattern r = Pattern.compile("([a-z]{5,7}|[a-ÿ]{5,7})");
        try{
            java.io.File myObj = new java.io.File(fileLocation);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                Matcher matcher = r.matcher(data);

                if(data.length()>=5&data.length()<=7&matcher.matches()==true) {
                    System.out.println(data);
                    words.add(data);
                }
            }
            System.out.println(words);
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        readFile("src/main/resources/basiswoorden-gekeurd.txt");
        //createFile();
        //emptyFile();
        // wriToFile(data);
    }
}
