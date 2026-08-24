import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files
import java.util.ArrayList;

public class MovieDB {
    private String title;
    private String leadActor;
    private int releaseYear;
    private String director;

    public MovieDB(String t, String l, int r, String d) {
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
    public static ArrayList<Movie> readMoviesIntoAL(String filename) {
        File myObj = new File(filename);
        ArrayList<Movie> movies = new ArrayList<>();

        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
            String[] attributes = data.split("\\t");
            movies.add(new Movie(attributes[0], attributes[1], attributes[2], attributes[3]));
        }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return movies;
    }
    public static void main(String[] args) {
        readMoviesIntoAL("movies.txt");
    }
}
