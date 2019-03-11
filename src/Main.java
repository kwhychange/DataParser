import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String Election = Utils.readFileAsString("data/2016_Presidential_Results.csv");
        String Education = Utils.readFileAsString("data/Education.csv");
        String Employment = Utils.readFileAsString("data/Unemployment.csv");

        DataManager essentialData = Utils.parseEssentialData(Election, Education, Employment);

        int count = 0;
        for (State state : essentialData.getStates()) {
            for (County county : state.getCounties()) {
                System.out.println(state.getName() + "," + county.toString());
                count++;
            }
        }
        System.out.println(count);
//        ArrayList<ElectionResult> results= Utils.parse2016ElectionResults(Election);
//        for(ElectionResult result:results){
//            System.out.println(result.toString());
//        }
    }
}