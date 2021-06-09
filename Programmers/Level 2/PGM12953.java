/* 문제: N개의 최소공배수 / 분류: 연습문제, 수학 */
public class PGM12953 {
    public static void main(String[] args) {
        int[][] arr = { { 2, 6, 8, 14 }, { 1, 2, 3 }, { 5 } };

        for (int i = 0; i < arr.length; i++) {
            System.out.println(solution(arr[i]));
        }
    }

    public static int solution(int[] arr) {
        int len = arr.length;

        if (len == 1) return arr[0];
        for (int i = 1; i < len; i++) {
            arr[i] = lcm(arr[i - 1], arr[i]);
        }
        return arr[len - 1];
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}