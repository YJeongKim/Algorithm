import java.util.*;

/* 문제: 실패율 / 분류: 2019 KAKAO BLIND RECRUITMENT */
public class PGM42889 {
    public static void main(String[] args) {
        int[] N = { 5, 4 };
        int[][] stages = { { 2, 1, 2, 6, 2, 4, 3, 3 }, { 4, 4, 4, 4, 4 } };

        for (int i = 0; i < N.length; i++) {
            int[] result = solution(N[i], stages[i]);
            for (int j = 0; j < result.length; j++)
                System.out.print(result[j] + " ");
            System.out.println();
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Stage[] stageStatus = new Stage[N];

        for (int i = 0; i < N; i++)
            stageStatus[i] = new Stage(i + 1);

        for (int s : stages) {
            if (s == N + 1) s = N;
            else stageStatus[s - 1].unclearPlayer++;
            for (int i = 0; i < s; i++) {
                stageStatus[i].reachedPlayer++;
            }
        }
        Arrays.sort(stageStatus);
        for (int i = 0; i < N; i++)
            answer[i] = stageStatus[i].number;
        return answer;
    }

    static class Stage implements Comparable<Stage> {
        int number;
        int unclearPlayer;
        int reachedPlayer;
        double rate;

        public Stage(int number) {
            this.number = number;
            this.unclearPlayer = 0;
            this.reachedPlayer = 0;
            this.rate = 0;
        }

        public void updateRate() {
            rate = reachedPlayer == 0 ? 0 : (double) unclearPlayer / this.reachedPlayer;
        }

        @Override
        public int compareTo(Stage s) {
            double rate1 = (this.reachedPlayer == 0) ? 0 : (double) this.unclearPlayer / this.reachedPlayer;
            double rate2 = (s.reachedPlayer == 0) ? 0 : (double) s.unclearPlayer / s.reachedPlayer;

            if (rate1 < rate2) {
                return 1;
            } else if (rate1 == rate2) {
                if (this.number > s.number) {
                    return 1;
                }
            }
            return -1;
        }
    }
}