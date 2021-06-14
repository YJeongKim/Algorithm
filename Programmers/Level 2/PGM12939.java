import java.util.*;

/* 문제: 최댓값과 최솟값 / 분류: 연습문제 */
public class PGM12939 {
    public static void main(String[] args) {
        String[] sArr = { "1 2 3 4", "-1 -2 -3 -4", "-1 -1" };

        for (String s : sArr) {
            System.out.println(solution(s));
        }
    }

    public static String solution(String s) {
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s);

        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numbers);
        return numbers.get(0) + " " + numbers.get(numbers.size() - 1);
    }
}