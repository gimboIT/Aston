import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVDataManager {
    private static final String DELIMITER = ";";

    public static void save(AppData data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.join(DELIMITER, data.getHeader()));
            writer.newLine();

            int[][] dataArray = data.getData();
            for (int[] row : dataArray) {
                String[] rowValues = new String[row.length];
                for (int i = 0; i < row.length; i++) {
                    rowValues[i] = String.valueOf(row[i]);
                }
                writer.write(String.join(DELIMITER, rowValues));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData load(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = reader.readLine();
            String[] header = headerLine.split(DELIMITER);

            String dataLine;
            int[][] data = new int[0][];
            int rowIndex = 0;
            while ((dataLine = reader.readLine()) != null) {
                String[] rowValues = dataLine.split(DELIMITER);
                int[] rowData = new int[rowValues.length];
                for (int i = 0; i < rowValues.length; i++) {
                    rowData[i] = Integer.parseInt(rowValues[i]);
                }
                data = increaseCapacity(data, rowIndex + 1);
                data[rowIndex] = rowData;
                rowIndex++;
            }
            AppData appData = new AppData();
            appData.setHeader(header);
            appData.setData(data);
            return appData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int[][] increaseCapacity(int[][] array, int newSize) {
        int[][] newArray = new int[newSize][];
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));
        return newArray;
    }
}