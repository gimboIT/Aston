import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppData data = new AppData();
        data.setHeader(new String[] { "Column1", "Column2", "Column3" });
        data.setData(new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        });

        String filePath = "data.csv";

        // Сохранение данных в CSV файл
        CSVDataManager.save(data, filePath);

        // Загрузка данных из CSV файла
        AppData loadedData = CSVDataManager.load(filePath);

        // Вывод заголовка и данных
        if (loadedData != null) {
            System.out.println("Header: " + String.join(", ", loadedData.getHeader()));
            System.out.println("Data:");
            int[][] loadedDataArray = loadedData.getData();
            for (int[] row : loadedDataArray) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}
