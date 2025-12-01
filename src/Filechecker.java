import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Filechecker {
    public static void main(String[] args) {
        String inputFileName = "studentsGroup4.txt";
        String outputFileName = "studentswithgrade_5.txt";
        filterStudents(inputFileName, outputFileName);
    }

    public static void filterStudents(String inputFileName, String outputFileName) {
        try {
            FileReader fileReader = new FileReader(inputFileName);
            BufferedReader reader = new BufferedReader(fileReader);

            FileWriter writer = new FileWriter(outputFileName);

            String line;
            while ((line = reader.readLine()) != null) {

                if (line.trim().endsWith("5")) {
                    writer.write(line + "\n");
                }

            }
            reader.close();
            writer.close();

            System.out.println("Filtered list saved to: " + outputFileName);

        } catch (IOException e) {
            System.out.println("Error could not read/write the file.");
            e.printStackTrace();
        }
    }
}