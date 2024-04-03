package assingment8;
import java.util.HashMap;
import java.util.Map;

class Movie {
    private String title;
    private String category;
    private double rating;

    public Movie(String title, String category, double rating) {
        this.title = title;
        this.category = category;
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }
}

public class MovieRatingsAnalyzer {
    public static void main(String[] args) {
        
        Movie[] movies = {
            new Movie("Movie1", "PG", 4.5),
            new Movie("Movie2", "PG-13", 3.8),
            new Movie("Movie3", "R", 4.2),
            new Movie("Movie4", "PG1", 3.9),
            new Movie("Movie5", "R1", 4.8),
            new Movie("Movie6", "PG-14", 3.5),
            new Movie("Movie7", "PG2", 4.1),
            new Movie("Movie8", "PG-15", 4.3),
            new Movie("Movie9", "R2", 4.6),
            new Movie("Movie10", "PG-16", 3.7)
        };

        
        Map<String, Integer> movieCounts = new HashMap<>();
        Map<String, Double> categoryRatings = new HashMap<>();

        for (Movie movie : movies) {
            String category = movie.getCategory();
            double rating = movie.getRating();

            
            movieCounts.put(category, movieCounts.getOrDefault(category, 0) + 1);

            
            categoryRatings.put(category, categoryRatings.getOrDefault(category, 0.0) + rating);
        }

        for (String category : movieCounts.keySet()) {
            int count = movieCounts.get(category);
            double totalRating = categoryRatings.get(category);
            double averageRating = totalRating / count;

            System.out.println("Category: " + category);
            System.out.println("Number of movies: " + count);
            System.out.println("Average rating: " + averageRating);
            System.out.println();
        }
    }
}