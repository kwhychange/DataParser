import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
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

    public static ArrayList<UnemploymentResult> parseEmployment(String data){
        ArrayList<UnemploymentResult> results = new ArrayList<>();
        String[] individualLines = data.split("\n");

        for (int dataRow = 10; dataRow < individualLines.length; dataRow++) {

            String noCommas = removeDoubleComma(individualLines[dataRow]);
            String noCommasInQuotes = removeCommasInside(noCommas);
            String readyForUse = removeQuotes(noCommasInQuotes);

            String[] allData = readyForUse.split(",");

            if (allData.length >= 50) {
                UnemploymentResult u = new UnemploymentResult(allData[1].trim(), allData[2].trim(), Double.parseDouble(allData[9].trim()), Double.parseDouble(allData[13].trim()),
                        Double.parseDouble(allData[17].trim()), Double.parseDouble(allData[21].trim()), Double.parseDouble(allData[25].trim()), Double.parseDouble(allData[29].trim()),
                        Double.parseDouble(allData[33].trim()), Double.parseDouble(allData[37].trim()), Double.parseDouble(allData[41].trim()),
                        Double.parseDouble(allData[45].trim()), Double.parseDouble(allData[49].trim()));

                results.add(u);
            }
        }
        return  results;
    }

    public static String removeQuotes(String n){
        String end = n.replace("\"", "");

        return end;
    }
    public static String removeCommasInside(String n){

        String quote = " \"\" ";
        String end = n;

        for (int i = 0; i < n.length(); i++) {
            if(n.substring(i,i+1).equals(quote.substring(1, 2))){
                int secondQuote = findSecondQuote(n, i);

                String replace = n.substring(i, secondQuote +1);
                String afterReplace = replace.replace(",", "");

                end = end.substring(0,i) + afterReplace + n.substring(secondQuote  );
                i = secondQuote +1;
            }
        }

        return end;
    }

    private static int findSecondQuote(String n, int start) {
        String quote = " \"\" ";

        for (int i = start + 1; i < n.length(); i++) {
            if(n.substring(i,i+1).equals(quote.substring(1, 2))){
                return i;
            }
        }
        return -1;
    }

    public static String removeDoubleComma(String n){
        String end = n;
        for (int i = 0; i < 6; i++) {
            end = end.replace(",,", ",");
        }
        return end;
    }
    public static String restoreInt(int string) {
        String newString = Integer.toString(string);
        for (int i = newString.length() - 3; i > 0; i -= 3) {
            newString = newString.substring(0, i) + "," + newString.substring(i);
        }
        return "\"" + newString + "\"";
    }

    public static String restoreDouble(double string) {
        String newString = "" + string;
        int index = newString.indexOf(".");
        for (int i = index - 3; i > 0; i -= 3) {
            newString = newString.substring(0, i) + "," + newString.substring(i);
        }
        return "\"" + newString + "\"";
    }

    public static ArrayList<UnemploymentResult> parseUnemployment(String data) {
        ArrayList<UnemploymentResult> results = new ArrayList<>();

        String[] individualData = data.split("\n");

        for (int i = 8; i < individualData.length; i++) {
            String fields = removeParentheses(individualData[i]);
            String[] split = fields.split(",");
            if (endsInCapital(split[2].trim())) {
                split[2] = split[2].trim().substring(0, split[2].trim().length() - 3);
            }
            try {
                UnemploymentResult addNew = new UnemploymentResult(split[1].trim(), split[2].trim(), Double.parseDouble(split[9].trim()), Double.parseDouble(split[13].trim()), Double.parseDouble(split[17].trim()),
                        +Double.parseDouble(split[21].trim()), Double.parseDouble(split[25].trim()), Double.parseDouble(split[29].trim()), Double.parseDouble(split[33].trim()), Double.parseDouble(split[37].trim()),
                        +Double.parseDouble(split[41].trim()), Double.parseDouble(split[45].trim()), Double.parseDouble(split[49].trim()));
                results.add(addNew);
            } catch (Exception e) {
                System.out.println("error " + (i + 1));
            }
        }
        return results;
    }

    public static ArrayList<HomelessData> parseHomelessData(String data) {
        ArrayList<HomelessData> results = new ArrayList<>();

        String[] individualData = data.split("\n");

        for (int i = 1; i < individualData.length; i++) {
            String fields = removeParentheses(individualData[i]);
            String[] split = fields.split(",");

            try {
                HomelessData addNew = new HomelessData(split[1], (Double.parseDouble(split[3]))/ (242660171)*100, (Double.parseDouble(split[4]))/(240292912)*100);
                results.add(addNew);
            } catch (Exception e) {
                System.out.println("error " + (i + 1));
            }
        }
        return results;
    }

    public static ArrayList<EducationResult> parseEducationResults(String data) {
        ArrayList<EducationResult> results = new ArrayList<>();

        String[] individualData = data.split("\n");

        for (int i = 5; i < individualData.length - 10; i++) {
            String fields = removeParentheses(individualData[i]);
            String[] split = fields.split(",");

            try {
                EducationResult addNew = new EducationResult(split[1], split[2], Double.parseDouble(split[35]), Double.parseDouble(split[36]), Double.parseDouble(split[37]), Double.parseDouble(split[38]),
                        +Integer.parseInt(split[39]), Integer.parseInt(split[40]), Integer.parseInt(split[41]), Integer.parseInt(split[42]),
                        +Double.parseDouble(split[43]), Double.parseDouble(split[44]), Double.parseDouble(split[45]), Double.parseDouble(split[46]));
                results.add(addNew);
            } catch (Exception e) {
                System.out.println("error " + (i + 1));
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
