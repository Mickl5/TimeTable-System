import java.io.*;
import java.util.ArrayList;


/**
 * An auxiliary class with only static methods used to perform operations on CSV files such as read or write
 * */
public class CSVutils {
    /**
     * @param filePath the file path to the file you want to read from
     * */
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

    /**
     * @param filePath the file path to the file you want to read from
     * @param data the data that will be written inside the csv
     * */
    public static void writeCSV(String filePath, ArrayList<String[]> data) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
        }
    }

    /**
     * @param filePath the file path to the file that will be appended to
     * @param row the row that will be appended at the end of the file pointed to by the file path
     * */
    public static void appendRow(String filePath, String[] row) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(String.join(",", row));
            writer.newLine();
        }
    }

    /**
     * @param filePath the file path to the file that will be appended to
     * @param rowIndex the row that will be deleted in the file pointed by the file path
     * */
    public static void deleteRow(String filePath, int rowIndex) throws IOException {
        ArrayList<String[]> data = readCSV(filePath);

        if (rowIndex < 0 || rowIndex >= data.size()) throw new IndexOutOfBoundsException();

        data.remove(rowIndex);
        writeCSV(filePath, data);
    }
}
