import java.io.*;
import java.util.*;

/* 문제: 괄호 / 분류: 자료구조, 문자열, 스택 */
public class BOJ9012 {
    private static final String Y = "YES";
    private static final String N = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            bw.write(validateVPS(br.readLine()) + "\n");
        }
        br.close();
        bw.close();
    }

    public static String validateVPS(String ps) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < ps.length(); i++) {
            if (ps.charAt(i) == '(')
                s.push('(');
            else {
                if (s.isEmpty())
                    return N;
                s.pop();
            }
        }
        return s.isEmpty() ? Y : N;
    }
}