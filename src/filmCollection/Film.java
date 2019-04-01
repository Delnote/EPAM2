package filmCollection;

import java.io.Serializable;
import java.util.HashMap;

public class Film implements Serializable {
    private static final long serialVersionUID = 3582196263062499156L;
    private HashMap <String, String> filmCol = new HashMap<>();

//    protected void films() {

//        filmCol.put("Pulp Fiction", "John Travolta");
//        filmCol.put("Reservoir Dogs", "Tim Roth");
//        filmCol.put("Kill Bill", "Uma Thurman");
//        filmCol.put("Jackie Brown", "Samuel L. Jackson");
//        filmCol.put("Death Proof", "Quentin Tarantinoо");
//        filmCol.put("Inglourious Basterds", "Brad Pitt");
//        filmCol.put("Django Unchained", "Samuel L. Jackson");
//        filmCol.put("The Hateful Eight", "Tim Roth");
//        filmCol.put("Natural Born Killers", "Woody Harrelson");
//        filmCol.put("From Dusk Till Dawn", "Quentin Tarantino");
//        filmCol.put("Four Rooms", "Tim Roth");
//        filmCol.put("Smokin' Aces", "Jeremy Piven");
//    }

    public void simpleView() {
        for (HashMap.Entry entry : filmCol.entrySet()) {
            System.out.println("Film title: " + entry.getKey() + "\n" + " Actor: " + entry.getValue() + "\n");
        }
    }

    public HashMap<String, String> getFilmCol() {
        return filmCol;
    }
}
