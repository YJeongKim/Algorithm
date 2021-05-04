import java.util.*;

/* 문제: 수 찾기 / 분류: 이분 탐색 */
public class BOJ1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }
        printResult(N, A, M, B);
        sc.close();
    }

    public static void printResult(int n, int[] a, int m, int[] b) {
        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            int result = binarySearch(a, b[i], 0, n - 1) ? 1 : 0;
            System.out.println(result);
        }
    }

    public static boolean binarySearch(int[] a, int target, int start, int end) {
        if (start > end)
            return false;
        int mid = (start + end) / 2;
        if (a[mid] == target)
            return true;
        else if (a[mid] > target)
            return binarySearch(a, target, start, mid - 1);
        else
            return binarySearch(a, target, mid + 1, end);
    }
}