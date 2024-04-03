package assingment8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentTestScoresAnalyzer {
    public static void main(String[] args) {
        
        List<Integer> testScores = new ArrayList<>();
        testScores.add(85);
        testScores.add(90);
        testScores.add(75);
        testScores.add(95);
        testScores.add(80);
        testScores.add(70);
        testScores.add(88);
        testScores.add(92);
        testScores.add(82);
        testScores.add(78);

        
        double sum = 0;
        for (int score : testScores) {
            sum += score;
        }
        double average = sum / testScores.size();

        
        Collections.sort(testScores);
        double median;
        if (testScores.size() % 2 == 0) {
            median = (testScores.get(testScores.size() / 2 - 1) + testScores.get(testScores.size() / 2)) / 2.0;
        } else {
            median = testScores.get(testScores.size() / 2);
        }

        
        int aboveAverage = 0, atAverage = 0, belowAverage = 0;
        for (int score : testScores) {
            if (score > average) {
                aboveAverage++;
            } else if (score < average) {
                belowAverage++;
            } else {
                atAverage++;
            }
        }

        
        System.out.println("Number of students above average: " + aboveAverage);
        System.out.println("Median score for students above average: " + median);
        System.out.println();
        System.out.println("Number of students at average: " + atAverage);
        System.out.println("Median score for students at average: " + median);
        System.out.println();
        System.out.println("Number of students below average: " + belowAverage);
        System.out.println("Median score for students below average: " + median);
    }
}
