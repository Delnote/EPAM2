package keywordsSearchByte;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static keywordsSearchByte.KeywordsFill.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KeywordsFillTest {

    private String keywordsFile;
    private String javaCodeFile;
    private ArrayList<String> keys = new ArrayList<>();

    @Before
    public void setUp() {
        keywordsFile = "keyWordsTest.txt";
        javaCodeFile = "javaCodeTest.txt";
        keys.add("for");
        keys.add("if");
        keys.add("while");
        keys.add("else");
    }


    @Test
    public void checkCreatingKeywordsFillInstances() {
        assertNotNull(keywordsFilling(keywordsFile));
        assertEquals(1, keywordsFilling("").size());
        assertEquals("", keywordsFilling("").get(0));
    }

    @Test
    public void correctReadingFromFile() {
        assertNotNull(read(javaCodeFile));
        assertEquals("", read(""));
    }

    @Test
    public void checkingKeysInTextFromFile() {
        String separator = System.getProperty("line.separator");
        String res = "for - 1" + separator + "if - 1" + separator + "while - 1" + separator + "else - 1" + separator;
        assertEquals("", keysCheck(new ArrayList<>(), ""));
        assertEquals("", keysCheck(keys, "ifwhile elsefor"));
        assertEquals("", keysCheck(keys, ""));
        assertEquals(res, keysCheck(keys, "if while else for"));
    }

    @After
    public void setClear() {
        keywordsFile = "";
        javaCodeFile = "";
    }

}
