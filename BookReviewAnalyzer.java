package assingment8;
import java.util.ArrayList;
import java.util.List;

class BookReview {
    private String title;
    private int rating;

    public BookReview(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class BookReviewAnalyzer {
    public static void main(String[] args) {
        
        List<BookReview> reviews = new ArrayList<>();
        reviews.add(new BookReview("Book1", 4));
        reviews.add(new BookReview("Book2", 8));
        reviews.add(new BookReview("Book3", 6));
        reviews.add(new BookReview("Book4", 2));
        reviews.add(new BookReview("Book5", 9));
        reviews.add(new BookReview("Book6", 7));
        reviews.add(new BookReview("Book7", 3));
        reviews.add(new BookReview("Book8", 5));
        reviews.add(new BookReview("Book9", 1));
        reviews.add(new BookReview("Book10", 10));

        
        int[] ratingRanges = {1, 6};
        int[] ratingCounts = new int[ratingRanges.length];
        int positiveCount = 0;
        int neutralCount = 0;
        int negativeCount = 0;

        
        for (BookReview review : reviews) {
            int rating = review.getRating();
            if (rating >= ratingRanges[0] && rating <= ratingRanges[1]) {
                ratingCounts[0]++;
            } else {
                ratingCounts[1]++;
            }

           
            if (rating >= 7) {
                positiveCount++;
            } else if (rating >= 4) {
                neutralCount++;
            } else {
                negativeCount++;
            }
        }

    
        System.out.println("Number of books reviewed within 1-5 stars range: " + ratingCounts[0]);
        System.out.println("Number of books reviewed within 6-10 stars range: " + ratingCounts[1]);
        System.out.println("Positive reviews count: " + positiveCount);
        System.out.println("Neutral reviews count: " + neutralCount);
        System.out.println("Negative reviews count: " + negativeCount);
    }
}
