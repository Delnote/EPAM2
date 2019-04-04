package keywordsSearchSymbol;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KeywordsFillTest {


    private String keywordsFile;
    private KeywordsFill keywordsFill;
    private String javaCodeFile;

    @Before
    public void setUp() {
        keywordsFill = new KeywordsFill();
        keywordsFile = "keyWordsTest.txt";
        javaCodeFile = "javaCodeTest.txt";
    }


    @Test
    public void ShouldCreatingKeywordsFillInstances() {
        assertNotNull(keywordsFill);
        assertNotNull(keywordsFill.keywordsFilling(keywordsFile));
        assertNotNull(keywordsFill.read(javaCodeFile));

    }

    @Test
    public void keywordsFillingCorrectReadingKeywordsFromFile() {
        assertEquals(12, keywordsFill.keywordsFilling(keywordsFile).size());
        assertFalse(keywordsFill.keywordsFilling("keywordsFileNull.txt").size() == 0);
    }

    @Test
    public void read() {
        String test = "class else for if\\if int new private.else protected - else. public return static while new? (return)";
        assertEquals(test, keywordsFill.read(javaCodeFile));
    }

    @Test
    public void keysCheck() {
        assertNotNull(keywordsFill.keysCheck(keywordsFill.keywordsFilling(keywordsFile), keywordsFill.read(javaCodeFile)));
    }

    @Test
    public void keysWrite() {

    }

    @After
    public void SetClear() {
        keywordsFill = null;
        keywordsFile = "";
        javaCodeFile = "";
    }
}