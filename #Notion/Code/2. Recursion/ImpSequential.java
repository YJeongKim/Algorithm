public class ImpSequential {
    public static void main(String[] args) {
        int n = 5;
        int[] data = { 4, 7, 1, 5, 9 };
        int result = search(data, n, 5);
        System.out.println("결과 : " + result);
    }

    public static int search(int[] data, int n, int target) {
        for (int i = 0; i < n; i++)
            if (data[i] == target)
                return i;
        return -1;
    }
}