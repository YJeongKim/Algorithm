/* 문제: 큰 수 만들기 / 분류: 그리디 */
public class PGM42883 {
    public static void main(String[] args) {
        String[] number = { "1924", "1231234", "4177252841" };
        int[] k = { 2, 3, 4 };

        for (int i = 0; i < number.length; i++) {
            System.out.println(solution(number[i], k[i]));
        }
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        int maxIdx = -1;

        for (int i = 0; i < len - k; i++) {
            char maxNum = 0;
            for (int j = maxIdx + 1; j <= k + i; j++) {
                if (number.charAt(j) > maxNum) {
                    maxIdx = j;
                    maxNum = number.charAt(j);
                }
            }
            answer.append(maxNum);
        }
        return answer.toString();
    }
}