import java.util.Random;

public class ArraysHelper {

    public static void fillArrayWith01(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(2);
        }
    }

    public static void arrayReverb01(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else if (array[i] == 1) array[i] = 0;
        }
    }

    public static void fillAndReverb01(int[] array) {
        fillArrayWith01(array);
        arrayReverb01(array);
    }

    public static void fillArray1to100(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    public static void multiplyX2NumberLower6(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] = array[i] * 2;
        }
    }

    public static void fillDiagonal2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == j || i + j == array.length - 1) array[i][j] = 1;
            }
        }
    }

    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] createAndFillArrayWithNumber(int len, int number) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = number;
        }
        return array;
    }
}
