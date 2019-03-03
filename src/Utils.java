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

        for (int i = 1; i < individualData.length; i++) {
            String fields = individualData[i].substring(individualData[i].indexOf(",") + 1);
            String newField = deleteUnnecessary(fields);

            //hard coding everything
            String[] splitFields = newField.split(",");
            double parse0 = Double.parseDouble(splitFields[0]);
            double parse1 = Double.parseDouble(splitFields[1]);
            double parse2= Double.parseDouble(splitFields[2]);
            double parse3 = Double.parseDouble(splitFields[3]);
            double parse4 = Double.parseDouble(splitFields[4]);
            int parse5 = Integer.parseInt(splitFields[5]);
            double parse6 = Double.parseDouble(splitFields[6]);
            int parse9 = Integer.parseInt(splitFields[9]);
            ElectionResult addNew = new ElectionResult(parse0, parse1, parse2, parse3, parse4, parse5, parse6, splitFields[7], splitFields[8], parse9);
            results.add(addNew);
        }
        return results;
    }

    private static String deleteUnnecessary(String fields) {
        String necessary = "";
        int firstParen = fields.indexOf("\"");
        if(firstParen > 0) {
            int secondParen = fields.indexOf("\"", firstParen + 1);
            int percentSign = fields.indexOf("%", secondParen);
            necessary = fields.substring(0, firstParen) + deleteComma(fields.substring(firstParen + 1, secondParen))
                    + fields.substring(secondParen + 1, percentSign)+ fields.substring(percentSign + 1);
            System.out.println("*");
        } else {
            int percentSign = fields.indexOf("%");
            necessary = fields.substring(0, percentSign) + fields.substring(percentSign + 1);
        }
        return necessary;
    }

    private static String deleteComma(String substring) {
        String[] splitComma = substring.split(",");
        String deleted = "";
        for(String string : splitComma){
            deleted += string;
        }
        return deleted;
    }
}
