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

    public static ArrayList<ElectionResult> parse2016ElectionResults(String data) {
        ArrayList<ElectionResult> results = new ArrayList<ElectionResult>();

        String[] individualData = data.split("\n");

        for (int i = 0; i < individualData.length; i++) {
            String fields = individualData[i].substring(individualData[i].indexOf(",") + 1);
            String newField = deleteParentheses(fields);

            //hard coding everything
            String[] separatedFields = new

            ElectionResult addNew = new ElectionResult();
            results.add(addNew);
        }
        return results;
    }

    private static String deleteParentheses(String fields) {
    }

}
