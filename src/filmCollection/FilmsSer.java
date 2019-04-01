package filmCollection;

import java.io.IOException;

import static filmCollection.MySerializator.*;

public class FilmsSer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Film film = new Film();
//        film.films();
        String fileName = "FilmsCollection.txt";

        Caller caller = new Caller();
        caller.getFilmCollection();

        caller.editFilmCollection();


//        deserialization(fileName);

//        addNewFilm("Test2", "Various actor");

        serializeToFile(fileName);

//        FileInputStream fis = new FileInputStream("FilmsCollection.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        Film newFilmCol = (Film) ois.readObject();
//        ois.close();
//        newFilmCol.simpleView();

//        newFilmCol.getFilmCol().put("One more interesting film", "Another other actor");
//
//        FileOutputStream fos = new FileOutputStream("FilmsCollection.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(film);
//        oos.close();

    }

}
