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

    public static ArrayList<EducationResult> parseEducationResults(String data) {
        ArrayList<EducationResult> results = new ArrayList<>();

        String[] individualData = data.split("\n");

        for (int i = 5; i < individualData.length - 10; i++) {
            String fields = removeParentheses(individualData[i]);
            String[] split = fields.split(",");

            try {
                EducationResult addNew = new EducationResult(split[1], split[2], Double.parseDouble(split[35]), Double.parseDouble(split[36]), Double.parseDouble(split[37]), Double.parseDouble(split[38]),
                        +Double.parseDouble(split[39]), Double.parseDouble(split[40]), Double.parseDouble(split[41]), Double.parseDouble(split[42]),
                        +Double.parseDouble(split[43]), Double.parseDouble(split[44]), Double.parseDouble(split[45]), Double.parseDouble(split[46]));
                results.add(addNew);
            } catch (Exception e) {
                System.out.println("error " + i);
            }
        }
        return results;
    }

    public static ArrayList<ElectionResult> parse2016ElectionResults(String data) {
        ArrayList<ElectionResult> results = new ArrayList<ElectionResult>();

        String[] individualData = data.split("\n");

        for (int i = 1; i < individualData.length; i++) {
            String fields = individualData[i].substring(individualData[i].indexOf(",") + 1);
            String newField = deleteUnnecessary(fields);

            //hard coding everything
            String[] splitFields = newField.split(",");
            ElectionResult addNew = new ElectionResult(Double.parseDouble(splitFields[0]), Double.parseDouble(splitFields[1]), Double.parseDouble(splitFields[2]),
                    Double.parseDouble(splitFields[3]), Double.parseDouble(splitFields[4]), Integer.parseInt(splitFields[5]), Double.parseDouble(splitFields[6]),
                    splitFields[7], splitFields[8], Integer.parseInt(splitFields[9]));
            results.add(addNew);
        }
        return results;
    }

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
            Election2016 newElection = new Election2016(Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]));
            County county = county(data, split, 7, 9, 8);
            county.setVote2016(newElection);
        }
        for (int i = 5; i < educationData.length - 10; i++) {
            String fields = removeParentheses(educationData[i]);
            String[] split = fields.split(",");
            try {
                Education2016 newEducation = new Education2016(Double.parseDouble(split[39]), Double.parseDouble(split[40]), Double.parseDouble(split[41]), Double.parseDouble(split[42]));
                County county = county(data, split, 1, 0, 2);
                county.setEduc2016(newEducation);
            } catch (Exception e) {
                System.out.println("Education error " + i);
            }
        }
        for (int i = 9; i < employmentData.length; i++) {
            String fields = removeParentheses(employmentData[i]);
            String[] split = fields.split(",");
            try {
                Employment2016 newEmployment = new Employment2016(Integer.parseInt(split[42].trim()), Integer.parseInt(split[43].trim()), Integer.parseInt(split[44].trim()), Double.parseDouble(split[45].trim()));
                County county = county(data, split, 1, 0, 2);
                county.setEmploy2016(newEmployment);
            } catch (Exception e) {
                System.out.println("employment error " + i);
            }
        }
        return data;
    }

    private static County county(DataManager data, String[] split, int stateIndex, int fipsIndex, int countyIndex) {
        String stateName = split[stateIndex];
        int index = data.stateIndex(stateName);
        State newState;
        if (index == -1) {
            newState = new State(stateName);
            data.add(newState);
        } else {
            newState = data.getStates().get(index);
        }

        int fips = Integer.parseInt(split[fipsIndex]);
        int cIndex = newState.countyIndex(fips);
        if (cIndex == -1) {
            String countyName = split[countyIndex];
            if (endsInCapital(countyName)) countyName = countyName.substring(0, countyName.length() - 3);
            County county = new County(countyName, fips);
            newState.addCounty(county);
            return county;
        } else {
            return newState.getCounties().get(cIndex);
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

    private static boolean endsInCapital(String s) {
        char c = s.charAt(s.length() - 1);
        return c >= 'A' && c <= 'Z';
    }
}
