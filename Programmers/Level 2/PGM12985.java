/* 문제: 예상 대진표 / 분류: 2017 팁스타운 */
public class PGM12985 {
    public static void main(String[] args) {
        int[] N = { 8, 16, 4 };
        int[] A = { 4, 7, 1 };
        int[] B = { 7, 8, 4 };

        for (int i = 0; i < N.length; i++) {
            System.out.println(solution(N[i], A[i], B[i]));
        }
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = nextRoundNumber(a);
            b = nextRoundNumber(b);
            answer++;
        }
        return answer;
    }

    private static int nextRoundNumber(int n) {
        if (n % 2 == 1) n += 1;
        return n / 2;
    }
}