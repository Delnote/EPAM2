package keywordsSearchByte;

import java.util.ArrayList;

import static keywordsSearchByte.KeywordsFill.*;

public class ByteInput {
    public static void main(String[] args) {

        String keywordsFile = "keyWords.txt";
        String javaCodeFile = "javaCode.txt";
        String resultFileName = "ResultByteIO.txt";
        String javaCodeToSearch;
        String dataToWrite;
        ArrayList<String> keysInArray;


        keysInArray = keywordsFilling(keywordsFile);
        javaCodeToSearch = read(javaCodeFile);
        dataToWrite = keysCheck(keysInArray, javaCodeToSearch);
        keysWrite(dataToWrite, resultFileName);
    }
}
