public class Merge {
    private static int[] data = { 8, 4, 7, 3, 9, 5, 1 };

    private static void mergeSort(int data[], int p, int r) {
        int q;

        if (p < r) {
            q = (p + r) / 2;
            mergeSort(data, p, q);
            mergeSort(data, q + 1, r);
            merge(data, p, q, r);
        }
    }

    private static void merge(int data[], int p, int q, int r) {
        int i = p, j = q + 1, k = p;
        int temp[] = new int[data.length];

        while (i <= q && j <= r) {
            if (data[i] <= data[j])
                temp[k++] = data[i++];
            else
                temp[k++] = data[j++];
        }
        while (i <= q)
            temp[k++] = data[i++];
        while (j <= r)
            temp[k++] = data[j++];
        for (i = p; i <= r; i++)
            data[i] = temp[i];
    }

    private static void printArray(int[] data) {
        for (int d : data)
            System.out.print(d + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(data);
        mergeSort(data, 0, data.length-1);
        printArray(data);
    }

}