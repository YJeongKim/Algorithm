/* 문제: 최대공약수와 최소공배수 / 분류: 연습문제, 수학 */
public class PGM12940 {
    public static void main(String[] args) {
        int[] n = { 3, 2 }, m = { 12, 5 };

        for (int i = 0; i < n.length; i++) {
            int[] result = solution(n[i], m[i]);
            System.out.println(result[0] + ", " + result[1]);
        }
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        if (n < m) {
            int t = n;
            n = m;
            m = t;
        }
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m, answer[0]);
        return answer;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    private static int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
}