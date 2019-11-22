public class Selection {
    private static int[] data = { 8, 4, 3, 7, 9, 5, 1 };

    private static void minSelectionSort(int[] data, int n) {
        int min, temp;

        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (data[min] > data[j])
                    min = j;
            }
            temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
    }

    private static void maxSelectionSort(int[] data, int n) {
        int max, temp;

        for (int i = n - 1; i > 0; i--) {
            max = i;
            for (int j = i - 1; j >= 0; j--) {
                if (data[max] < data[j])
                    max = j;
            }
            temp = data[i];
            data[i] = data[max];
            data[max] = temp;
        }
    }

    private static void printArray(int[] data) {
        for (int d : data)
            System.out.print(d + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(data);
        maxSelectionSort(data, data.length);
        printArray(data);
    }

}