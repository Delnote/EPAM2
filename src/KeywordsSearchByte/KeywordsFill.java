package KeywordsSearchByte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

        try (FileInputStream stream = new FileInputStream("keyWords.txt")){
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

        try (FileInputStream input = new FileInputStream("javaCode.txt")){
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
        byte[] bytes = resultToFile.getBytes();
        try (FileOutputStream stream = new FileOutputStream("ResultByteIO.txt")){

            for (byte eachByte : bytes) {
                stream.write(eachByte);
            }
        } catch (IOException e) {
            System.out.println("Write exception");
        }
    }
}


