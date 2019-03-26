package KeywordsSearchSymbol;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordsFill {

    private StringBuilder keysBuilder = new StringBuilder();
    private StringBuilder javaCodeText = new StringBuilder();
    private ArrayList<String> keys;
    private String javaCodeToSearch;
    private String resultToFile = "";
    private String lineSeparator = System.getProperty("line.separator");

    void keywordsFilling () {

        try (FileReader stream = new FileReader("keyWords.txt")){
            int s;
            while ((s = stream.read()) != -1) {
                keysBuilder.append((char) s);
            }
        } catch (IOException e) {
            System.out.println("Exception");;
        }
        keys = new ArrayList<>(Arrays.asList(keysBuilder.toString().split(" ")));
    }

    void read () {

        try (FileReader input = new FileReader("javaCode.txt")){
            int r;
            while ((r = input.read()) != -1) {
                javaCodeText.append((char) r);
            }
        } catch (IOException e) {
            System.out.println("Read exception");
        }
        javaCodeToSearch = javaCodeText.toString();
    }

    void keysCheck () {
        int count = 0;

        for (int i = 0; i < keys.size(); i++) {
            Pattern p = Pattern.compile("\\b" + keys.get(i) + "\\b", Pattern.UNICODE_CASE|Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(javaCodeToSearch);
            while(m.find()) {
                count++;
            }
            if (count != 0) {
                resultToFile += keys.get(i) + " - " + count + lineSeparator;
            }
            count = 0;
        }
    }

    void keysWrite () {
        char[] chars = new char[resultToFile.length()];
        resultToFile.getChars(0, resultToFile.length(), chars, 0);

        try (FileWriter writer = new FileWriter("ResultSymbolIO.txt")){

            for (char eachChar : chars) {
                writer.write(eachChar);
            }
        } catch (IOException e) {
            System.out.println("Write exception");
        }
    }
}
