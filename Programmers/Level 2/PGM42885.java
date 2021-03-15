import java.util.*;

/* 문제: 구명보트 / 분류: 그리디 */
public class PGM42885 {
    public static void main(String[] args) {
        int[][] peoples = { { 70, 50, 80, 50 }, { 70, 80, 50 } };

        for (int[] people : peoples) {
            System.out.println(solution(people, 100));
        }
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0, end = people.length - 1;

        Arrays.sort(people);
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            answer++;
        }
        return answer;
    }
}