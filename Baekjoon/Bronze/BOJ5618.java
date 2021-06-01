import java.io.*;
import java.util.*;

/* 문제: 공약수 / 분류: 수학 */
public class BOJ5618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            number[i] = Integer.parseInt(st.nextToken());
        List<Integer> result = findCommonDivisor(n, number);
        for (int r : result) System.out.println(r);
        br.close();
    }

    public static List<Integer> findCommonDivisor(int n, int[] number) {
        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++)
            min = min < number[i] ? min : number[i];
        
        for (int i = 1; i <= min; i++) {
            if (!isDivide(number, i)) continue;
            result.add(i);
        }
        return result;
    }

    public static boolean isDivide(int[] number, int divNum) {
        for (int i = 0, n = number.length; i < n; i++) {
            if (number[i] % divNum != 0)
                return false;
        }
        return true;
    }
}