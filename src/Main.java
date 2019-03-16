import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String Election = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String Education = Utils.readFileAsString("data/Education.csv");
        String Employment = Utils.readFileAsString("data/Unemployment.csv");

        ArrayList<EducationResult> results = Utils.parseEducationResults(Education);

//        int count = 0;
        for (EducationResult result : results) {
            System.out.println(result.toString());
        }
//        System.out.println(count);
    }
}