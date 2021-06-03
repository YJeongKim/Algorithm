import java.io.*;

/* 문제: 그대로 출력하기 / 분류: 구현, 문자열 */
public class BOJ11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String s = br.readLine();
            if (s == null || s.length() == 0)
                break;
            bw.write(s + "\n");
        }
        br.close();
        bw.close();
    }
}