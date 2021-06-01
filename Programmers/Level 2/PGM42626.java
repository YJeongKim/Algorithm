import java.util.*;

/* ¹®Á¦: ´õ ¸Ê°Ô / ºÐ·ù: Èü(Heap) */
public class PGM42626 {
    public static void main(String[] args) {
        int[][] scoville = { { 1, 2, 3, 9, 10, 12 }, { 1, 3, 4, 7, 11, 15, 18 } };
        int[] k = { 7, 16 };

        for (int i = 0; i < scoville.length; i++) {
            System.out.println(solution(scoville[i], k[i]));
        }
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> food = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            food.offer(scoville[i]);
        }
        while (food.size() != 1) {
            answer++;
            int newFood = food.poll() + food.poll() * 2;
            food.offer(newFood);
            if (food.peek() >= K) break;
        }
        return food.peek() < K ? -1 : answer;
    }    
}