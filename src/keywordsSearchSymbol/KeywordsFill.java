package keywordsSearchSymbol;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeywordsFill {

    protected static ArrayList<String> keywordsFilling(String keywordsFileName) {

        StringBuilder keysBuilder = new StringBuilder();

        try (FileReader stream = new FileReader(keywordsFileName)){
            int s;
            while ((s = stream.read()) != -1) {
                keysBuilder.append((char) s);
            }
        } catch (IOException e) {
            System.out.println("Exception");;
        }
        return new ArrayList<>(Arrays.asList(keysBuilder.toString().split(" ")));
    }

    protected static String read (String javaCodeFileName) {

        StringBuilder javaCodeText = new StringBuilder();

        try (FileReader input = new FileReader(javaCodeFileName)){
            int r;
            while ((r = input.read()) != -1) {
                javaCodeText.append((char) r);
            }
        } catch (IOException e) {
            System.out.println("Read exception");
        }
        return javaCodeText.toString();
    }

    protected static String keysCheck (ArrayList<String> keysInArray, String javaCodeToSearch) {
        int count = 0;
        String resultToFile = "";

        for (int i = 0; i < keysInArray.size(); i++) {
            Pattern p = Pattern.compile("\\b" + keysInArray.get(i) + "\\b", Pattern.UNICODE_CASE|Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(javaCodeToSearch);
            while(m.find()) {
                count++;
            }
            if (count != 0) {
                resultToFile += keysInArray.get(i) + " - " + count + System.getProperty("line.separator");
            }
            count = 0;
        }
        return resultToFile;
    }

    protected static void keysWrite (String dataToWrite, String resultFileName) {
        char[] chars = new char[dataToWrite.length()];
        dataToWrite.getChars(0, dataToWrite.length(), chars, 0);

        try (FileWriter writer = new FileWriter(resultFileName)){

            for (char eachChar : chars) {
                writer.write(eachChar);
            }
        } catch (IOException e) {
            System.out.println("Write exception");
        }
    }
}
