/* 문제: 정수 제곱근 판별 / 분류: 연습문제 */
public class PGM12934 {
    public static void main(String[] args) {
        long[] numbers = { 121, 3, 225, 10000 };

        for (long n : numbers) {
            System.out.println(solution(n));
        }
    }

    public static long solution(long n) {
        long answer = -1;
        
        if (Math.sqrt(n) % 1 == 0) {
            answer = (long) Math.pow(Math.sqrt(n) + 1, 2);
        }
        return answer;
    }
}