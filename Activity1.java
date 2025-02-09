import java.util.ArrayList;

class Movie {
    private String title;
    private String genre;
    private int duration; 
    private int rating; 

    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = 0;
    }

    public String getTitle() {
        return title;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Rating: " + (rating == 0 ? "Not rated yet" : rating + "/5"));
    }

    public void play() {
        System.out.println("Now playing: " + title + "... Enjoy your movie!");
    }

    public void rateMovie(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
            System.out.println("You rated " + title + " a " + rating + "/5");
        } else {
            System.out.println("Invalid rating. Please rate between 1 and 5.");
        }
    }
}

public class Activity1 {
    private static ArrayList<Movie> movieList = new ArrayList<>();

    public static void main(String[] args) {
        
        movieList.add(new Movie("Inglourious Basterds", "War", 153));
        movieList.add(new Movie("Goodfellas", "Crime", 146));
        movieList.add(new Movie("Smile", "Horror", 115));
        movieList.add(new Movie("The Wolf of Wall Street", "Comedy", 180));
        
        displayMovies();
        viewMovieDetails(1);
        playMovie(2);
        rateMovie(1, 5);
        rateMovie(3, 4);
    }

    private static void displayMovies() {
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i + 1) + ". " + movieList.get(i).getTitle());
        }
    }

    private static void viewMovieDetails(int movieIndex) {
        if (isValidIndex(movieIndex - 1)) {
            movieList.get(movieIndex - 1).displayDetails();
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    private static void playMovie(int movieIndex) {
        if (isValidIndex(movieIndex - 1)) {
            movieList.get(movieIndex - 1).play();
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    private static void rateMovie(int movieIndex, int rating) {
        if (isValidIndex(movieIndex - 1)) {
            movieList.get(movieIndex - 1).rateMovie(rating);
        } else {
            System.out.println("Invalid selection. Please try again.");
        }
    }

    private static boolean isValidIndex(int index) {
        return index >= 0 && index < movieList.size();
    }
}
