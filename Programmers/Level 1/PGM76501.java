/* 문제: 음양 더하기 / 분류: 월간 코드 챌린지 시즌2 */
public class PGM76501 {
    public static void main(String[] args) {
        int[][] absolutes = { { 4, 7, 12 }, { 1, 2, 3 } };
        boolean[][] signs = { { true, false, true }, { false, false, true } };

        for (int i = 0; i < absolutes.length; i++) {
            System.out.println(solution(absolutes[i], signs[i]));
        }
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = absolutes.length;

        for (int i = 0; i < len; i++) {
            if (signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }
        return answer;
    }
}