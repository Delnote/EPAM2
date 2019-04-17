package filmCollection;

import java.io.Serializable;

public class Film implements Serializable {
    private static final long serialVersionUID = 3582196263062499156L;

    private String title;
    private int year;
    private String mainActor;
    private String secondActor;

    Film(String title, int year, String mainActor, String secondActor){
        this.title = title;
        this.year = year;
        this.mainActor = mainActor;
        this.secondActor = secondActor;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getMainActor() {
        return mainActor;
    }

    public String getSecondActor() {
        return secondActor;
    }
}
