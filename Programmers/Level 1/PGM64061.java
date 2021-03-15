import java.util.*;

/* 문제: 크레인 인형뽑기 게임 / 분류: 2019 카카오 개발자 겨울 인턴십, 스택 */
public class PGM64061 {
    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, 
                { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();

        for (int m : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][m - 1] != 0) {
                    if (!basket.isEmpty() && basket.peek() == board[i][m - 1]) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(board[i][m - 1]);
                    }
                    board[i][m - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}