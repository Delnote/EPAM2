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

        serializeToFile(fileName);
    }

}
