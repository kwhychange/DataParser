import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String Election = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String Education = Utils.readFileAsString("data/Education.csv");
        String Employment = Utils.readFileAsString("data/Unemployment.csv");
        String Homeless = Utils.readFileAsString("data/State Homelessness Breakdown.csv");

//        ArrayList<HomelessData> HomelessResults = Utils.parseHomelessData(Homeless);
//        ArrayList<EducationResult> EducationResults = Utils.parseEducationResults(Education);
        ArrayList<UnemploymentResult> UnemploymentResults = Utils.parseUnemployment(Employment);

//        int count = 0;
        for (UnemploymentResult result: UnemploymentResults) {
            System.out.println(result.toString());
        }
//        System.out.println(count);

    }
}