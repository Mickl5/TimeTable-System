import java.io.*;
import java.util.ArrayList;

public class CSVutils {

    public static ArrayList<String[]> readCSV(String filePath) throws IOException{
        ArrayList<String[]> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                rows.add(row);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }

    public static void writeCSV(String filePath, ArrayList<String[]> data) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
        }
    }

    public static void appendRow(String filePath, String[] row) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(String.join(",", row));
            writer.newLine();
        }
    }

    public static void deleteRow(String filePath, int rowIndex) throws IOException {
        ArrayList<String[]> data = readCSV(filePath);

        if (rowIndex < 0 || rowIndex >= data.size()) throw new IndexOutOfBoundsException();

        data.remove(rowIndex);
        writeCSV(filePath, data);
    }
}
