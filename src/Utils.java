import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

//    public static ArrayList<ElectionResult> parse2016ElectionResults(String data) {
//        ArrayList<ElectionResult> results = new ArrayList<ElectionResult>();
//
//        String[] individualData = data.split("\n");
//
//        for (int i = 1; i < individualData.length; i++) {
//            String fields = individualData[i].substring(individualData[i].indexOf(",") + 1);
//            String newField = deleteUnnecessary(fields);
//
//            //hard coding everything
//            String[] splitFields = newField.split(",");
//            ElectionResult addNew = new ElectionResult(Double.parseDouble(splitFields[0]), Double.parseDouble(splitFields[1]), Double.parseDouble(splitFields[2]),
//                    Double.parseDouble(splitFields[3]), Double.parseDouble(splitFields[4]), Integer.parseInt(splitFields[5]), Double.parseDouble(splitFields[6]),
//                    splitFields[7], splitFields[8], Integer.parseInt(splitFields[9]));
//            results.add(addNew);
//        }
//        return results;
//    }

    public static DataManager parseEssentialData(String election, String education, String employment) {
        DataManager data = new DataManager();
        ArrayList<State> states = new ArrayList<>();

        String[] electionData = election.split("\n");
        String[] educationData = education.split("\n");
        String[] employmentData = employment.split("\n");


        for (int i = 1; i < electionData.length; i++) {
            String fields = electionData[i].substring(electionData[i].indexOf(",") + 1);
            String newField = deleteUnnecessary(fields);
            String[] split = newField.split(",");
            Election2016 newElection = new Election2016(Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]));

        }
        for (int i = 6; i < educationData.length - 10; i++) {
            String fields = deleteUnnecessary(educationData[i]);
            String[] split = fields.split(",");
            Education2016 newEducation = new Education2016(Double.parseDouble([43]))
//            int indexOf = educationData[i].indexOf(",");
//            String state = educationData[i].substring(indexOf + 1, indexOf + 3);
//            if (!states.contains(state)) {
//                State newState = new State(state);
//                educationData[i] = removeParentheses(educationData[i]);
//
//                String stateName = educationData[i].substring(indexOf + 4, educationData[i].indexOf(",", indexOf + 4));
//                int
//                newState.addCounty(stateName, educationData[i].substring(0, indexOf), );
//                states.add(newState);
//            }
//
//            states.get(states.size() - 1).addCounty();
        }
        for (int i = 9; i < employmentData.length - 10; i++) {

        }
    }

    private static String removeParentheses(String field) {
        int firstParen = field.indexOf("\"");
        int secondParen = field.indexOf("\"", firstParen + 1);
        String string = field;
        while (firstParen > 0) {
            string = string.substring(0, firstParen) + deleteComma(string.substring(firstParen + 1, secondParen)) + string.substring(secondParen + 1);
            firstParen = string.indexOf("\"");
            secondParen = string.indexOf("\"", firstParen + 1);
        }
        return string;
    }

    private static String removeMoney(String string) {
        return string.substring(0, string.indexOf("$")) + string.substring(string.indexOf("$") + 1);
    }

    private static String deleteUnnecessary(String fields) {
        String necessary = "";
        int firstParen = fields.indexOf("\"");
        if (firstParen > 0) {
            int secondParen = fields.indexOf("\"", firstParen + 1);
            int percentSign = fields.indexOf("%", secondParen);
            necessary = fields.substring(0, firstParen) + deleteComma(fields.substring(firstParen + 1, secondParen))
                    + fields.substring(secondParen + 1, percentSign) + fields.substring(percentSign + 1);
        } else {
            int percentSign = fields.indexOf("%");
            necessary = fields.substring(0, percentSign) + fields.substring(percentSign + 1);
        }
        return necessary;
    }

    private static String deleteComma(String substring) {
        if (substring.equals(",")) return "";
        if (substring.indexOf(",") < 0) return substring;
        return deleteComma(substring.substring(0, 1)) + deleteComma(substring.substring(1));
    }
}
