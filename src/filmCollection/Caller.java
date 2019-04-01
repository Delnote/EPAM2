package filmCollection;

import java.io.IOException;
import java.util.Scanner;

import static filmCollection.MySerializator.*;
import static java.lang.System.in;

public class Caller {

    private String fileName = "FilmsCollection.txt";

    protected void getFilmCollection() throws IOException, ClassNotFoundException {
        System.out.println("Get movie collection? (y/n)");
        Scanner input = new Scanner(in);
        String rowYes = input.next();
        if (rowYes.equalsIgnoreCase("y")) {
            deserialization(fileName);
            getNewFilm().simpleView();
        } else if (rowYes.equalsIgnoreCase("n")) {
            System.out.println("Maybe next time...");
        } else {
            System.out.println("Wrong input!");
            getFilmCollection();
        }
    }


    protected void editFilmCollection() throws IOException, ClassNotFoundException {
        System.out.println("Want to add(a), edit(e), remove(r) or save(s) collection? (a/e/r/s):");
        Scanner input = new Scanner(in);
        String rowChooseAction = input.next();
        if (rowChooseAction.equalsIgnoreCase("a")) {
            System.out.println("Enter film title: ");
            String title = "";
            while (title.length() == 0) {
                title = input.nextLine();
            }
            System.out.println("Enter actor name: ");
            String actor = "";
            while (actor.length() == 0) {
                actor = input.nextLine();
            }
            addNewFilm(title, actor);
            editFilmCollection();
        } else if (rowChooseAction.equalsIgnoreCase("e")) {
            System.out.println("Search film by title: ");
            String title = "";
            while (title.length() == 0) {
                title = input.nextLine();
                while (getNewFilm().getFilmCol().get(title) == null) {
                    System.out.println("Film not found, try again:");
                    title = input.nextLine();
                }
            }
            System.out.println("Eвше actor name: ");
            String actor = "";
            while (actor.length() == 0) {
                actor = input.nextLine();
            }
            getNewFilm().getFilmCol().replace(title, actor);
            System.out.printf("You edited film \"%s\". \n\n", title);
            editFilmCollection();
        } else if (rowChooseAction.equalsIgnoreCase("r")) {
            System.out.println("Enter film title: ");
            String title = "";
            while (title.length() == 0) {
                title = input.nextLine();
                while (getNewFilm().getFilmCol().get(title) == null) {
                    System.out.println("Film not found, try again:");
                    title = input.nextLine();
                }
            }
            removeFilm(title);
            System.out.println("Film " + title + " removed from collection.\n");
            editFilmCollection();
        }  else if (rowChooseAction.equalsIgnoreCase("s")) {
            serializeToFile(fileName);
            System.out.println("Film collection serialized to file: " + fileName);
        }  else {
            System.out.println("Wrong input, try again.");
            editFilmCollection();
        }
    }

}
