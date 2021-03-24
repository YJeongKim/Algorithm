/* 문제: 타겟 넘버 / 분류: DFS, BFS */
public class PGM43165 {
    private static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = { 1, 1, 1, 1, 1 };

        System.out.println(solution(numbers, 3));
    }

    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public static void dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) {
            if (target == sum) answer++;
            return;
        }
        dfs(numbers, target, idx + 1, sum - numbers[idx]);
        dfs(numbers, target, idx + 1, sum + numbers[idx]);
    }
}