public class Movie {
    private String title;
    private String leadActor;
    private int releaseYear;
    private String director;

    public Movie(String t, String l, int r, String d) {
        title = t;
        leadActor = l;
        releaseYear = r;
        director = d;
    }

    public String getTitle() {
        return title;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getDirector() {
        return director;
    }
}
