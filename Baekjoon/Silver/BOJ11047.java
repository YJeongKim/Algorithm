import java.util.Scanner;

/* 문제: 동전 0 / 분류: 그리디 */
public class BOJ11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int result = findMinNumCoin(N, K, A);
        System.out.println(result);
        sc.close();
    }

    public static int findMinNumCoin(int n, int k, int[] a) {
        int count = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (k == 0) break;
            if (k / a[i] > 0) {
                count += k / a[i];
                k %= a[i];
            }
        }
        return count;
    }
}