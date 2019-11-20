public class ImpFindMax {
    public static void main(String[] args) {
        int n = 6;
        int[] data = { 3, 2, 6, 7, 9, 1 };
        int result = findMax(data, n);
        System.out.println("결과 : " + result);
    }

    public static int findMax(int[] data, int n) {
        int max = -1;
        for (int i = 0; i < n; i++)
            if (data[i] > max)
                max = data[i];
        return max;
    }
}