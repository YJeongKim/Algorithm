/* 문제: 카펫 / 분류: 완전탐색 */
public class PGM42842 {
    public static void main(String[] args) {
        int[] brown = { 10, 8, 24 };
        int[] yellow = { 2, 1, 24 };

        for (int i = 0; i < brown.length; i++) {
            int[] result = solution(brown[i], yellow[i]);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    public static int[] solution(int brown, int yellow) {
        int carpet = brown + yellow;
        int w = 1, h = 1;

        for (int i = 1; i <= carpet; i++) {
            if (carpet % i != 0) continue;
            h = i;
            w = carpet / i;
            if (((w + h) * 2 - 4) == brown) break;
        }
        return new int[] { w, h };
    }
}