/* 문제: 2 x n 타일링 / 분류: 연습문제, DP */
public class PGM12900 {
    private static final int MOD_NUM = 1000000007;

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(10));
        System.out.println(solution(17));
    }
    
    public static int solution(int n) {
        int answer = 0;
        int one = 1, two = 2;

        if (n <= 2)
            return n;
        for (int i = 3; i < n; i++) {
            answer = (one + two) % MOD_NUM;
            one = two;
            two = answer;
        }
        answer = (one + two) % MOD_NUM;
        return answer;
    }

    public static int dfs(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        else return dfs(n - 1) + dfs(n - 2) % MOD_NUM;
    }
}