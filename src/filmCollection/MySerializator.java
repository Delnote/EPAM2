package filmCollection;

import java.io.*;
import java.util.ArrayList;

public class MySerializator {

    static ArrayList<Film> newFilms = new ArrayList<>();

    public static void deserialization(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        newFilms = (ArrayList<Film>) ois.readObject();
        ois.close();
        int i = 1;
        for (Film f : newFilms) {
            System.out.printf("%d. \t Title: %s \t Year: %d \t  Main Actor: %s \t Second Actor: %s \n", i, f.getTitle(), f.getYear(), f.getMainActor(), f.getSecondActor());
            i++;
        }
    }

    public static void serializeToFile(String fileName) throws IOException {

    FileOutputStream fos = new FileOutputStream(fileName);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(newFilms);
        oos.close();
    }

}
