package filmCollection;

import java.io.*;

public class MySerializator {

    private static Film newFilm;

    protected static void deserialization(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        newFilm = (Film) ois.readObject();
        ois.close();
//        newFilm.simpleView();
    }

    public static void addNewFilm(String title, String actor) {

        newFilm.getFilmCol().put(title, actor);
    }

    public static void removeFilm(String title) {

        newFilm.getFilmCol().remove(title);

    }

    protected static void serializeToFile(String fileName) throws IOException {

    FileOutputStream fos = new FileOutputStream(fileName);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(newFilm);
        oos.close();
    }

    public static Film getNewFilm() {
        return newFilm;
    }
}
