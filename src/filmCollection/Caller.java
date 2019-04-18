package filmCollection;

import java.io.IOException;
import java.util.Scanner;

import static filmCollection.MySerializator.*;
import static java.lang.System.in;

public class Caller {


    public void getFilmCollection(String fileName) throws IOException, ClassNotFoundException {
        System.out.println("Get movie collection? (y/n)");
        Scanner input = new Scanner(in);
        String rowYes = input.next();
        if (rowYes.equalsIgnoreCase("y")) {
            deserialization(fileName);
        } else if (rowYes.equalsIgnoreCase("n")) {
            System.out.println("Maybe next time...");
        } else {
            System.out.println("Wrong input!");
            getFilmCollection(fileName);
        }
    }


    protected void editFilmCollection() throws IOException {
        System.out.println("Want to add(a), remove element(r) or save(s) collection? (a/r/s):");
        Scanner input = new Scanner(in);
        String rowChooseAction = input.next();
        if (rowChooseAction.equalsIgnoreCase("a")) {
            System.out.println("Enter film title: ");
            String title = "";
            while (title.length() == 0) {
                title = input.nextLine();
            }
            System.out.println("Enter main actor name: ");
            String actor = "";
            while (actor.length() == 0) {
                actor = input.nextLine();
            }
            System.out.println("Enter main second actor name: ");
            String actor2 = "";
            while (actor2.length() == 0) {
                actor2 = input.nextLine();
            }
            System.out.println("Enter film year: ");
            int year = input.nextInt();
            while (year > 2019 || year < 1900) {
                System.out.println("Wrong year, try again:");
                year = input.nextInt();
            }
            newFilms.add(new Film(title, year, actor, actor2));
            editFilmCollection();
//        } else if (rowChooseAction.equalsIgnoreCase("e")) {
//            System.out.println("Search film by title: ");
//            String title = "";
//            while (title.length() == 0) {
//                title = input.nextLine();
//                while (getNewFilm().getFilmCol().get(title) == null) {
//                    System.out.println("Film not found, try again:");
//                    title = input.nextLine();
//                }
//            }
//            System.out.println("Eвше actor name: ");
//            String actor = "";
//            while (actor.length() == 0) {
//                actor = input.nextLine();
//            }
//            getNewFilm().getFilmCol().replace(title, actor);
//            System.out.printf("You edited film \"%s\". \n\n", title);
//            editFilmCollection(fileName);
        } else if (rowChooseAction.equalsIgnoreCase("r")) {
            System.out.println("Enter film position: ");
            int pos = input.nextInt();
            while (pos < 1 || pos > newFilms.size()) {
                System.out.println("Wrong number, try again: ");
                pos = input.nextInt();
                }
            newFilms.remove(pos - 1);
            System.out.printf("Film №%d removed from collection.\n", pos);
            editFilmCollection();
        } else if (rowChooseAction.equalsIgnoreCase("s")) {
            serializeToFile("FilmsCollection.txt");
            System.out.println("Film collection serialized to file: " + "FilmsCollection.txt");
        }  else {
            System.out.println("Wrong input, try again.");
            editFilmCollection();
        }
    }
}
