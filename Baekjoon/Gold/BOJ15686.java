import java.io.*;
import java.util.*;

/* 문제: 치킨 배달 / 분류: 구현, 브루트포스 */
public class BOJ15686 {
    private static List<Point> houses;
    private static List<Point> chickens;
    private static boolean[] isOpen;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        houses = new ArrayList<Point>();
        chickens = new ArrayList<Point>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int spot = Integer.parseInt(st.nextToken());
                if (spot == 1) {
                    houses.add(new Point(i, j));
                } else if (spot == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }
        isOpen = new boolean[chickens.size()];
        findDistance(M, 0, 0);
        System.out.println(result);
        br.close();
    }

    public static void findDistance(int m, int start, int count) {
        for (int i = start; i < chickens.size(); i++) {
            if (isOpen[i]) continue;
            isOpen[i] = true;
            findDistance(m, i + 1, count + 1);
            isOpen[i] = false;
        }
        if (m == count) {
            int sum = 0;
            for (Point house : houses) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (!isOpen[i]) continue;
                    min = Math.min(min, calculateDistance(house, chickens.get(i)));
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }
    }

    public static int calculateDistance(Point p1, Point p2) {
        return Math.abs(p1.getR() - p2.getR()) + Math.abs(p1.getC() - p2.getC());
    }

    static class Point {
        private int r;
        private int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return this.r;
        }

        public int getC() {
            return this.c;
        }
    }
}