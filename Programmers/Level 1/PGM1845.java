import java.util.*;

/* 문제: 폰켓몬 / 분류: 찾아라 프로그래밍 마에스터 */
public class PGM1845 {
    public static void main(String[] args) {
        int[][] nums = { { 3, 1, 2, 3 }, { 3, 3, 3, 2, 2, 4 }, { 3, 3, 3, 2, 2, 2 } };

        for (int i = 0; i < nums.length; i++) {
            System.out.println(solution(nums[i]));
        }
    }

    public static int solution(int[] nums) {
        int n = nums.length;
        List<Integer> pkm = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (pkm.size() == n / 2) break;
            if (pkm.contains(nums[i])) continue;
            pkm.add(nums[i]);
        }
        return pkm.size();
    }
}