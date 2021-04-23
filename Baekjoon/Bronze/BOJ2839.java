import java.util.Scanner;

/* 문제: 설탕 배달 / 분류: 그리디, DP */
public class BOJ2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = findMinNumBags(N);
        System.out.println(result);
        sc.close();
    }

    public static int findMinNumBags(int n) {
        int count = 0;
        while(n % 5 != 0) {
            n -= 3;
            count++;
            if(n < 0) return -1;
        }
        count += n / 5;
        return count;
    }
}