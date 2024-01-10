public class Arrays {
    public static int sumTwoDimensionalArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4 || array[0].length != 4)
            throw new MyArraySizeException("Your array not 4x4");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Not digit " + i + " " + j);
                }
            }
        }
        return sum;
    }
}
