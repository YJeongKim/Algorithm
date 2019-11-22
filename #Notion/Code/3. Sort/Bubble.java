public class Bubble {
    private static int[] data = { 8, 4, 3, 7, 9, 5, 1 };

    private static void bubbleSort(int[] data, int n) {
        int temp;

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    private static void printArray(int[] data) {
        for (int d : data)
            System.out.print(d + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(data);
        bubbleSort(data, data.length);
        printArray(data);
    }
    
}