import java.io.*;
import java.util.*;

/* 문제: 암호 만들기 / 분류: 브루트포스, 조합론, 백트래킹 */
public class BOJ1759 {
    private static int L, C;
    private static char[] A;
    private static boolean[] visited;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new char[C];
        visited = new boolean[C];
        result = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            A[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(A);
        createPassword(0, 0, 0, 0);
        System.out.print(result);
        br.close();
    }

    public static void createPassword(int consonant, int vowel, int start, int count) {
        if (L == count) {
            if (consonant >= 2 && vowel >= 1) {
                for (int i = 0; i < C; i++) {
                    if (!visited[i]) continue;
                    result.append(A[i]);
                }
                result.append('\n');
            }
            consonant = 0;
            vowel = 0;
            return;
        }
        for (int i = start; i < C; i++) {
            visited[i] = true;
            if (A[i] == 'a' || A[i] == 'e' || A[i] == 'i' || A[i] == 'o' || A[i] == 'u')
                createPassword(consonant, vowel + 1, i + 1, count + 1);
            else
                createPassword(consonant + 1, vowel, i + 1, count + 1);
            visited[i] = false;
        }
    }
}