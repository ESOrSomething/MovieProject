import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files
import java.util.ArrayList;

public class MovieDB {
    public static ArrayList<Movie> readMoviesIntoAL(String filename) {
        File myObj = new File(filename);
        ArrayList<Movie> movies = new ArrayList<>();

        // try-with-resources: Scanner will be closed automatically
        try (Scanner myReader = new Scanner(myObj)) {
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] attributes = data.split(" \\| ");
            movies.add(new Movie(attributes[0], attributes[1], Integer.parseInt(attributes[2]), attributes[3]));
        }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return movies;
    }
    public static void main(String[] args) {
        ArrayList<Movie> movies = readMoviesIntoAL("movies.txt");
        System.out.println(movies.get(0).toString());
    }
}
