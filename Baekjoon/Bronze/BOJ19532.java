import java.io.*;
import java.util.*;

/* 문제: 수학은 비대면강의입니다 / 분류: 수학, 브루트포스 */
public class BOJ19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] abc = new int[3], def = new int[3];
        for (int i = 0; i < 3; i++)
            abc[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++)
            def[i] = Integer.parseInt(st.nextToken());
        // 수학 버전
        int x = findX(abc, def);
        int y = findY(abc, def, x);
        bw.write(x + " " + y);
        // 완전탐색 버전
        int[] xy = exhaustiveSearch(abc, def);
        bw.write("\n" + xy[0] + " " + xy[1]);
        br.close();
        bw.close();
    }

    public static int findX(int[] abc, int[] def) {
        int[] t = new int[3];

        for (int i = 0; i < 3; i++)
            t[i] = abc[i] * def[1] - def[i] * abc[1];
        return t[0] == 0 ? 0 : t[2] / t[0];
    }

    public static int findY(int[] abc, int[] def, int x) {
        return abc[1] == 0 ? (def[1] == 0 ? 0 : (def[2] - def[0] * x) / def[1]) : (abc[2] - abc[0] * x) / abc[1];
    }

    public static int[] exhaustiveSearch(int[] abc, int[] def) {
        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if (abc[0] * i + abc[1] * j == abc[2] && def[0] * i + def[1] * j == def[2]) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { 0, 0 };
    }
}