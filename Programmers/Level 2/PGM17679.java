/* 문제: 프렌즈4블록 / 분류: 2018 KAKAO BLIND RECRUITMENT, 구현 */
public class PGM17679 {
    private static char[][] map;
    private static boolean[][] check;

    public static void main(String[] args) {
        int[] m = { 4, 6, 5 };
        int[] n = { 5, 6, 5 };
        String[][] board = { { "CCBDE", "AAADE", "AAABF", "CCBBF" },
                { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" },
                { "AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA" } };

        for (int i = 0; i < board.length; i++) {
            System.out.println(solution(m[i], n[i], board[i]));
        }
    }

    public static int solution(int m, int n, String[] board) {
        map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        while (true) {
            check = new boolean[m][n];
            checkBlock(m, n);
            if (!canRemoveBlock(m, n)) break;
            removeBlock(m, n);
        }
        return countBlock(m, n);
    }

    private static void checkBlock(int m, int n) {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                int v = map[i][j];
                if (map[i][j] == ' ') continue;
                if (!(v == map[i][j + 1] && v == map[i + 1][j] && v == map[i + 1][j + 1])) continue;
                check[i][j] = true;
                check[i + 1][j] = true;
                check[i][j + 1] = true;
                check[i + 1][j + 1] = true;
            }
        }
    }

    private static boolean canRemoveBlock(int m, int n) {
        boolean flag = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j]) {
                    map[i][j] = ' ';
                    flag = true;
                }
            }
        }
        return flag;
    }

    private static void removeBlock(int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (map[j][i] != ' ') continue;
                for (int k = j - 1; k >= 0; k--) {
                    if (map[k][i] == ' ') continue;
                    map[j][i] = map[k][i];
                    map[k][i] = ' ';
                    break;
                }
            }
        }
    }

    private static int countBlock(int m, int n) {
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (map[i][j] == ' ') count++;
        }
        return count;
    }
}