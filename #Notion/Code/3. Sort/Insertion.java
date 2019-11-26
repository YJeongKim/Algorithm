public class Insertion {
    private static int[] data = { 8, 4, 3, 7, 9, 5, 1, 10, 6 };

    private static void insertionSort(int[] data, int n) {
        int temp;

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) {
                    temp = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = temp;
                }
            }
        }
    }

    private static void insertionSort2(int[] data, int n) {
        int i, j, temp;

        for (i = 1; i < n; i++) {
            temp = data[i];
            for (j = i - 1; j >= 0; j--) {
                if (data[j] > temp) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
            }
            data[j + 1] = temp;
        }
    }

    private static void printArray(int[] data) {
        for (int d : data)
            System.out.print(d + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(data);
        insertionSort2(data, data.length);
        printArray(data);
    }
}