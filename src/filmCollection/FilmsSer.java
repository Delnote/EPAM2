package filmCollection;

import java.io.IOException;

public class FilmsSer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String fileName = "FilmsCollection.txt";

//        ArrayList<Film> films = new ArrayList<>();
//        films.add(new Film("Title 1", 1990, "Actor 1", "Actor 2"));
//        films.add(new Film("Title 2", 2001, "Actor 2-1", "Actor2-2"));


        Caller caller = new Caller();
        caller.getFilmCollection(fileName);

        caller.editFilmCollection();

//        serializeToFile(fileName);

//        deserialization(fileName);
    }



}
