import java.io.*;
import java.util.*;

/* 문제: 현수막 / 분류: 그래프 탐색, DFS, BFS */
public class BOJ14716 {
    private static int[][] banner;
    private static boolean[][] checked;
    private static int M, N, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        banner = new int[M][N];
        checked = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                banner[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (checked[i][j] || banner[i][j] == 0) continue;
                searchLetter(i, j);
                result++;
            }
        }
        bw.write(String.valueOf(result));
        br.close();
        bw.close();
    }

    public static void searchLetter(int i, int j) {
        checked[i][j] = true;
        if (i - 1 >= 0 && !checked[i - 1][j] && banner[i - 1][j] == 1)
            searchLetter(i - 1, j); // up
        if (i + 1 < M && !checked[i + 1][j] && banner[i + 1][j] == 1)
            searchLetter(i + 1, j); // down
        if (j - 1 >= 0 && !checked[i][j - 1] && banner[i][j - 1] == 1)
            searchLetter(i, j - 1); // left
        if (j + 1 < N && !checked[i][j + 1] && banner[i][j + 1] == 1)
            searchLetter(i, j + 1); // right
        if (i - 1 >= 0 && j - 1 >= 0 && !checked[i - 1][j - 1] && banner[i - 1][j - 1] == 1)
            searchLetter(i - 1, j - 1); // up & left
        if (i - 1 >= 0 && j + 1 < N && !checked[i - 1][j + 1] && banner[i - 1][j + 1] == 1)
            searchLetter(i - 1, j + 1); // up & right
        if (i + 1 < M && j - 1 >= 0 && !checked[i + 1][j - 1] && banner[i + 1][j - 1] == 1)
            searchLetter(i + 1, j - 1); // down & left
        if (i + 1 < M && j + 1 < N && !checked[i + 1][j + 1] && banner[i + 1][j + 1] == 1)
            searchLetter(i + 1, j + 1); // down & right
    }
}