import java.io.*;
import java.util.*;

/* 문제: 미술가 미미 / 분류: 브루트포스, 백트래킹 */
/* 처음엔 MAX 조건을 못봐서 틀림, 두번째로 MIN 조건을 생각 못해서 틀렸음 */
public class BOJ20950 {
    private static final int MIN = 2;
    private static final int MAX = 7;
    private static boolean[] checked;
    private static int result = Integer.MAX_VALUE;
    private static int N;
    private static List<RGB> rgbList;
    private static RGB gomduri;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rgbList = new ArrayList<>();
        checked = new boolean[N];
        for (int i = 0; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rgbList.add(new RGB(r, g, b));
        }
        gomduri = rgbList.remove(N);
        int count = N < MAX ? N : MAX;
        for (int i = MIN; i <= count; i++) findMoonduri(0, i);
        System.out.println(result);
        br.close();
    }

    public static void findMoonduri(int start, int count) {
        if (count == 0) {
            RGB moonduri = calculateMoonduri();
            int difference = findDifferenceRGB(gomduri, moonduri);
            result = Math.min(result, difference);
            return;
        } else {
            for (int i = start; i < N; i++) {
                checked[i] = true;
                findMoonduri(i + 1, count - 1);
                checked[i] = false;
            }
        }
    }

    public static RGB calculateMoonduri() {
        int r = 0, g = 0, b = 0, c = 0;
        for (int i = 0; i < N; i++) {
            if (!checked[i]) continue;
            RGB rgb = rgbList.get(i);
            r += rgb.r;
            g += rgb.g;
            b += rgb.b;
            c++;
        }
        return new RGB(r / c, g / c, b / c);
    }

    public static int findDifferenceRGB(RGB rgb1, RGB rgb2) {
        return Math.abs(rgb1.r - rgb2.r) + Math.abs(rgb1.g - rgb2.g) + Math.abs(rgb1.b - rgb2.b);
    }

    private static class RGB {
        int r;
        int g;
        int b;

        public RGB(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }
}