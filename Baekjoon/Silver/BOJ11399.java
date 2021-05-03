import java.util.*;

/* 문제: ATM / 분류: 그리디, 정렬 */
public class BOJ11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }
        int result = findMinTime(N, P);
        System.out.println(result);
        sc.close();
    }

    public static int findMinTime(int n, int[] p) {
        int total = 0, sum = 0;
        Arrays.sort(p);
        for (int i = 0; i < n; i++) {
            sum += p[i];
            total += sum;
        }
        return total;
    }
}