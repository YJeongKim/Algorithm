import java.io.*;
import java.util.*;

/* 문제: 키로거 / 분류: 스택, 덱, 연결 리스트 */
public class BOJ5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String result;
        for (int i = 0; i < n; i++) {
            result = findPassword(br.readLine());
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }

    public static String findPassword(String log) {
        StringBuilder pw = new StringBuilder();
        Stack<Character> fs = new Stack<>(), bs = new Stack<>();

        for (int i = 0; i < log.length(); i++) {
            char c = log.charAt(i);
            if (c == '<') {
                if (!fs.isEmpty()) bs.push(fs.pop());
            } else if (c == '>') {
                if (!bs.isEmpty()) fs.push(bs.pop());
            } else if (c == '-') {
                if (!fs.isEmpty()) fs.pop();
            } else {
                fs.push(c);
            }
        }
        while (!fs.isEmpty()) bs.push(fs.pop());
        while (!bs.isEmpty()) pw.append(bs.pop());
        return pw.toString();
    }
}