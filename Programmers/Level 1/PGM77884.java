import java.util.*;

/* ����: ����� ������ ���� / �з�: ���� �ڵ� ç���� ����2 */
public class PGM77884 {
    public static void main(String[] args) {
        int[] left = { 13, 24 }, right = { 17, 27 };

        for (int i = 0; i < left.length; i++) {
            System.out.println(solution(left[i], right[i]));
        }
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int count = findDivisorCount(i);
            if (count % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }

    private static int findDivisorCount(int number) {
        Set<Integer> divisor = new HashSet<>();

        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divisor.add(i);
                divisor.add(number / i);
            }
        }
        return divisor.size();
    }
}