/* 문제: 2개 이하로 다른 비트 / 분류: 월간 코드 챌린지 시즌2 */
public class PGM77885 {
    public static void main(String[] args) {
        long[][] numbers = { { 2, 7 }, { 9 } };

        for (int i = 0; i < numbers.length; i++) {
            long[] result = solution(numbers[i]);
            for (int j = 0; j < result.length; j++)
                System.out.print(result[j] + " ");
            System.out.println();
        }
    }

    public static long[] solution(long[] numbers) {
        int n = numbers.length;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = findOtherBit(numbers[i]);
        }
        return answer;
    }

    public static long findOtherBit(long number) {
        String bit = Long.toBinaryString(number);
        int lastIdx = bit.lastIndexOf("0");

        if (lastIdx == bit.length() - 1) {
            return number + 1;
        }
        if (lastIdx == -1) {
            bit = getBit(bit);
        } else {
            String sub = bit.substring(lastIdx + 1);
            bit = bit.substring(0, lastIdx) + getBit(sub);
        }
        return Long.parseLong(bit, 2);
    }

    public static String getBit(String b) {
        StringBuilder s = new StringBuilder("10");

        for (int i = 0; i < b.length() - 1; i++) {
            s.append("1");
        }
        return s.toString();
    }
}