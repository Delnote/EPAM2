package filmCollection;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static filmCollection.MySerializator.deserialization;
import static filmCollection.MySerializator.serializeToFile;

public class MySerializatorTest {

    @Test(expected = FileNotFoundException.class)
    public void testFileInput() throws IOException, ClassNotFoundException {
        deserialization("");
    }

    @Test(expected = IOException.class)
    public void testDataOutputInFile() throws IOException {
        serializeToFile("");
    }
}
