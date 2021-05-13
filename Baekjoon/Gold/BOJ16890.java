import java.io.*;
import java.util.*;

/* 문제: 창업 / 분류: 문자열 */
public class BOJ16890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String preferFront = br.readLine();
        String preferBack = br.readLine();
        int N = preferFront.length();
        String result = nameCompany(N, preferFront, preferBack);
        System.out.println(result);
        br.close();
    }

    public static String nameCompany(int n, String preferFront, String preferBack) {
        StringBuilder result = new StringBuilder();
        Stack<Character> tempResult = new Stack<>();
        Deque<Character> frontQ = new ArrayDeque<>();
        Deque<Character> backQ = new ArrayDeque<>();
        char[] tempFront = preferFront.toCharArray();
        char[] tempBack = preferBack.toCharArray();
        boolean turn = false; // false: 구사과, true: 큐브러버

        Arrays.sort(tempFront);
        Arrays.sort(tempBack);
        for (int i = 0; i < (n + 1) / 2; i++)
            frontQ.offer(tempFront[i]);
        for (int i = 0; i < n / 2; i++)
            backQ.offer(tempBack[n - 1 - i]);

        for (int i = 0; i < n; i++) {
            if (!turn) {
                if (backQ.isEmpty() || frontQ.peekFirst() < backQ.peekFirst())
                    result.append(frontQ.pollFirst());
                else tempResult.push(frontQ.pollLast());
            } else {
                if (frontQ.isEmpty() || frontQ.peekFirst() < backQ.peekFirst())
                    result.append(backQ.pollFirst());
                else tempResult.push(backQ.pollLast());
            }
            turn = !turn;
        }
        while (!tempResult.isEmpty())
            result.append(tempResult.pop());
        return result.toString();
    }
}