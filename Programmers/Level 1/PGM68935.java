/* 문제: 3진법 뒤집기 / 분류: 월간 코드 챌린지 시즌1 */
public class PGM68935 {
    public static void main(String[] args) {
        int[] n = { 45, 125 };

        for (int i = 0; i < n.length; i++) {
            System.out.println(solution(n[i]));
        }
    }

    public static int solution(int n) {
        String bit = convertToBit(n);
        int answer = calculateBit(bit);

        return answer;
    }

    public static String convertToBit(int n) {
        StringBuilder s = new StringBuilder();

        while (n > 0) {
            s.append(n % 3);
            n /= 3;
        }
        return s.reverse().toString();
    }

    public static int calculateBit(String bit) {
        int num = 0;

        for (int i = 0; i < bit.length(); i++) {
            num += Math.pow(3, i) * (bit.charAt(i) - '0');
        }
        return num;
    }
}