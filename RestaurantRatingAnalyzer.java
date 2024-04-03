package assingment8;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Restaurant {
    private String name;
    private double rating;

    public Restaurant(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
}

public class RestaurantRatingAnalyzer {
    public static void main(String[] args) {
        
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Restaurant1", 4.5));
        restaurants.add(new Restaurant("Restaurant2", 7.8));
        restaurants.add(new Restaurant("Restaurant3", 6.3));
        restaurants.add(new Restaurant("Restaurant4", 9.2));
        restaurants.add(new Restaurant("Restaurant5", 3.7));
        restaurants.add(new Restaurant("Restaurant6", 8.5));
        restaurants.add(new Restaurant("Restaurant7", 2.1));
        restaurants.add(new Restaurant("Restaurant8", 5.6));
        restaurants.add(new Restaurant("Restaurant9", 6.7));
        restaurants.add(new Restaurant("Restaurant10", 8.0));

        
        int[] ratingRanges = {1, 6}; 
        Map<Integer, Integer> ratingCounts = new HashMap<>();
        Map<Integer, Double> ratingSum = new HashMap<>();
        Map<Integer, Double> ratingAverage = new HashMap<>();

        
        for (int i = 0; i < ratingRanges.length; i++) {
            ratingCounts.put(i, 0);
            ratingSum.put(i, 0.0);
        }

        
        for (Restaurant restaurant : restaurants) {
            double rating = restaurant.getRating();
            int rangeIndex = rating < ratingRanges[1] ? 0 : 1;
            ratingCounts.put(rangeIndex, ratingCounts.get(rangeIndex) + 1);
            ratingSum.put(rangeIndex, ratingSum.get(rangeIndex) + rating);
        }

        
        for (int i = 0; i < ratingRanges.length; i++) {
            int count = ratingCounts.get(i);
            double sum = ratingSum.get(i);
            double average = count == 0 ? 0 : sum / count;
            ratingAverage.put(i, average);
        }

        
        for (int i = 0; i < ratingRanges.length; i++) {
            int rangeStart = i == 0 ? ratingRanges[0] : ratingRanges[1] + 1;
            int rangeEnd = i == 0 ? ratingRanges[1] : 10;
            System.out.println("Number of restaurants rated within " + rangeStart + "-" + rangeEnd + " range: " + ratingCounts.get(i));
            System.out.println("Average rating for this range: " + ratingAverage.get(i));
            System.out.println();
        }
    }
}
