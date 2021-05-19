/* 문제: 내적 / 분류: 월간 코드 챌린지 시즌1 */
public class PGM70128 {
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 4 }, { -1, 0, 1 } };
        int[][] b = { { -3, -1, 0, 2 }, { 1, 0, -1 } };

        for (int i = 0; i < a.length; i++) {
            System.out.println(solution(a[i], b[i]));
        }
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}