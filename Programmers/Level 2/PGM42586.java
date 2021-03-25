import java.util.*;

/* 문제: 기능개발 / 분류: 스택, 큐 */
public class PGM42586 {
    private static Queue<Integer> deployment = new LinkedList<Integer>();

    public static void main(String[] args) {
        int[][] progresses = {{93, 30, 55}, {95, 90, 99, 99, 80, 99}};
        int[][] speeds = { { 1, 30, 5 }, { 1, 1, 1, 1, 1, 1 } };
        
        for (int i = 0; i < progresses.length; i++) {
            for (int r : solution(progresses[i], speeds[i])) System.out.print(r + " ");
            System.out.println();
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<Integer>();
        int n = progresses.length;
        int days = 0;

        for (int i = 0; i < n; i++) {
            int work = 0;
            int progressRate = progresses[i];

            while (progressRate < 100) {
                progressRate += speeds[i];
                work++;
            }

            if (deployment.isEmpty()) days = work;

            if (!deployment.isEmpty() && days < work) {
                answerList.add(countDeployment());
                days = work;
            }
            deployment.offer(progresses[i]);
        }
        answerList.add(countDeployment());

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    private static int countDeployment() {
        int count = 0;
        while (!deployment.isEmpty()) {
            deployment.poll();
            count++;
        }
        return count;
    }
}