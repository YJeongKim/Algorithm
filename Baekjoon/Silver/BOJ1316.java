import java.io.*;
import java.util.*;

/* 문제: 그룹 단어 체커 / 분류: 구현, 문자열 */
public class BOJ1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++)
            words[i] = br.readLine();
        int result = countGroupWord(words);
        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }

    public static int countGroupWord(String[] words) {
        int count = 0;

        for (String word : words) {
            if (isGroupWord(word))
                count++;
        }
        return count;
    }

    public static boolean isGroupWord(String word) {
        Set<Character> alphabet = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            if (!alphabet.add(word.charAt(i)) && word.charAt(i - 1) != word.charAt(i))
                return false;
        }
        return true;
    }
}