import java.util.*;

/* 문제: 후보 추천하기 / 분류: 구현, 시뮬레이션 */
public class BOJ1713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] students = new int[M];
        for (int i = 0; i < M; i++) {
            students[i] = sc.nextInt();
        }
        int[] result = selectCandidate(N, M, students);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != N - 1)
                System.out.print(" ");
        }
        sc.close();
    }

    public static int[] selectCandidate(int n, int m, int[] s) {
        List<Candidate> candidates = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (findCandidate(candidates, s[i]))
                continue;
            if (candidates.size() == n) {
                Collections.sort(candidates);
                candidates.remove(0);
            }
            candidates.add(new Candidate(s[i], i));
        }
        int[] result = new int[candidates.size()];
        for (int i = 0; i < candidates.size(); i++) {
            result[i] = candidates.get(i).getNumber();
        }
        Arrays.sort(result);
        return result;
    }

    public static boolean findCandidate(List<Candidate> candidates, int n) {
        for (Candidate c : candidates) {
            if (n == c.getNumber()) {
                c.increaseRecommendNumber();
                return true;
            }
        }
        return false;
    }

    static class Candidate implements Comparable<Candidate> {
        private int number;
        private int order;
        private int recommendNumber;

        public Candidate(int number, int order) {
            this.number = number;
            this.order = order;
            this.recommendNumber = 1;
        }

        public int getNumber() {
            return this.number;
        }

        public void increaseRecommendNumber() {
            this.recommendNumber++;
        }

        @Override
        public int compareTo(Candidate c) {
            if (this.recommendNumber == c.recommendNumber)
                return this.order - c.order;
            else
                return this.recommendNumber - c.recommendNumber;
        }
    }
}