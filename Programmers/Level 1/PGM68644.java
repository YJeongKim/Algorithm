import java.util.*;

/* 문제: 두 개 뽑아서 더하기 / 분류: 월간 코드 챌린지 시즌1 */
public class PGM68644 {
    public static void main(String[] args) {
        int[][] numbers = { { 2, 1, 3, 4, 1 }, { 5, 0, 2, 7 } };

        for (int[] number : numbers) {
            for (int r : solution(number)) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

    public static int[] solution(int[] numbers) {
        int n = numbers.length;
        TreeSet<Integer> sumList = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sumList.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[sumList.size()];
        int i = 0;
        Iterator<Integer> it = sumList.iterator();

        while (it.hasNext()) {
            answer[i++] = (Integer) it.next();
        }
        return answer;
    }
}