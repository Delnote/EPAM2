package keywordsSearchSymbol;

import java.util.ArrayList;

import static keywordsSearchSymbol.KeywordsFill.*;

public class SymbolInput {

    public static void main(String[] args) {

        String keywordsFile = "keyWords.txt";
        String javaCodeFile = "javaCode.txt";
        String resultFileName = "ResultSymbolIO.txt";
        String javaCodeToSearch;
        String dataToWrite;
        ArrayList<String> keysInArray;


        keysInArray = keywordsFilling(keywordsFile);
        javaCodeToSearch = read(javaCodeFile);
        dataToWrite = keysCheck(keysInArray, javaCodeToSearch);
        keysWrite(dataToWrite, resultFileName);
    }
}
