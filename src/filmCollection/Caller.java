package filmCollection;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;
import static filmCollection.MySerializator.*;

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
            String title = input.nextLine();
            while (title.length() == 0) {
                title = input.nextLine();
            }
            System.out.println("Enter actor name: ");
            String actor = input.nextLine();
            while (actor.length() == 0) {
                actor = input.nextLine();
            }
            addNewFilm(title, actor);
            editFilmCollection();
//        } else if (rowChooseAction.equalsIgnoreCase("e")) {
//            removeFilm();
        } else if (rowChooseAction.equalsIgnoreCase("r")) {
            System.out.println("Enter film title: ");
            String title = input.next();
            // check valid title here !!!
            removeFilm(title);
        }  else if (rowChooseAction.equalsIgnoreCase("s")) {
            serializeToFile(fileName);
            System.out.println("Film collection serialized to file: " + fileName);
        }  else {
            System.out.println("Wrong input, try again.");
            editFilmCollection();
        }
    }

}
