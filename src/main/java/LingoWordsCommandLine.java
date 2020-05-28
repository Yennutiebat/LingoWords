import infrastructure.TextDeserializer;

public class LingoWordsCommandLine {
    public static void main(String[] args){
        //readFile("src/main/resources/basiswoorden-gekeurd.txt");
        //System.out.println(data);
        //createFile();
        //emptyFile();
        TextDeserializer textconverter = new TextDeserializer();
        textconverter.convert("src/main/resources/basiswoorden-gekeurd.txt");
    }
}
